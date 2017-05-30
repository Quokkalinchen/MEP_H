package application;

import java.io.File;

import Programm.Extractor;
import Programm.ImpoXiStart;
import Programm.configController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.concurrent.Task;
import javafx.concurrent.Service;

public class ParaWindowController {

    
public Main para;
    
    File selectedDirectory;
    
    @FXML
    public Button buttonKonfig;
 
    @FXML
    public Text loader;
    @FXML
    public TextField loadings;
  
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
	private Text siteName;
	@FXML
	private Button back;

	@FXML
	private Button start;
	@FXML
	public ProgressBar load;
	@FXML
	public ProgressIndicator loadi;
	@FXML
	private Text choiceText;
	@FXML
	private ComboBox<?> choiceYear;
	
	@FXML
	private TextField paraTf;
	
	@FXML
	private TextArea configText;
	@FXML
	private Button bearbeiten;
	
	
    public void setApp(Main para){
        this.para = para;
    }
    
    public void setLoader(String str){
        this.loader.setText(str);
    }
    
    
    @FXML
    public void pressQA() throws Exception{
        para.gotoHelp();
    }
    
    @FXML
    public void pressUeberuns() throws Exception {
        para.gotoUeber();
    }
    
    @FXML
    public void pressDbSettings()throws Exception{
        para.gotoSettings();
    }
    
    
    public void pressStart(){

    	String config[]=configController.getConfig();
    	Thread impoxi = new Thread(new ImpoXiStart(selectedDirectory, config[2], config[0], config[3], config[1]));
        impoxi.start();
    	
         loader.setText("Der Vorgang wird bearbeitet!");
       
    	Task<Void> task = new Task<Void>() { 
    		@Override public Void call() {
    			int i=0; 
    			while(i<=ImpoXiStart.fileCounter){  
    				i= ImpoXiStart.progressCounter;
    				updateProgress(i, ImpoXiStart.fileCounter);
    				
    				
    			if(i==ImpoXiStart.fileCounter){
    				loader.setText("Der Vorgang ist beendet!");
    				ImpoXiStart.fileCounter=0;
    				ImpoXiStart.progressCounter=0;
    				break;
    			}
    	    	}
    	        return null;
    	      }
    	    };
     
        


        
         load.progressProperty().bind(task.progressProperty());
       //  loadi.progressProperty().bind(thread.progressProperty());
         
         Thread th = new Thread(task);
         th.setDaemon(true);
         th.start();
        /* start.setOnAction(e->{
             thread.restart();
         });*/
         
         
         
         
        
         
    }
    
    @FXML
    public void pressEinstellung() {
    }
    
    @FXML
    public void pressHelp(){
        
    }
    
    @FXML
    public void pressUeber(){
        
    }

    
    @FXML
    public void pressBack(){
 	   para.gotoMain();
    }

    
   @FXML
   public void pressFile(){
	   DirectoryChooser folderChooser = new DirectoryChooser();
	   folderChooser.setTitle("Datei öffnen");
	   
	   selectedDirectory = folderChooser.showDialog(new Stage());
	   if(selectedDirectory == null){
           paraTf.setText("No Directory selected");
       }else{
           paraTf.setText(selectedDirectory.getAbsolutePath());
       }
	   
	  
   }
   
   @FXML
   public void textPara(){
       
       
   }

   
   @FXML void pressBearbeiten(){
		
	}

   @FXML void pressKonfig() throws Exception{
       para.gotoKonfig();
   }
   
    
    
    
}