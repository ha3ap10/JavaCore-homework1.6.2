import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    public void start() {
        System.out.print("\nStart test");
        calc = Calculator.instance.get();
    }

    @AfterEach
    public void end() {
        calc = null;
        System.out.print("End test\n");
    }

    @Test
    public void testPlus() {
        System.out.print(" plus\n");

        int a = 3, b = 3;
        int expected = 6;

        int result = calc.plus.apply(a, b);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testMinus() {
        System.out.print(" minus\n");

        int a = 5, b = 3;
        int expected = 2;

        int result = calc.minus.apply(a, b);

        assertThat(expected, equalTo(result));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 5})
    public void testAbsWithParams(int argument) {
        System.out.print(" abs\n");

        int result = calc.abs.apply(argument);

        assertThat(result, greaterThanOrEqualTo(0));
    }

    @Test
    public void testDivide() {
        System.out.print(" divide\n");

        int a = 10, b = 2;
        int expected = 5;

        int result = calc.divide.apply(a, b);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testIsPositive() {
        System.out.print(" isPositive\n");

        int a = 5;

        boolean resultTrue = calc.isPositive.test(a);
        assertThat(resultTrue, is(true));
    }
}
