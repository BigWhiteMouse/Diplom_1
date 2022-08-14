package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BunGetNameTest {
    private final String NAME;
    private final String EXPECTED;

    public BunGetNameTest(String name, String expected) {
        this.NAME = name;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters
    public static Object[] getNameData() {
        return new Object[][]{
                {"Булочка", "Булочка"},
                {"", ""},
                {" ", " "}
        };
    }

    @Test
    public void getBunNameShouldReturnName() {
        Bun bun = new Bun(NAME, 3);
        String actual = bun.getName();
        assertEquals(EXPECTED, actual);
    }

}
