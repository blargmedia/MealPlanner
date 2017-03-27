package ca.blargmedia;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tester
 */
public class MealPlannerTest {

    @Test
    public void testMealPlan0() throws Exception {

        String restFile = "./test/restaurants0.json";
        String lunchFile = "./test/lunch0.json";
        String expected = "Restaurant A:\n  4 vegetarian\n  36 unrestricted\nRestaurant B:\n  7 gluten-free\n  1 vegetarian\n  2 unrestricted\n";

        MealPlanner mp = new MealPlanner(restFile, lunchFile);
        assertEquals(expected, mp.getMealPlan());
    }

    @Test
    public void testMealPlan1() throws Exception {

        String restFile = "./test/restaurants1.json";
        String lunchFile = "./test/lunch1.json";
        String expected = "Restaurant A:\n  4 vegetarian\n  33 unrestricted\nRestaurant B:\n  7 gluten-free\n  1 vegetarian\nRestaurant C:\n  3 fish-free\n  2 nut-free\n";

        MealPlanner mp = new MealPlanner(restFile, lunchFile);
        assertEquals(expected, mp.getMealPlan());
    }

    @Test
    public void testMealPlan2() throws Exception {

        String restFile = "./test/restaurants0.json";
        String lunchFile = "./test/lunch1.json";
        String expected = "Restaurant A:\n  4 vegetarian\n  33 unrestricted\nRestaurant B:\n  7 gluten-free\n  1 vegetarian\n";

        MealPlanner mp = new MealPlanner(restFile, lunchFile);
        assertEquals(expected, mp.getMealPlan());
    }

    @Test
    public void testMealPlan3() throws Exception {

        String restFile = "./test/restaurants1.json";
        String lunchFile = "./test/lunch0.json";
        String expected = "Restaurant A:\n  4 vegetarian\n  36 unrestricted\nRestaurant B:\n  7 gluten-free\n  1 vegetarian\n  2 unrestricted\n";

        MealPlanner mp = new MealPlanner(restFile, lunchFile);
        assertEquals(expected, mp.getMealPlan());
    }

}