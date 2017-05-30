package application;

import com.sun.glass.ui.Window;

import Programm.configController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingsWindowController {

    public Main settings;
    
    public void setMain(Main settings){
        System.out.println("asdasda");
    	this.settings = settings;
    }
    
    @FXML
    private Text siteName;
    
    @FXML
    private Text settingIp;
    @FXML
    public TextField textIp;
    
    @FXML
    private Text settingName;
    @FXML
    public TextField textUser;
    
    @FXML
    private Text settingdbName;
    @FXML
    public TextField textName;
    
    @FXML
    private Text settingPw;
    @FXML
    public PasswordField textPw;
    
    @FXML
    private Button abrechen;
    @FXML
    private Button speichern;
    
    public static String dbUser;
    public static String dbName;
    public static String dbIp;
    public static String dbPw;
    
    @FXML
    private Text dbSave;
    
    @FXML
    public void pwText(){
        
    }
    
    @FXML
    public void iPtext(){
        
    }
    
    @FXML
    public void nameText(){
        
    }
    
    @FXML
    public void pressAbrechen(){
        Stage stage = (Stage) abrechen.getScene().getWindow();
        stage.close();

        
    }
    @FXML
    public void pressSpeichern(){
     dbUser = textUser.getText();
     dbName = textName.getText();
     dbIp = textIp.getText();
      dbPw = textPw.getText();
      
      dbSave.setFont(Font.font ("Arial", 14));
     
      if(dbUser.equals("") || dbIp.equals("") || dbPw.equals("") || dbPw.equals("")){
          dbSave.setText("Bitte füllen Sie die Felder aus!");
         dbSave.setFill(Color.RED);
          
      }else{        
    	  String[] input={dbIp,dbName,dbUser,dbPw};
          configController.setConfig(input);
    	  
          dbSave.setText("Die Eingabe wurde erfolgreich gespeichert!");
         dbSave.setFill(Color.GREEN);
      }
      
     
    }
    
   
}
