package com.idksomething.n2collectionshw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boat {
    private List<Boolean> seats;
    private Random random;
    private boolean lastSpot;
    public Boat(int totalSeats) {
        this.random = new Random();
        this.seats = new ArrayList<>();
        for (int i = 0; i < totalSeats; i++) {
            // Randomly decide if a seat is taken or not
            this.seats.add(random.nextBoolean());
        }
        lastSpot = random.nextInt(100) > 90;
    }

    public boolean isLastSpot() {
        return lastSpot;
    }

    public List<Boolean> getSeats() {
        return seats;
    }
}