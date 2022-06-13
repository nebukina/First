import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Weather {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day/578111")//N.Novgorod
                .addQueryParameter("apikey","b0sTvVHfGnPnA5d0JeDfjudxGWvP2LjD")
                .addQueryParameter("language","ru-ru")
                .addQueryParameter("details","true")
                .addQueryParameter("metric","true")
                .build();

        System.out.println(url.toString());

        Request requesthttp = new Request.Builder()
                .addHeader("accept","/applicatin.json")
                .url(url)
                .build();
        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);


       // "ID": "NIZ",
         //       "LocalizedName": "Нижний Новгород",
           //     "EnglishName": "Nizhniy Novgorod",
             //   "Level": 1,
               // "LocalizedType": "Область",
                //"EnglishType": "Oblast",
                //"CountryID": "RU"
        //"Key": "578111",
    }
}
