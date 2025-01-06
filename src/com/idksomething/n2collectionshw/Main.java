package com.idksomething.n2collectionshw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter time period of adding people to dock (in minutes):");
        int peoplePeriod = scanner.nextInt();
        System.out.println("Enter time period of boat joining dock (in minutes):");
        int boatPeriod = scanner.nextInt();
        scanner.close();

        int currentTime = 0;

        Dock dock = new Dock(20); // Instantiate a Dock

        int totalWaitingTime = 0;
        int totalWaitingPeople = 0;
        while (currentTime < 24 * 60) {
            // Check if it's time to add people to the dock
            if (currentTime % peoplePeriod == 0) {
                dock.addPersonToWaiting(1);
                totalWaitingTime += dock.waiting.size() * peoplePeriod;
                totalWaitingPeople += 1;
                // Logic to add people to the dock
            }

            // Check if it's time for a boat to join the dock
            if (currentTime % boatPeriod == 0) {
                // Instantiate a Boat with a random number of seats (e.g., 10)
                Boat boat = new Boat(10);
                dock.handleBoat(boat);
            }

            // Print dock status
            System.out.println("Current time: " + currentTime + " minutes");
            System.out.println("People waiting: " + dock.waiting.size());

            currentTime++;
        }

        double averageWaitingTime = (double)totalWaitingTime / totalWaitingPeople;
        System.out.println("Average waiting time: " + averageWaitingTime + " minutes");

        // 2. Достатній інтервал часу між приходом катерів,
        // щоб на зупинці знаходилося не більше N людей одночасно
        // Я неможу це точно підрахувати через те, що у мене всі катери випадково заповнені (+ випадково звільняються місця на зупинці)
        // Також 10% катерыв мають цю зупинку останнёю, отже вони не враховуються

    }
}