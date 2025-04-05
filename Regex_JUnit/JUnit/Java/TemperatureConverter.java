package org.example ;

class TemperatureConverter{
    double celsiusToFahrenheit(double celsius){
        double ans_fah = (celsius * 9/5) + 32;
        return ans_fah;
    }

    double fahrenheitToCelsius(double fahrenheit){
        double ans_cel = (fahrenheit-32)*5/9 ;
        return ans_cel ;
    }
}