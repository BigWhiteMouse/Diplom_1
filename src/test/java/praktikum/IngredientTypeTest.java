package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
        private final IngredientType TYPE;
        private final String VALUE_TYPE;

        public IngredientTypeTest (IngredientType type, String valueType){
            this.TYPE = type;
            this.VALUE_TYPE = valueType;
        }

        @Parameterized.Parameters
        public static Object[] getTypeData() {
            return new Object[][] {
                    {SAUCE, "SAUCE"},
                    {FILLING, "FILLING"},
            };
        }

     @Test
    public void IngredientTypeShouldReturnTypesByValue(){
        IngredientType expected = TYPE;
        IngredientType actual = IngredientType.valueOf(VALUE_TYPE);
        assertEquals(expected,actual);
    }
}
