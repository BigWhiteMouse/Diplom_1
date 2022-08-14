package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)

public class BurgerTest {
    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    Burger burger = new Burger();
    List<Ingredient> ingredients = new ArrayList<>();

    @Test
    public void setBunsShouldReturnBunName(){
        bun.name = "Булочка";
        burger.setBuns(bun);
        String expected = "Булочка";
        String actual = burger.bun.name;
        assertEquals(expected,actual);
    }

    @Test
    public void setBunsShouldReturnBunPrice(){
        bun.price = 300;
        burger.setBuns(bun);
        float expected = 300;
        float actual = burger.bun.price;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void addIngredientShouldAddIngredientAtFirstIndex(){
       firstIngredient.type = SAUCE;
       burger.ingredients = ingredients;
       burger.addIngredient(firstIngredient);
       String expected = firstIngredient.type.toString();
       String actual = ingredients.get(0).type.toString();
       assertEquals(expected,actual);
    }

    @Test
    public void removeIngredientShouldRemoveIngredientFromList(){
        burger.ingredients = ingredients;
        ingredients.add(firstIngredient);
        burger.removeIngredient(0);
        int expected = 0;
        int actual = ingredients.size();
        assertEquals(expected,actual);
    }

    @Test
    public void moveIngredientShouldGetAnotherIndex(){
        firstIngredient.type = SAUCE;
        burger.ingredients = ingredients;
        ingredients.add(firstIngredient);
        ingredients.add(secondIngredient);
        burger.moveIngredient(0,1);
        String expected = firstIngredient.type.toString();
        String actual = ingredients.get(1).type.toString();
        assertEquals(expected,actual);
    }

    @Test
    public void getPriceShouldReturnPrice(){
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200F);
        burger.bun = bun;
        burger.ingredients = ingredients;
        ingredients.add(firstIngredient);
        float expected = 400;
        float actual = burger.getPrice();
        assertEquals(expected,actual,0);
    }

    @Test
    public void getReceiptShouldReturnReceipt(){
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(firstIngredient.getType()).thenReturn(SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("Чесночный");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200F);
        burger.bun = bun;
        burger.ingredients = ingredients;
        ingredients.add(firstIngredient);
        String expected = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n","Булочка", "sauce", "Чесночный", "Булочка", 400F);
        String actual = burger.getReceipt();
        assertEquals(expected,actual);
    }


}
