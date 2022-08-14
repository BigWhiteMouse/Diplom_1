package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

@RunWith(Parameterized.class)

public class IngredientGetTypeTest {
    private final IngredientType TYPE;
    private final IngredientType EXPECTED;

    public IngredientGetTypeTest(IngredientType type, IngredientType expected) {
        this.TYPE = type;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters
    public static Object[] getNameData() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING}
        };
    }

    @Test
    public void getIngredientNameShouldReturnName() {
        Ingredient ingredient = new Ingredient(TYPE, "Чесночный", 3);
        IngredientType actual = ingredient.getType();
        assertEquals(EXPECTED, actual);
    }

}
