package io;

import model.Instance;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Reader {

    public static Instance readInstance(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine().trim();
        int nrVehicles= new Integer(line.split( " ")[1]);
        line = scanner.nextLine().trim();
        int duration= new Integer(line.split( " ")[1]);
        line = scanner.nextLine().trim();
        int capacity= new Integer(line.split( " ")[1]);
        line = scanner.nextLine().trim();
        int nrCustomers= new Integer(line.split( " ")[1]);
        scanner.nextLine();//skip a line

        //define id, demand, time window and x-y cordinate of nrCustomer
        int [] cids = new int [nrCustomers];
        int [] demands = new int [nrCustomers];
        int [][] timeWindows = new int [nrCustomers][2];
        int [][] cordinates = new int [nrCustomers][2];

        //parse the nrCustomer
        for (int i=0; i<nrCustomers;i++){
            line = scanner.nextLine();
            String[] parts = line.split(" ");
            int cid=Integer.parseInt(parts[0]);
            int demand=Integer.parseInt(parts[1]);
            int release=Integer.parseInt(parts[2]);
            int deadline=Integer.parseInt(parts[3]);
            int cordinate_x=Integer.parseInt(parts[4]);
            int cordinate_y=Integer.parseInt(parts[5]);
            timeWindows[i][0]=release;
            timeWindows[i][1]=deadline;
            cordinates[i][0]=cordinate_x;
            cordinates[i][1]=cordinate_y;
            demands[i]=demand;
        }

        return new Instance(file.getName(),nrVehicles,capacity, duration, nrCustomers,timeWindows,cordinates,demands);
    }

    public static void main(String[] args) {

    }



}
