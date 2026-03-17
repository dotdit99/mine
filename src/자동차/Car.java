package 자동차;

import java.util.Scanner;

public abstract class Car {
    Scanner sc = new Scanner(System.in);
    protected int speed;
    protected double fuelEffi;
    protected int useFuel;
    protected int fuelTank;
    protected int seats;
    protected String name;
    protected int cost;
    protected int reFuelTimes;
    protected int moves;
    protected int passenger;
    protected int distance[] = {0, 400, 150, 200, 300};

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFuelEffi() {
        return fuelEffi;
    }

    public void setFuelEffi(double fuelEffi) {
        this.fuelEffi = fuelEffi;
    }

    public int getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getMoves() { // 이동 횟수
        this.moves = (int) Math.ceil((double) passenger / seats);
        return moves;
    }

    public int getDistance(int index) { // 이동 거리
            return distance[index] * getMoves() ;
    }

    public int getUseFuel(int index) { // 연료 소모량
        return (int) Math.ceil(getDistance(index) / fuelEffi);
    }

    public int getReFuelTimes(int index){
        return  (int) Math.ceil((double) useFuel / fuelTank);
    }

    public int getCost(int index){
        return getUseFuel(index) * 2000;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    public abstract void setMode(boolean isOn);
}
