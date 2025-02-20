@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSumOperation() throws Exception {
        mockMvc.perform(post("/api/calculate/sum")
                        .param("a", "10")
                        .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Operation sent")));
    }
}
