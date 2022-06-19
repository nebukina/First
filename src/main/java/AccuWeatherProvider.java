
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String FORECAST_PERIOD = "5day";
    private static final String FORECAST_TYPE = "daily";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();
    private static final ObjectMapper responseMapper = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String getWeather(Periods periods) throws IOException {

        if (periods.equals(Periods.NOW)) {
            String cityKey = detectCityKey();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String weatherList = client.newCall(request).execute().body().string();
            List<WeatherResponse> weatherResponseList = responseMapper.readValue(weatherList, new TypeReference<List<WeatherResponse>>() {
            });
            //Response response = client.newCall(request).execute();
            WeatherResponse weatherResponse = weatherResponseList.get(0);
            System.out.println("t:" + weatherResponse.getTemperature() + "message" +
                    weatherResponse.getWeatherText());
            //System.out.println(response.body().string());
            // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
            //  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
            //  Вывести пользователю только текущую температуру в C и сообщение (weather text)
        }

        if (periods.equals(Periods.FIVE_DAYS)) {
            String cityKey = detectCityKey();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST)
                    .addPathSegment(FORECAST_TYPE)
                    .addPathSegment(FORECAST_PERIOD)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("metric", "true")
                    .addQueryParameter("language", "ru-ru")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String weatherList = client.newCall(request).execute().body().string();
            int first = weatherList.indexOf("[{\"Date\"");
            int last = weatherList.lastIndexOf("}");
            weatherList = weatherList.substring(first, last);

            List<WeatherResponse> weatherResponseList = objectMapper.readValue(weatherList, new TypeReference<List<WeatherResponse>>() {
            });

            for (WeatherResponse weather : weatherResponseList) {
                System.out.println("t:" + weather.getTemperature() + "message" +
                        weather.getWeatherText());
            }
        }

            public String detectCityKey() throws IOException {
                String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

                HttpUrl detectLocationURL = new HttpUrl.Builder()
                        .scheme("http")
                        .host(BASE_HOST)
                        .addPathSegment("locations")
                        .addPathSegment(API_VERSION)
                        .addPathSegment("cities")
                        .addPathSegment("autocomplete")
                        .addQueryParameter("apikey", API_KEY)
                        .addQueryParameter("q", selectedCity)
                        .build();

                Request request = new Request.Builder()
                        .addHeader("accept", "application/json")
                        .url(detectLocationURL)
                        .build();

                Response response = client.newCall(request).execute();

                if (!response.isSuccessful()) {
                    throw new IOException("Невозможно прочесть информацию о городе. " +
                            "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
                }
                String jsonResponse = response.body().string();
                System.out.println("Произвожу поиск города " + selectedCity);

                if (objectMapper.readTree(jsonResponse).size() > 0) {
                    String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
                    String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
                    System.out.println("Найден город " + cityName + " в стране " + countryName);
                } else throw new IOException("Server returns 0 cities");

                return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
            }


    }
}
