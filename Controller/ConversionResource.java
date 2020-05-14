import org.springframework.stereotype.Component;

@Component
@Path("conversions")
public class ClientResource {

    @Autowired
    private ConversionService service;
    private long Instant start;
    private long Instant end;
    private Logger LOGGER = LoggerFactory.getLogger(ConversionService.class);

    @POST
    @Path("/ktoc")
    public Double convertKelvinToCelsius(@Valid double kelvin) {
        start = Instant.now();
        double conv = service.convertKtoC(kelvin);
        end = Instant.now();
        LOGGER.info(("Time Duration: " + end - start);
        return conv
    }

    @POST
    @Path("/ctok")
    public Double convertCelsiusToKelvin(@Valid double celsius) {
        start = Instant.now();
        double conv = service.convertCtoK(celsius);
        end = Instant.now();
        LOGGER.info(("Time Duration: " + end - start);
         return conv;
    }

    @POST
    @Path("/mtok")
    public Double convertMilesToKilometers(@Valid double miles) {
        start = Instant.now();
        double conv = service.convertMtoK(miles);
        end = Instant.now();
        LOGGER.info(("Time Duration: " + end - start);
        return conv
    }

    @POST
    @Path("/ktom")
    public Double convertKilometersToMiles(@Valid double kilo) {
        start = Instant.now();
        double conv = service.convertKtoM(kilo);
        end = Instant.now();
        LOGGER.info(("Time Duration: " + end - start);
        return conv
    }