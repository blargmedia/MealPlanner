package ca.blargmedia;

/**
 * Restaurant
 */
public class Restaurant {

    private String name;
    private float rating;
    private int maxMeals;
    private int numUnrestricted;
    private int numVegetarian;
    private int numGlutenFree;
    private int numNutFree;
    private int numFishFree;

    public Restaurant() {
        this.name = "";
        this.rating = 0;
        this.maxMeals = 0;
        this.numUnrestricted = 0;
        this.numVegetarian = 0;
        this.numGlutenFree = 0;
        this.numNutFree = 0;
        this.numFishFree = 0;
    }

    public Restaurant(String n, float r, int max, int numU, int numV, int numG, int numN, int numF) {
        this.name = n;
        this.rating = r;
        this.maxMeals = max;
        this.numUnrestricted = numU;
        this.numVegetarian = numV;
        this.numGlutenFree = numG;
        this.numNutFree = numN;
        this.numFishFree = numF;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public int getMaxMeals() {
        return maxMeals;
    }

    public int getNumUnrestricted() {
        return numUnrestricted;
    }

    public int getNumVegetarian() {
        return numVegetarian;
    }

    public int getNumGlutenFree() {
        return numGlutenFree;
    }

    public int getNumNutFree() {
        return numNutFree;
    }

    public int getNumFishFree() {
        return numFishFree;
    }

}
