package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calc;

	@BeforeEach
	void initEach() {
		calc = new Calculator();
	}

	@Nested
	class AddTest {
		@Test
		void testAddingTwoPositives() {
			assertEquals(2, calc.add(1, 1), "Add two numbers");
		}

		@Test
		void testAddingTwoNegatives() {
			assertEquals(-2, calc.add(-1, -1), "Add two negatives ");
		}

		@Test
		void testAddingAPositiveAndANegative() {
			assertEquals(0, calc.add(-1, 1), "Add one positive and a negative");
		}
	}

	@Test
	void testMultiply() {
		assertAll(() -> assertEquals(0, calc.multiply(1, 0)), () -> assertEquals(1, calc.multiply(1, 1)),
				() -> assertEquals(6, calc.multiply(2, 3)));
	}

	
	@Test
	void computeCircleArea() {
		assertEquals(314.159, calc.computeCircleArea(10), 0.001, "Circle area");
	}

	@Test
	void testDivide() {
		double result = calc.divide(10, 3);
		System.out.println("10/3 = " + result);
		assertEquals(3.33, calc.divide(10,3), 0.01, "Circle area");
	}
	
	
	@Test
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> calc.divide(1, 0),
				"Divide should throw ArithmeticException when denominator is 0");
	}

}
