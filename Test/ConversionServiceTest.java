
import org.junit.Before;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


public class ConverstionServiceTest {

	private ConverstionService service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service = new ConversionService();
	}

	@Test
	public void convert_celsiusToKelvin() {
		double kelv = service.convertCtoK(23.5);
		assertEquals(0, kelv);
	}

	@Test
	public void convert_kelvinToCelsius() {
		double cels = service.convertKtoC(-169.8);
		assertEquals(0, cels);
	}

	@Test
	public void convert_kilometersToMiles() {
		double kilo = service.convertKtoM(15.8);
		assertEquals(0, kilo);
	}

	@Test
	public void convert_milesToKelvin() {
		double mile = service.convertMtoK(34.7);
		assertEquals(0, mile);
	}
}
