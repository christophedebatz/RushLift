package fr.debatz.labs.rushlift.model;

import java.util.List;
import java.util.Queue;


public class Cabine {
    
    private int maxCapacity;
    
    private List<Person> persons;
    
    private Queue<LiftRequest> queueRequests;

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Queue<LiftRequest> getQueueRequests() {
        return queueRequests;
    }

    public void setQueueRequests(Queue<LiftRequest> queueRequests) {
        this.queueRequests = queueRequests;
    }
}
