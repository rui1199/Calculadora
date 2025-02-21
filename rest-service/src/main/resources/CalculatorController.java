
    @RestController
    @RequestMapping("/api/calculate")
    public class CalculatorController {

        @Autowired
        private KafkaTemplate<String, CalculationRequest> kafkaTemplate;

        @PostMapping("/{operation}")
        public ResponseEntity<String> calculate(
                @PathVariable String operation,
                @RequestParam BigDecimal a,
                @RequestParam BigDecimal b) {

            CalculationRequest request = new CalculationRequest(operation, a, b);
            kafkaTemplate.send("calculator-topic", request);
            return ResponseEntity.ok("Operation sent: " + operation);
        }
    }

