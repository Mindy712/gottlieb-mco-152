package gottlieb.weather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCurrentWeather
{
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?zip=10901&appid=01c14db89e0dee38c1ff0dc55c46bab7&units=imperial");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

        System.out.println(currentWeather.name);
        System.out.println(currentWeather.main.temp);
        System.out.println(currentWeather.weather.toString());

    }

}
