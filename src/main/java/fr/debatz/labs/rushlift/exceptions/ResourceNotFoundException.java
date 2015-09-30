package fr.debatz.labs.rushlift.exceptions;

public class ResourceNotFoundException extends Exception {
    
    public  ResourceNotFoundException(String resourceName) {
        super(resourceName + " has been not found.");
    }
}
