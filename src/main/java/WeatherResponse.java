import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherResponse {

    public String toString(){
        return "Weather: ("+
                "WeatherText "+ weatherText+ '\''+
                "Date "+ date+'\''+
                "Temperature "+temperature+")";

    }
    @JsonProperty(value = "WeatherText")
    private String weatherText;

    @JsonProperty(value = "Date")
    private String date;

    @JsonProperty(value = "Temperature")
    private String temperature;



}
