/*
 * 100 passengers are in a plane. The first one can choose to sit on any seat on  the plane
 * The others, try to sit on their seat, but if it's occupied, then they can choose to sit on anywhere left
 * What's the probability that the last one get to sit on his "real" seat
 */


import java.util.ArrayList;

public class Simulations {
    final int passenger = 100;
    ArrayList<Integer> seats_left;
    boolean result;

    public Simulations() {
        this.seats_left = new ArrayList<Integer>(passenger);
        for(int i = 0; i < passenger; i++) {
            this.seats_left.add(i);
        }
    }

    private boolean isSeatOccupied(int seat) {
        return !this.seats_left.contains(seat);
    }

    public boolean startSimulation() {
        //Se elimina un número random entre 0 y el 99
        int random = getRandomNumber(0, seats_left.size());
        //System.out.println("Se borro aleatoriamente a " + Integer.toString(random));

        this.seats_left.remove(random);
        //Se itera unas 99 veces
        for(int i = 1; i < passenger; i++) {
            //Se muestra la lista
            for (int j = 0; j< this.seats_left.size(); j++) {
                //System.out.print(Integer.toString(this.seats_left.get(j)) + "  ");
            }
            if (isSeatOccupied(i)) {
                random = getRandomNumber(0, seats_left.size());
                //System.out.println("Se borro aleatoriamente a " + this.seats_left.get(random));
                this.seats_left.remove(random);
                if (!this.seats_left.contains(99)) return false;
            } else {
                //System.out.println("Se borro a " + Integer.toString(i));
                this.seats_left.remove(this.seats_left.indexOf(i));
            }
        }
        return true;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) throws InterruptedException {
        Simulations simulacion = new Simulations();
        System.out.println(simulacion.startSimulation()); /*
        for(int i = 0; i < 10000; i++) {
            int random = simulacion.getRandomNumber(0, 101);
            if (random == 100) {
                System.out.println(random);
                break;
            }
            System.out.println(random);
        }
        */
    }
}
