package fr.debatz.labs.rushlift.controllers;

import fr.debatz.labs.rushlift.model.LiftRequest;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController {
    
    private LiftRequest request;
    
    
    public GameController(Stage stage) {
        this.request = new LiftRequest();
    }
    
    public void startGame() throws IOException
    {
        
    }
    
    public void requestFloor(int floor) {
        this.request.setForced(false);
        this.request.setDestinationFloor(floor);
    }
}
