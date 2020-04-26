package gottlieb.weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WeatherFrame extends JFrame {
    private static String userZip = "10901";

    {
        try {
            getData(userZip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        enterZip.addActionListener(actionEvent -> {
                    try {
                        getData(userZip = zipcode.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


        JPanel displayLocation = new JPanel();
        locationFrame.add(displayLocation);

        locationLabel = new JLabel("Location: ");
        displayLocation.add(locationLabel);
        location = new JLabel();
        displayLocation.add(location);


        JPanel tempPanel = new JPanel();
        locationFrame.add(tempPanel);

        tempLabel = new JLabel("Temperature: ");
        tempPanel.add(tempLabel);
        temp = new JLabel();
        tempPanel.add(temp);


        JPanel feelsLikePanel = new JPanel();
        locationFrame.add(feelsLikePanel);

        feelsLikeLabel = new JLabel("Feels like: ");
        feelsLikePanel.add(feelsLikeLabel);
        feelsLike = new JLabel();
        feelsLikePanel.add(feelsLike);


        JPanel precipPanel = new JPanel();
        locationFrame.add(precipPanel);

        precip = new JLabel();
        precipPanel.add(precip);


        JPanel descriptPanel = new JPanel();
        locationFrame.add(descriptPanel);

        description = new JLabel();
        descriptPanel.add(description);
    }

    private void getData(String zip) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        service.getWeather(zip).enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                CurrentWeather currentWeather = response.body();
                location.setText(currentWeather.name);
                temp.setText(currentWeather.main.temp + " F");
                feelsLike.setText(currentWeather.main.feels_like + " F");
                precip.setText(currentWeather.weather[0].main);
                description.setText(currentWeather.weather[0].description);
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws IOException{
        new WeatherFrame().setVisible(true);
    }
}
