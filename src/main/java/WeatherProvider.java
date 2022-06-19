import java.io.IOException;

public interface WeatherProvider {

    public String getWeather(Periods period) throws IOException;
}
