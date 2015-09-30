package fr.debatz.labs.rushlift;

import fr.debatz.labs.rushlift.model.LiftRequest;
import fr.debatz.labs.rushlift.model.LiftRequest.LiftDirection;
import fr.debatz.labs.rushlift.services.animations.AnimCabineService;
import fr.debatz.labs.rushlift.services.animations.ElevatorEngineService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MainSceneController implements Initializable {
    
    @FXML
    private Group pulley;
    
    @FXML
    private Rectangle leftCable;
    
    @FXML
    private Rectangle rightCable;
    
    @FXML
    private Rectangle cabine;
    
    @FXML
    private Label floorLabel;
    
    @FXML
    private Pane walls;
    
    private AnimationTimer elevatorAnimation;
    
    private LiftRequest request;
    
    public MainSceneController() {
        this.request = new LiftRequest();
    }
   
    @FXML
    private void handleFloorButton(ActionEvent event) {
        this.request.setForced(false);
        
        switch (((Button)event.getSource()).getId()) {
            case "floor3":
                this.request.setDestinationFloor(3);
                break;
                
            case "floor2":
                this.request.setDestinationFloor(2);
                break;
                
            case "floor1":
                this.request.setDestinationFloor(1);
                break;
                
            case "floor0":
                this.request.setDestinationFloor(0);
                break;
        }
        
        this.elevatorAnimation.start();
    }
    
    @FXML
    private void handleStartUpButtonAction(ActionEvent event) {
        this.request.setDirection(LiftDirection.UP);
        this.request.setForced(true);
        this.elevatorAnimation.start();
    }
    
    @FXML
    private void handleStartDownButtonAction(ActionEvent event) {
        this.request.setDirection(LiftDirection.DOWN);
        this.request.setForced(true);
        this.elevatorAnimation.start();
    }
    
    @FXML
    private void handleStopButtonAction(ActionEvent event) {
        this.elevatorAnimation.stop();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        this.elevatorAnimation = new AnimationTimer() {

            @Override
            public void handle(long now) {
                Rectangle[] cables = new Rectangle[] { leftCable, rightCable };
                AnimCabineService animCabine = new AnimCabineService(walls, cabine, pulley, cables, new ImageView[] {null });
                ElevatorEngineService elevator = new ElevatorEngineService(animCabine, floorLabel, this);
                elevator.animate(request);
            }
        };
    }
}
