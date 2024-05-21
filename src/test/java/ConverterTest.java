import org.testng.Assert;
import org.testng.annotations.Test;

public class ConverterTest {

    @Test
    public void testCelsiusToFahrenheit() {
        double result = Converter.convertTemperature(10, "Celsius", "Fahrenheit");
        Assert.assertEquals(result, 50.0);
    }

    @Test
    public void testCelsiusToKelvin() {
        double result = Converter.convertTemperature(10, "Celsius", "Kelvin");
        Assert.assertEquals(result, 283.15);
    }

    @Test
    public void testFahrenheitToCelsius() {
        double result = Converter.convertTemperature(50, "Fahrenheit", "Celsius");
        Assert.assertEquals(result, 10.0);
    }

    @Test
    public void testFahrenheitToKelvin() {
        double result = Converter.convertTemperature(50, "Fahrenheit", "Kelvin");
        Assert.assertEquals(result, 283.15);
    }

    @Test
    public void testKelvinToCelsius() {
        double result = Converter.convertTemperature(283.15, "Kelvin", "Celsius");
        Assert.assertEquals(result, 10.0);
    }

    @Test
    public void testKelvinToFahrenheit() {
        double result = Converter.convertTemperature(283.15, "Kelvin", "Fahrenheit");
        Assert.assertEquals(result, 50.0);
    }
}
  