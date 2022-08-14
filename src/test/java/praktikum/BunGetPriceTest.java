package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetPriceTest {
        private final float PRICE;
        private final float EXPECTED;

        public BunGetPriceTest(float price, float expected){
            this.PRICE = price;
            this.EXPECTED = expected;
        }

        @Parameterized.Parameters
        public static Object[] getPriceData() {
            return new Object[][] {
                    {-3.4E+38f, -3.4E+38f},
                    {3.4E+38f, 3.4E+38f},
                    {0, 0},
                    {1, 1}
            };
        }

        @Test
        public void getBunPriceShouldReturnPrice(){
            Bun bun = new Bun("Булочка", PRICE);
            float actual = bun.getPrice();
            assertEquals(EXPECTED, actual,0);
        }

    }
