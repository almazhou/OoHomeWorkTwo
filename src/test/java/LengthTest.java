import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void should_add_length_with_same_unit() throws Exception {
        MyLength length1 = new MyLength(1, "m");
        MyLength length2 = new MyLength(1, "m");

        MyLength result = length1.add(length2);
        assertThat(result.getValue(),is(2.0));
        assertThat(result.getUnit(),is("m"));
    }

    @Test
    public void should_add_length_with_different_unit() throws Exception {
        MyLength length1 = new MyLength(1, "m");
        MyLength length2 = new MyLength(100, "cm");

        MyLength result = length1.add(length2);
        assertThat(result.getValue(),is(2.0));
        assertThat(result.getUnit(),is("m"));

    }
}
