package ca.blargmedia;

/**
 * Meal
 */
public class Meal {
    public enum MealType {
        UNRESTRICTED, VEGETARIAN, GLUTEN_FREE, NUT_FREE, FISH_FREE
    }

    private MealType mealType;

    public Meal() {
        this.mealType = MealType.UNRESTRICTED;
    }

    public Meal(MealType m) {
        this.mealType = m;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType m) {
        this.mealType = m;
    }

    @Override
    public String toString() {
        String s = "";
        switch (this.mealType) {
            case UNRESTRICTED:
                s = "unrestricted";
                break;
            case VEGETARIAN:
                s = "vegetarian";
                break;
            case GLUTEN_FREE:
                s = "gluten-free";
                break;
            case NUT_FREE:
                s = "nut-free";
                break;
            case FISH_FREE:
                s = "fish-free";
                break;
        }
        return s;
    }
}
