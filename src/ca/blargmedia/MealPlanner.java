/*
  Problem:

  We're ordering meals for a team lunch. Every member in the team needs one meal,
  some have dietary restriction such as vegetarian, gluten free, nut free, and fish free.

  We have a list of restaurants which serve meals that satisfy some of these restrictions.
  Each restaurant has a rating, and a limited amount of meals in stock that they can make today.

  Implement an object oriented system with automated tests that can automatically produce
  the best possible meal orders with reasonable assumptions.

  Example:

  Team needs:
  - total 50 meals including 5 vegetarians and 7 gluten free.

  Restaurants:
  - Restaurant A has a rating of 5/5 and can serve 40 meals including 4 vegetarians,
  - Restaurant B has a rating of 3/5 and can serve 100 meals including 20 vegetarians, and 20 gluten free.

  Expected meal orders:
  - Restaurant A (4 vegetarian + 36 others), Restaurant B (1 vegetarian + 7 gluten free + 2 others)
 */

package ca.blargmedia;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MealPlanner {

    private ArrayList<Restaurant> restaurants;
    private String jsonRestaurantData;
    private String jsonLunchData;
    private Lunch lunch;
    private String mealPlan;

    public MealPlanner(String restaurantFile, String lunchFile) {

        restaurants = new ArrayList<>();
        jsonRestaurantData = "";
        jsonLunchData = "";
        mealPlan = "";

        // get the restaurant data
        // ASSUMPTION - formatted as json data
        try {
            jsonRestaurantData = readJsonDataFile(restaurantFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonRestaurantData);

        // parse the restaurant data, using Google's Gson parser
        Gson gsonR = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(jsonRestaurantData).getAsJsonArray();

        // convert json array to ArrayList of Restaurant objects
        for (int i = 0; i < array.size(); i++) {
            restaurants.add(gsonR.fromJson(array.get(i), Restaurant.class));
        }

        // get the lunch data
        // ASSUMPTION - formatted as json data
        try {
            jsonLunchData = readJsonDataFile(lunchFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonLunchData);

        // parse and convert json data to Lunch object
        Gson gsonL = new Gson();
        lunch = gsonL.fromJson(jsonLunchData, Lunch.class);

        // sort restaurants by their ratings
        Collections.sort(restaurants, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant r1, Restaurant r2) {
                return (int) (r1.getRating() * 100 - r2.getRating() * 100); // keep 2 digits rating precision
            }
        });

        Collections.reverse(restaurants); // flip the order so the ratings are from best to worst

        String order = "Your lunch order is:\n"
                + "  " + lunch.getNumUnrestricted() + " unrestricted meals\n"
                + "  " + lunch.getNumVegetarian() + " vegetarian meals\n"
                + "  " + lunch.getNumGlutenFree() + " gluten-free meals\n"
                + "  " + lunch.getNumNutFree() + " nut-free meals\n"
                + "  " + lunch.getNumFishFree() + " fish-free meals\n";
        System.out.println(order);

        // figure out the meal plan
        mealPlan = planMeal(restaurants, lunch);

        System.out.println("Your optimal meal plan is:\n ");
        System.out.println(mealPlan);

    }

    private String planMeal (ArrayList<Restaurant> r, Lunch l) {

        // setup counters for matching lunch order against restaurants
        int countFishFree = l.getNumFishFree();
        int countNutFree = l.getNumNutFree();
        int countGlutenFree = l.getNumGlutenFree();
        int countVegetarian = l.getNumVegetarian();
        int countUnrestricted = l.getNumUnrestricted();
        int countTotalOrder = l.getTotalMeals();

        String plan = "";

        // loop through the restaurants to fulfill the lunch order
        for (int i = 0; i < r.size() && countTotalOrder > 0; i++) {
            plan += r.get(i).getName() + ":\n";
            if (r.get(i).getNumFishFree() > 0 && countFishFree > 0) {
                int orderFishFree = Math.min(r.get(i).getNumFishFree(), countFishFree); // whichever is smaller
                countFishFree -= orderFishFree;
                countTotalOrder -= orderFishFree;
                plan += "  " + orderFishFree + " fish-free\n";
            }
            if (r.get(i).getNumNutFree() > 0 && countNutFree > 0) {
                int orderNutFree = Math.min(r.get(i).getNumNutFree(), countNutFree);
                countNutFree -= orderNutFree;
                countTotalOrder -= orderNutFree;
                plan += "  " + orderNutFree + " nut-free\n";
            }
            if (r.get(i).getNumGlutenFree() > 0 && countGlutenFree > 0) {
                int orderGlutenFree = Math.min(r.get(i).getNumGlutenFree(), countGlutenFree);
                countGlutenFree -= orderGlutenFree;
                countTotalOrder -= orderGlutenFree;
                plan += "  " + orderGlutenFree + " gluten-free\n";
            }
            if (r.get(i).getNumVegetarian() > 0 && countVegetarian > 0) {
                int orderVegetarian = Math.min(r.get(i).getNumVegetarian(), countVegetarian);
                countVegetarian -= orderVegetarian;
                countTotalOrder -= orderVegetarian;
                plan += "  " + orderVegetarian + " vegetarian\n";
            }
            if (r.get(i).getNumUnrestricted() > 0 && countUnrestricted > 0) {
                int orderUnrestricted = Math.min(r.get(i).getNumUnrestricted(), countUnrestricted);
                countUnrestricted -= orderUnrestricted;
                countTotalOrder -= orderUnrestricted;
                plan += "  " + orderUnrestricted + " unrestricted\n";
            }
        }
        return plan;
    }

    private String readJsonDataFile(String filename) throws FileNotFoundException {
        File inFile = new File(filename);
        Scanner in = new Scanner(inFile);
        StringBuilder jsonFileData = new StringBuilder();

        try {
            while(in.hasNext()) {
                String line = in.nextLine();
                jsonFileData.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return jsonFileData.toString();
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public static void main(String[] args) {
        String restaurantFile = "";
        String lunchFile = "";
        if (args.length == 2) {
            restaurantFile = args[0];
            lunchFile = args[1];
        } else {
            restaurantFile = "./test/restaurants0.json";
            lunchFile = "./test/lunch0.json";
        }
        try {
            new MealPlanner(restaurantFile, lunchFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
