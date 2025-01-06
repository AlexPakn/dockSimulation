package com.idksomething.n2collectionshw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dock {
    public List<Boolean> waiting;
    private int totalSeats;
    private Random random;

    public Dock(int totalSeats) {
        this.totalSeats = totalSeats;
        this.waiting = new ArrayList<>();
        this.random = new Random();
    }

    public boolean addPersonToWaiting(int count) {
        while (count > 0 && waiting.size() < totalSeats) {
            waiting.add(true);
            count--;
        }
        return count == 0;
    }
    public void handleBoat(Boat boat) {
        List<Boolean> seats = boat.getSeats();
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i)) {
                boolean rand = random.nextInt(100) < 50;
                if(rand) {
                    seats.set(i, false);
                }
            }
        }
        for (int i = 0; i < seats.size(); i++) {
            if (!seats.get(i) && !waiting.isEmpty()) {
                seats.set(i, true);
                waiting.remove(0);
            }
        }
    }
}