import ru.geekbrains.qa.java2.lesson8.homeWork.entity.WeatherData;
import ru.geekbrains.qa.java2.lesson8.homeWork.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException, SQLException;

    List<WeatherData> getAllFromDb() throws IOException, SQLException;
}
