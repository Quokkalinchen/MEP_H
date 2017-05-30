package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class UeberWindowController {
    
    public Main ueber;
    
    public void setMain(Main ueber){
        this.ueber = ueber;
    }

    @FXML
    private TextArea ueberTool;
    
}
