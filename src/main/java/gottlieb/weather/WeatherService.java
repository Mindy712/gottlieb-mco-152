package gottlieb.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("data/2.5/weather?appid=01c14db89e0dee38c1ff0dc55c46bab7&units=imperial")
    Call<CurrentWeather> getWeather(@Query("zip") String zip);
}
