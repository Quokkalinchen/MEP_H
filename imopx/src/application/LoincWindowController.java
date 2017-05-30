package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoincWindowController {

	public Main loinc;
	
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu einstellungen;
    @FXML
    private MenuItem dbSettings;
    @FXML
    private Menu help;
    @FXML
    private MenuItem qa;
    @FXML
    private Menu ueber;
    @FXML
    private MenuItem Ueberuns;

	@FXML
	private Button back;
	@FXML
	private Text siteName;
	
	@FXML
	private Text ipName;
	@FXML
	private TextField ipTf;
	
	@FXML
	private Text nameName;
	@FXML
	private TextField nameTf;
	
	@FXML
	private Text pwName;
	@FXML
	private TextField pwTf;
	
	@FXML
	private Button start;
	@FXML
	private ProgressBar load;
	
	@FXML
	private TextArea configText;
	@FXML
	private Button bearbeiten;
	
	
	
	public void setApp(Main loinc){
        this.loinc = loinc;
    }
	
	  @FXML
	    public void pressQA() throws Exception{
	        loinc.gotoHelp();
	    }
	  
	 @FXML
	    public void pressUeberuns() throws Exception {
	        loinc.gotoUeber();
	    }
	
	@FXML
    public void pressDbSettings() throws Exception{
        loinc.gotoSettings();
    }
	
	@FXML
    public void pressEinstellung(){
    }
	
    @FXML
    public void pressHelp(){
        
    }
    
    @FXML
    public void pressUeber(){
        
    }
    
	
	@FXML
	public void pressBack(){
		loinc.gotoMain();
	}
	
	@FXML
	public void pressStart(){
		
	}
	
	@FXML
	public void textIp(){
		
	}
	
	@FXML
	public void textName(){
		
	}
	
	@FXML
	public void textPw(){
		
	}
	
	@FXML void pressBearbeiten(){
		
	}
}
