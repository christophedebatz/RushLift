package fr.debatz.labs.rushlift.model;

import java.util.Queue;


public class Floor {
    
    private int number;
    
    private Queue<Person> queueWaitingPersons;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Queue<Person> getQueueWaitingPersons() {
        return queueWaitingPersons;
    }

    public void setQueueWaitingPersons(Queue<Person> queueWaitingPersons) {
        this.queueWaitingPersons = queueWaitingPersons;
    }
}
