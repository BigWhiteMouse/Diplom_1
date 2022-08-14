package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.SAUCE;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class IngredientGetNameTest {
    private final String NAME;
    private final String EXPECTED;

    public IngredientGetNameTest(String name, String expected) {
        this.NAME = name;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters
    public static Object[] getNameData() {
        return new Object[][]{
                {"Чесночный", "Чесночный"},
                {"", ""},
                {" ", " "}
        };
    }

    @Test
    public void getIngredientNameShouldReturnName() {
        Ingredient ingredient = new Ingredient(SAUCE, NAME, 3);
        String actual = ingredient.getName();
        assertEquals(EXPECTED, actual);
    }

}
