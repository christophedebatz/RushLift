package fr.debatz.labs.rushlift.model;

public class Person 
{
    private long waitingTime;
    
    private long maxWaitingTime;
    
    private LiftRequest request;

    public long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public long getMaxWaitingTime() {
        return maxWaitingTime;
    }

    public void setMaxWaitingTime(long maxWaitingTime) {
        this.maxWaitingTime = maxWaitingTime;
    }

    public LiftRequest getRequest() {
        return request;
    }

    public void setRequest(LiftRequest request) {
        this.request = request;
    }
}
