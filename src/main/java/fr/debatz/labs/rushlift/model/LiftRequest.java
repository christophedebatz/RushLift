package fr.debatz.labs.rushlift.model;


public class LiftRequest {
    
    public enum LiftDirection {
        UP, 
        DOWN
    };
    
    private LiftDirection direction;
    
    private int departureFloor;
    
    private int currentFloor;
    
    private int destinationFloor;
    
    private boolean forced = false;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    
    public LiftDirection getDirection() {
        return direction;
    }

    public void setDirection(LiftDirection direction) {
        this.direction = direction;
    }

    public int getDepartureFloor() {
        return departureFloor;
    }

    public void setDepartureFloor(int departureFloor) {
        this.departureFloor = departureFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public boolean isForced() {
        return forced;
    }

    public void setForced(boolean forced) {
        this.forced = forced;
    }
}
