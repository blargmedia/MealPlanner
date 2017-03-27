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
        this.numUnrestricted = 0;
        this.numVegetarian = 0;
        this.numGlutenFree = 0;
        this.numNutFree = 0;
        this.numFishFree = 0;
    }

    public Lunch(int numU, int numV, int numG, int numN, int numF) {
        this.numUnrestricted = numU;
        this.numVegetarian = numV;
        this.numGlutenFree = numG;
        this.numNutFree = numN;
        this.numFishFree = numF;
    }

    public int getTotalMeals() {
        return totalMeals;
    }

    public void setTotalMeals(int total) {
        this.totalMeals = total;
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
