@Component
public class CalculatorConsumer {

    @KafkaListener(topics = "calculator-topic", groupId = "calculator-group")
    public void processMessage(CalculationRequest request) {
        BigDecimal result;
        switch (request.getOperation()) {
            case "sum": result = request.getA().add(request.getB()); break;
            case "subtraction": result = request.getA().subtract(request.getB()); break;
            case "multiplication": result = request.getA().multiply(request.getB()); break;
            case "division": result = request.getA().divide(request.getB(), MathContext.DECIMAL128); break;
            default: throw new IllegalArgumentException("Invalid operation");
        }
        System.out.println("Result: " + result);
    }
}