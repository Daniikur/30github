package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class CalculatorServiceTest {

    @Test
    void testAddNumbers() {
        // Create mock object of Calculator
        Calculator mockCalculator = mock(Calculator.class);

        // Define behavior: When add(2, 3) is called, return 5
        when(mockCalculator.add(2, 3)).thenReturn(5);

        // Inject mock into service
        CalculatorService service = new CalculatorService(mockCalculator);

        // Test method
        assertEquals(5, service.addNumbers(2, 3), "Mocked add(2, 3) should return 5");

        // Verify that add() was called
        verify(mockCalculator).add(2, 3);
    }

    private OngoingStubbing<Integer> when(int methodCall) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'when'");
    }
}
