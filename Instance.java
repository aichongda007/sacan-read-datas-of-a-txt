package model;

public class Instance {

    public final String name;
    public final int nrVehicles;
    public final int capacity;
    public final int duration;
    public final int nrCustomers;
    public final int [][] timeWindows;
    public final int[][] cordinates;
    public final int[] demands;


    public Instance(String name, int nrVehicles, int capacity, int duration, int nrCustomers, int[][] timeWindows, int[][] cordinates, int[] demands) {
        this.name = name;
        this.nrVehicles = nrVehicles;
        this.capacity = capacity;
        this.duration = duration;
        this.nrCustomers = nrCustomers;
        this.timeWindows = timeWindows;
        this.cordinates = cordinates;
        this.demands = demands;
        nrCustomers= demands.length;
    }

    @Override
    public String toString() {
        String s=name+"\n";
        s+="nrVehicles: "+nrVehicles+" capacity: "+capacity+" duration: "+duration+" nrCustomers: "+nrCustomers+"\n";

        s+="Customers property:\n";
        for(int i=0; i<nrCustomers; i++){
            s+="customer "+i+" : ["+timeWindows[i][0]+","+timeWindows[i][1]+"] demand: "+demands[i]+" : ("+cordinates[i][0]+","+cordinates[i][1]+")"+"\n";
        }
        return s;
    }
}
