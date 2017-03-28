package ca.blargmedia;

/**
 * Lunch
 */
public class Lunch {
    private int totalMeals;
    private int numUnrestricted;
    private int numVegetarian;
    private int numGlutenFree;
    private int numNutFree;
    private int numFishFree;

    public Lunch() {
        this.totalMeals = 0;
        this.numUnrestricted = 0;
        this.numVegetarian = 0;
        this.numGlutenFree = 0;
        this.numNutFree = 0;
        this.numFishFree = 0;
    }

    public Lunch(int total, int numU, int numV, int numG, int numN, int numF) {
        this.totalMeals = total;
        this.numUnrestricted = numU;
        this.numVegetarian = numV;
        this.numGlutenFree = numG;
        this.numNutFree = numN;
        this.numFishFree = numF;
    }

    public int getTotalMeals() {
        return totalMeals;
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
