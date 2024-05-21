import io.qameta.allure.Step;
public class Converter {
    @Step("Convert {temperature} from {fromScale} to {toScale}")
    public static double convertTemperature(double temperature, String fromScale, String toScale) {
        switch (fromScale.toLowerCase()) {
            case "celsius":
                return fromCelsius(temperature, toScale);
            case "fahrenheit":
                return fromFahrenheit(temperature, toScale);
            case "kelvin":
                return fromKelvin(temperature, toScale);
            default:
                throw new IllegalArgumentException("Invalid temperature scale: " + fromScale);
        }
    }
    @Step("Convert {temperature} Celsius to {toScale}")
    private static double fromCelsius(double temperature, String toScale) {
        switch (toScale.toLowerCase()) {
            case "fahrenheit":
                return (temperature * 1.8) + 32;
            case "kelvin":
                return temperature + 273.15;
            default:
                return temperature;
        }
    }

    @Step("Convert {temperature} Fahrenheit to {toScale}")
    private static double fromFahrenheit(double temperature, String toScale) {
        switch (toScale.toLowerCase()) {
            case "celsius":
                return (temperature - 32) * 1.8;
            case "kelvin":
                return (temperature - 32) * 1.8 + 273.15;
            default:
                return temperature;
        }
    }

    @Step("Convert {temperature} Kelvin to {toScale}")
    private static double fromKelvin(double temperature, String toScale) {
        switch (toScale.toLowerCase()) {
            case "celsius":
                return temperature - 273.15;
            case "fahrenheit":
                return (temperature - 273.15) * 1.8 + 32;
            default:
                return temperature;
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Type in in console: java TemperatureConverter <temperature> <fromScale> <toScale>");
            return;
        }

        double temperature = Double.parseDouble(args[0]);
        String fromScale = args[1];
        String toScale = args[2];

        double result = convertTemperature(temperature, fromScale, toScale);
        System.out.println(temperature + " " + fromScale + " is " + result + " " + toScale);
    }

}
