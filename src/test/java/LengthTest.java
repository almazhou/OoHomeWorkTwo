import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LengthTest {
    @Test
    public void should_add_length_with_same_unit() throws Exception {
        MyLength length1 = new MyLength(1, "m");
        MyLength length2 = new MyLength(1, "m");

        MyLength result = length1.add(length2);
        assertThat(result.getValue(), is(2.0));
        assertThat(result.getUnit(), is("m"));
    }

    @Test
    public void should_add_length_with_different_unit() throws Exception {
        MyLength length1 = new MyLength(1, "m");
        MyLength length2 = new MyLength(100, "cm");

        MyLength result = length1.add(length2);
        assertThat(result.getValue(), is(2.0));
        assertThat(result.getUnit(), is("m"));

    }

    @Test
    public void should_add_get_m_for_unit() throws Exception {
        MyLength length1 = new MyLength(100, "cm");
        MyLength length2 = new MyLength(100, "cm");

        MyLength result = length1.add(length2);
        assertThat(result.getValue(), is(2.0));
        assertThat(result.getUnit(), is("m"));
    }

    @Test
    public void should_compare_two_length_with_same_unit() throws Exception {
        MyLength length1 = new MyLength(10, "cm");
        MyLength length2 = new MyLength(100, "cm");

        int result = length1.compareTo(length2);

        assertTrue(result < 0);
    }

    @Test
    public void should_compare_two_length_with_different_unit() throws Exception {
        MyLength length1 = new MyLength(100, "cm");
        MyLength length2 = new MyLength(1, "m");

        int result = length1.compareTo(length2);
        assertEquals(result,0);
    }

    @Test
    public void should_subtract_with_same_unit() throws Exception {
        MyLength length1 = new MyLength(200, "m");
        MyLength length2 = new MyLength(100, "m");
        MyLength result = length1.subtract(length2);

        assertThat(result.getValue(),is(100.0));
        assertThat(result.getUnit(),is("m"));
    }

    @Test
    public void should_subtract_with_different_unit() throws Exception {
        MyLength length1 = new MyLength(2, "m");
        MyLength length2 = new MyLength(100, "cm");

        MyLength result = length1.subtract(length2);
        assertThat(result.getValue(),is(1.0));
        assertThat(result.getUnit(),is("m"));
    }

    @Test
    public void should_multiply_with_same_unit() throws Exception {
        MyLength length1 = new MyLength(100, "cm");
        MyLength length2 = new MyLength(100, "cm");

        double result = length1.multiply(length2);
        assertThat(result,is(1.0));

    }

    @Test
    public void should_multiply_with_different_unit() throws Exception {
        MyLength length1 = new MyLength(100, "cm");
        MyLength length2 = new MyLength(10, "m");

        double result = length1.multiply(length2);

        assertThat(result,is(10.0));
    }

    @Test
    public void should_divide_with_same_unit() throws Exception {
        MyLength length1 = new MyLength(100, "cm");
        MyLength length2 = new MyLength(100, "cm");

        double result = length1.divide(length2);

        assertThat(result,is(1.0));
    }

    @Test
    public void should_divide_with_different_unit() throws Exception {
        MyLength length1 = new MyLength(10, "cm");
        MyLength length2 = new MyLength(1, "m");
        double divide = length1.divide(length2);
        assertThat(divide,is(0.1));
    }

    @Test
    public void should_convert_m_to_cm() throws Exception {
        MyLength length1 = new MyLength(0.1, "m");

        double cmValue = length1.convertToCm();

        assertThat(cmValue,is(10.0));
    }

    @Test
    public void should_convert_m_to_mm() throws Exception {
        MyLength length2 = new MyLength(1, "m");
        double mmValue = length2.convertToMm();

        assertThat(mmValue,is(1000.0));
    }

    @Test
    public void should_convert_cm_to_m() throws Exception {
        MyLength length2 = new MyLength(100, "cm");
        double mValue = length2.convertToM();

        assertThat(mValue,is(1.0));
    }
}
