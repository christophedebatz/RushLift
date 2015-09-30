package fr.debatz.labs.rushlift.services.animations;

import fr.debatz.labs.rushlift.model.LiftRequest;
import fr.debatz.labs.rushlift.model.LiftRequest.LiftDirection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class AnimCabineService implements AnimService
{
    private final static int ROTATIONS_PER_LOOP = 20;
    
    private final static int ELEVATION_PER_LOOP = 2;
    
    private final static int LOOP_WAITING_TIME = 20;
    
    private final Rectangle cabine;
    
    private final Pane walls;
    
    private final Rectangle[] cables;
    
    private final Group pulley;
    
    private final ImageView[] persons;

    public AnimCabineService(Pane walls, Rectangle cabine, Group pulley, Rectangle[] cables, ImageView[] persons) {
        this.walls = walls;
        this.cabine = cabine;
        this.cables = cables;
        this.pulley = pulley;
        this.persons = persons;
    }
    
    public Rectangle getCabine() {
        return this.cabine;
    }
    
    public Pane getWalls() {
        return this.walls;
    }
    
    @Override
    public void animate(LiftRequest request) {
        if (request.getDirection().equals(LiftDirection.UP)) 
        {
            for (Rectangle cable : this.cables) {
                cable.setHeight(cable.getHeight() - ELEVATION_PER_LOOP);
            }
            
            //for (ImageView person : this.persons) {
              //  person.setY(person.getY() - ELEVATION_PER_LOOP);
            //}

            this.cabine.setY(this.cabine.getY() - ELEVATION_PER_LOOP);

            this.pulley.setRotate(this.pulley.getRotate() + ROTATIONS_PER_LOOP);
        } 
        else 
        {
            for (Rectangle cable : this.cables) {
                cable.setHeight(cable.getHeight() + ELEVATION_PER_LOOP);
            }
            
            //for (ImageView person : this.persons) {
              //  person.setY(person.getY() + ELEVATION_PER_LOOP);
            //}
        
            this.cabine.setY(this.cabine.getY() + ELEVATION_PER_LOOP);

            this.pulley.setRotate(this.pulley.getRotate() - ROTATIONS_PER_LOOP);
        }
        
        try {
            Thread.sleep(LOOP_WAITING_TIME);
        } catch (InterruptedException ex) {
            Logger.getLogger(AnimCabineService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
