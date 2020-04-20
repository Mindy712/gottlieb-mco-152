package gottlieb.weather;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherFrame extends JFrame {
    private static String userZip = "10901";

    CurrentWeather currentWeather = getData();

    private JLabel chooseLocationLabel;
    private JTextField zipcode;
    private JButton enterZip;
    private JLabel locationLabel;
    private JLabel location;
    private JLabel tempLabel;
    private JLabel temp;
    private JLabel feelsLikeLabel;
    private JLabel feelsLike;
    private JLabel precip;
    private JLabel description;


    public WeatherFrame() throws IOException {
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weather");

        setLayout(new BorderLayout());

        JPanel locationFrame = new JPanel();
        add(locationFrame, BorderLayout.CENTER);
        locationFrame.setLayout(new GridLayout(6, 1, 0, 5));


        JPanel chooseLocationFrame = new JPanel();
        locationFrame.add(chooseLocationFrame);

        chooseLocationLabel = new JLabel("Choose location (zipcode): ");
        chooseLocationFrame.add(chooseLocationLabel);
        zipcode = new JTextField(5);
        chooseLocationFrame.add(zipcode);
        enterZip = new JButton("Get Weather");
        chooseLocationFrame.add(enterZip);
        enterZip.addActionListener(actionEvent ->
        {
            try {
                userZip = zipcode.getText();
                currentWeather = WeatherFrame.getData();
                location.setText(currentWeather.name);
                temp.setText(String.valueOf(currentWeather.main.temp) + " F");
                precip.setText(currentWeather.weather[0].main);
                description.setText(currentWeather.weather[0].description);
                feelsLike.setText(String.valueOf(currentWeather.main.feels_like) + " F");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        JPanel displayLocation = new JPanel();
        locationFrame.add(displayLocation);

        locationLabel = new JLabel("Location: ");
        displayLocation.add(locationLabel);
        location = new JLabel(currentWeather.name);
        displayLocation.add(location);


        JPanel tempPanel = new JPanel();
        locationFrame.add(tempPanel);

        tempLabel = new JLabel("Temperature: ");
        tempPanel.add(tempLabel);
        temp = new JLabel(String.valueOf(currentWeather.main.temp) + " F");
        tempPanel.add(temp);


        JPanel feelsLikePanel = new JPanel();
        locationFrame.add(feelsLikePanel);

        feelsLikeLabel = new JLabel("Feels like: ");
        feelsLikePanel.add(feelsLikeLabel);
        feelsLike = new JLabel(String.valueOf(currentWeather.main.feels_like) + " F");
        feelsLikePanel.add(feelsLike);


        JPanel precipPanel = new JPanel();
        locationFrame.add(precipPanel);

        precip = new JLabel(currentWeather.weather[0].main);
        precipPanel.add(precip);


        JPanel descriptPanel = new JPanel();
        locationFrame.add(descriptPanel);

        description = new JLabel(currentWeather.weather[0].description);
        descriptPanel.add(description);
    }

    private static CurrentWeather getData() throws IOException {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?zip=" +
                userZip + "&appid=01c14db89e0dee38c1ff0dc55c46bab7&units=imperial";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        return gson.fromJson(reader, CurrentWeather.class);

    }

    public static void main(String[] args) throws IOException{
        new WeatherFrame().setVisible(true);
    }
}
