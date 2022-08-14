package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetPriceTest {
    private final float PRICE;
    private final float EXPECTED;

    public IngredientGetPriceTest(float price, float expected) {
        this.PRICE = price;
        this.EXPECTED = expected;
    }

    @Parameterized.Parameters
    public static Object[] getPriceData() {
        return new Object[][]{
                {-3.4E+38f, -3.4E+38f},
                {3.4E+38f, 3.4E+38f},
                {0, 0},
                {1, 1}
        };
    }

    @Test
    public void getIngredientPriceShouldReturnPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Чесночный", PRICE);
        float actual = ingredient.getPrice();
        assertEquals(EXPECTED, actual, 0);
    }
}
