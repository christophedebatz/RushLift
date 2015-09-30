package fr.debatz.labs.rushlift.services.animations;

import fr.debatz.labs.rushlift.model.LiftRequest;
import fr.debatz.labs.rushlift.model.Person;
import java.util.List;

public class AnimPersonService implements AnimService
{
    private List<Person> persons;
    
    public AnimPersonService(List<Person> persons) {
        this.persons = persons;
    }
    
    @Override
    public void animate(LiftRequest request) {
        
    }
}
