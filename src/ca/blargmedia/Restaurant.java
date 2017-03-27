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

    public void setName(String n) {
        this.name = n;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float r) {
        this.rating = r;
    }

    public int getMaxMeals() {
        return maxMeals;
    }

    public void setMaxMeals(int max) {
        this.maxMeals = max;
    }

    public int getNumUnrestricted() {
        return numUnrestricted;
    }

    public void setNumUnrestricted(int numU) {
        this.numUnrestricted = numU;
    }

    public int getNumVegetarian() {
        return numVegetarian;
    }

    public void setNumVegetarian(int numV) {
        this.numVegetarian = numV;
    }

    public int getNumGlutenFree() {
        return numGlutenFree;
    }

    public void setNumGlutenFree(int numG) {
        this.numGlutenFree = numG;
    }

    public int getNumNutFree() {
        return numNutFree;
    }

    public void setNumNutFree(int numN) {
        this.numNutFree = numN;
    }

    public int getNumFishFree() {
        return numFishFree;
    }

    public void setNumFishFree(int numF) {
        this.numFishFree = numF;
    }
}
