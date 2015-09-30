package fr.debatz.labs.rushlift.services.animations;

import fr.debatz.labs.rushlift.exceptions.ResourceNotFoundException;
import fr.debatz.labs.rushlift.model.LiftRequest;
import fr.debatz.labs.rushlift.model.LiftRequest.LiftDirection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;

public class ElevatorEngineService implements AnimService
{    
    public final double ELEVATOR_TOP_MARGIN = 9;
    
    public final double ELEVATOR_BOTTOM_MARGIN = 32;
    
    public final double FLOOR_HEIGHT = 79;
    
    private final AnimationTimer animation;
    
    private final AnimCabineService animCabine;
    
    private final Label floorLabel;
    
    public ElevatorEngineService(AnimCabineService animCabine, Label floorLabel, AnimationTimer animation) {
        this.animCabine = animCabine;
        this.animation = animation;
        this.floorLabel = floorLabel;
    }
    
    @Override
    public void animate(LiftRequest request)
    {
        boolean hasBeenStopped = false;
        
        Rectangle cabine = this.animCabine.getCabine();
        Pane walls = this.animCabine.getWalls();
        
        request.setCurrentFloor((int)Math.abs(Math.round(cabine.getY() / FLOOR_HEIGHT * 4d) / 4d));
        this.floorLabel.setText(request.getCurrentFloor() + " floor");
        
        if (!request.isForced())
        {
            if (request.getCurrentFloor() > request.getDestinationFloor()) {
                request.setDirection(LiftDirection.DOWN);
            } else if (request.getCurrentFloor() < request.getDestinationFloor()) {
                request.setDirection(LiftDirection.UP);
            } else {
                if (request.getDirection().equals(LiftDirection.UP)) {
                    if (request.getCurrentFloor() == request.getDestinationFloor()) {
                        hasBeenStopped = true;
                    }
                } else {
                    if (request.getCurrentFloor() == request.getDestinationFloor() - 1) {
                        hasBeenStopped = true;
                    }
                }
            }
        }
        
        this.animCabine.animate(request);
        
        boolean toTop = cabine.getLayoutY() + cabine.getY() < ELEVATOR_TOP_MARGIN;
        boolean toBottom = cabine.getLayoutY() + cabine.getY() > walls.getHeight() - cabine.getHeight() - ELEVATOR_BOTTOM_MARGIN;
        
        if (toTop && request.getDirection().equals(LiftDirection.UP)) {
            hasBeenStopped = true;
        }
        
        if (toBottom && request.getDirection().equals(LiftDirection.DOWN)) {
            hasBeenStopped = true;
        }
        
        if (hasBeenStopped) {
            String sound = "/sounds/doors-ring.mp3";
            Media media = new Media(getClass().getResource(sound).toString());
            if (sound != null) {
                MediaPlayer player = new MediaPlayer(media);
                player.play();
            } else {
                try {
                    throw new ResourceNotFoundException(sound);
                } catch (ResourceNotFoundException ex) {
                    Logger.getLogger(ElevatorEngineService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            this.animation.stop();
        } 
    }
}
