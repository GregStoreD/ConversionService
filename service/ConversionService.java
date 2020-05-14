
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;


@Component
public class ConversionService  {

    private static final double kels = 273.5;
    private static final double kils = 0.621371;
    private static final double mils = 1.60934;
    private static final double kilo = 2.2046;
    private static final double pound = 0.4536;

    private Logger LOGGER = LoggerFactory.getLogger(ConversionService.class);

    public double convertCtoK(double celsius) {
        return (double)(celsius + this.kels);
    }

    public double ConvertKtoC(double kelvin) {
        return (double)(celsius - this.kels);
    }

    public double convertKtoM(double kilometers) {
        return (double)(kilometers * this.kils);
    }

    public double convertMtoK(double miles) {
        (double)(miles * this.mils);
    }

   public double convertPtoK(double pounds) {
        return (double)(pounds * this.pound);
    }

    public double convertKtoP(double kilograms) {
        (double)(kilograms * this.kilo);
    }
}
