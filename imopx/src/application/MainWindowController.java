package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MainWindowController {

	@FXML
    private Button paragraph21;
	@FXML
    private Button loinc;
	@FXML
    private Button snomed;
	
	@FXML
	private MenuBar menuBar;
	@FXML
	private Menu einstellungen;
	@FXML
	private MenuItem dbSettings;
	
	@FXML
    private Menu help;
	@FXML
    private MenuItem hilfe;
	
	@FXML
    private Menu ueber;
	@FXML
    private MenuItem Ueberuns;
    
    
    public Main main;
    
    public void setMain(Main main){
        this.main = main;
    }
    
    @FXML
    public void pressQA() throws Exception{
        main.gotoHelp();
    }
    
    @FXML
    public void pressUeberuns() throws Exception {
        main.gotoUeber();
    }
    
    @FXML
    public void pressDbSettings() throws Exception{
        main.gotoSettings();
    }
    
    @FXML
    public void pressEinstellung(){
        
    }
    @FXML
    public void pressHelp(){
        
    }

    @FXML
    public void pressPara() throws Exception{
    	main.gotoPara();
       
    }
   
    @FXML
    public void pressLoinc() throws Exception{
        main.gotoLoinc();
        
    }
    
    @FXML
    public void pressSnomed() throws Exception{
        main.gotoSnomed();
    }
 
}

