package calculator;

import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Property-based tests for Calculator.
 *
 * Each @Property runs with hundreds of randomly generated inputs.
 * On failure, jqwik automatically shrinks the input to the smallest
 * counterexample that still triggers the bug.
 */
class CalculatorPropertyTest {

    private final Calculator calc = new Calculator();

    // --- Addition properties ---

    @Property
    void addIsCommutative(@ForAll int a, @ForAll int b) {
        assertEquals(calc.add(a, b), calc.add(b, a));
    }

    @Property
    void addZeroIsIdentity(@ForAll int a) {
        assertEquals(a, calc.add(a, 0));
    }

    @Property
    void addIsAssociative(@ForAll int a, @ForAll int b, @ForAll int c) {
        // (a + b) + c == a + (b + c)  — holds in Java int (two's-complement)
        assertEquals(calc.add(calc.add(a, b), c),
                     calc.add(a, calc.add(b, c)));
    }

    @Property
    void addAndSubtractAreInverses(@ForAll int a, @ForAll int b) {
        assertEquals(a, calc.subtract(calc.add(a, b), b));
    }

    // --- Multiplication properties ---

    @Property
    void multiplyIsCommutative(@ForAll int a, @ForAll int b) {
        assertEquals(calc.multiply(a, b), calc.multiply(b, a));
    }

    @Property
    void multiplyByOneIsIdentity(@ForAll int a) {
        assertEquals(a, calc.multiply(a, 1));
    }

    @Property
    void multiplyByZeroIsZero(@ForAll int a) {
        assertEquals(0, calc.multiply(a, 0));
    }

    @Property
    void distributeMultiplyOverAdd(@ForAll int a, @ForAll int b, @ForAll int c) {
        // a * (b + c) == a*b + a*c  — holds in Z/2^32Z (two's-complement)
        assertEquals(calc.multiply(a, calc.add(b, c)),
                     calc.add(calc.multiply(a, b), calc.multiply(a, c)));
    }
}
