package org.text;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {
    private static String weatherKeyPath = "data/src/main/resources/weatherKey.txt";

    public static String getWeatherData() throws IOException {
        String apiKeyWeat = getWeatherKey();
        String apiUrlWeat = String.format("https://api.weatherapi.com/v1/forecast.json?key=%s&q=IvanoFrankivsk&days=3", apiKeyWeat);
        return Request.Get(apiUrlWeat)
                .execute()
                .returnContent()
                .asString();
    }

    private static String getWeatherKey() throws IOException {
        Path path = Paths.get(weatherKeyPath).normalize();
        return new String(Files.readAllBytes(path)).trim();
    }
}