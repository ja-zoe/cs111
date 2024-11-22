/**
 * Class represents solar panels, street map, and
 * an array of parking lot projects.
 * 
 * @author Jessica De Brito
 * @author Kal Pandit
 */
public class SolarPanels {
    
    private Panel[][] panels;
    private String[][] streetMap;
    private ParkingLot[] lots;

    /**
     * Default constructor: initializes empty panels and objects.
     */
    public SolarPanels() {
        panels = null;
        streetMap = null;
        lots = null;
        StdRandom.setSeed(2023);
    }

    /**
     * Updates the instance variable streetMap to be an l x w
     * array of Strings. Reads each label from input file in parameters.
     * 
     * @param streetMapFile the input file to read from
     */
    public void setupStreetMap(String streetMapFile) {
        // WRITE YOUR CODE HERE
        StdIn.setFile(streetMapFile);
        int len = StdIn.readInt();
        int width = StdIn.readInt();
        streetMap = new String[len][width];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                String current = StdIn.readString();
                streetMap[i][j] = current;
            }
        } 

    }

    /**
     * Adds parking lot information to an array of parking lots.
     * Updates the instance variable lots to store these parking lots.
     * 
     * @param parkingLotFile the lot input file to read
     */
    public void setupParkingLots(String parkingLotFile) {
        // WRITE YOUR CODE HERE
        StdIn.setFile(parkingLotFile);
        int len = StdIn.readInt();
        lots = new ParkingLot[len];
        for (int i = 0; i < len; i++) {
            String lot = StdIn.readString();
            int maxPanels = StdIn.readInt();
            double budget = StdIn.readDouble();
            int capacity = StdIn.readInt();
            double efficiency = StdIn.readDouble();
            lots[i] = new ParkingLot(lot, maxPanels, budget, capacity, efficiency);
        }
    }

    /**
     * Insert panels on each lot as much as space and budget allows.
     * Updates the instance variable panels to be a 2D array parallel to
     * streetMap, storing panels placed.
     * 
     * Panels have a 95% chance of working. Use StdRandom.uniform(); if
     * the resulting value is < 0.95 the panel works.
     * 
     * @param costPerPanel the fixed cost per panel, as a double
     */
    public void insertPanels(double costPerPanel) {
        // WRITE YOUR CODE HERE
        int len = streetMap.length;
        int width = streetMap[0].length;
        panels = new Panel[len][width];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (streetMap[i][j].charAt(0) == 'P') {
                    String lot = streetMap[i][j];
                    int lotNumber = Integer.parseInt(lot.substring(1)) - 1;
                    int maxPanels = lots[lotNumber].getMaxPanels();
                    double budget = lots[lotNumber].getBudget() - costPerPanel;
                    if (maxPanels > 0 && budget >= 0) {
                        // insert panel
                        double probability = StdRandom.uniform();
                        boolean isBroken = probability > 0.95;
                        double efficiency = lots[lotNumber].getPanelEfficiency();
                        int capacity = lots[lotNumber].getEnergyCapacity();
                        panels[i][j] = new Panel(efficiency, capacity, !isBroken);

                        // update panel
                        lots[lotNumber].setMaxPanels(maxPanels - 1);
                        lots[lotNumber].setBudget(budget);
                    }
                }
            }
        }
    }

    /**
     * Given a temperature and coefficient, update panels' actual efficiency
     * values. Panels are most optimal at 77 degrees F.
     * 
     * Panels perform worse in hotter environments and better in colder ones.
     * worse = efficiency loss, better = efficiency gain.
     * 
     * Coefficients are usually negative to represent energy loss.
     * 
     * @param temperature the current temperature, in degrees F
     * @param coefficient the coefficient to use
     */
    public void updateActualEfficiency(int temperature, double coefficient) {
        // WRITE YOUR CODE HERE
        double efficiencyLoss = coefficient * (temperature - 77);
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                if (panels[i][j] != null) {
                    double actualEfficiency = panels[i][j].getRatedEfficiency() - efficiencyLoss;
                    panels[i][j].setActualEfficiency(actualEfficiency);
                }
            }
        }
    }

    /**
     * For each WORKING panel, update the electricity generated for 4 hours 
     * of sunlight as follows:
     * 
     * (actual efficiency / 100) * 1500 * 4
     * 
     * RUN updateActualEfficiency BEFORE running this method.
     */
    public void updateElectricityGenerated() {
        // WRITE YOUR CODE HERE
        int len = panels.length;
        int width = panels[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (panels[i][j] != null) {
                    if (panels[i][j].isWorking()) {
                        double powerOutput = (panels[i][j].getActualEfficiency() / 100) * 1500;
                        int electricityGenerated = (int) (powerOutput * 4);
                        panels[i][j].setElectricityGenerated(electricityGenerated);
                    }
                }
            }
        }
    }

    /**
     * Count the number of working panels in a parking lot.
     * 
     * @param parkingLot the parking lot name
     * @return the number of working panels
     */
    public int countWorkingPanels(String parkingLot) {
        // WRITE YOUR CODE HERE
        int len = panels.length;
        int width = panels[0].length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (streetMap[i][j].equals(parkingLot)) {
                    if (panels[i][j].isWorking()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Find the broken panels in the map and repair them.
     * @return the count of working panels in total, after repair
     */
    public int updateWorkingPanels() {
        // WRITE YOUR CODE HERE
        int len = panels.length;
        int width = panels[0].length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (panels[i][j] != null) {
                    count++;
                    if (!panels[i][j].isWorking()) {
                        panels[i][j].setIsWorking(true);
                    }
                }
            }
        }
        return count;
    }

    /**
     * Calculate Rutgers' savings on energy by using
     * these solar panels.
     * 
     * ASSUME:
     * - Multiply total electricity generated by 0.001 to convert to KwH.
     * - There are 365 days in a year.
     * 
     * RUN electricityGenerated before running this method.
     */
    public double calculateSavings() {
        // WRITE YOUR CODE HERE
        int len = panels.length;
        int width = panels[0].length;
        double total_generated = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (panels[i][j] != null) {
                    total_generated += panels[i][j].getElectricityGenerated();
                }
            }
        }
        total_generated = (total_generated * 0.001) * 365;
        double savings = (total_generated / 4270000) * 60000000;
        return savings;
    }

    /*
     * Getter and Setter methods
     */
    public Panel[][] getPanels() {
        // DO NOT TOUCH THIS METHOD
        return this.panels;
    }

    public void setPanels(Panel[][] panels) {
        // DO NOT TOUCH THIS METHOD
        this.panels = panels;
    }

    public String[][] getStreetMap() {
        // DO NOT TOUCH THIS METHOD
        return this.streetMap;
    }

    public void setStreetMap(String[][] streetMap) {
        // DO NOT TOUCH THIS METHOD
        this.streetMap = streetMap;
    }

    public ParkingLot[] getLots() {
        // DO NOT TOUCH THIS METHOD
        return this.lots;
    }

    public void setLots(ParkingLot[] lots) {
        // DO NOT TOUCH THIS METHOD
        this.lots = lots;
    }
}
