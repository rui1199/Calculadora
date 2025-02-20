@SpringBootTest
public class CalculatorConsumerTest {

    @Autowired
    private CalculatorConsumer consumer;

    @Test
    public void testSum() {
        CalculationRequest request = new CalculationRequest("sum", new BigDecimal("10"), new BigDecimal("5"));
        consumer.processMessage(request);
        assertEquals(new BigDecimal("15"), request.getA().add(request.getB()));
    }
}

