package org.text;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Text.renderWeatherText(Data.getWeatherData());
    }
}