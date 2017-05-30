package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;


public class KonfigWindowController {

    public Main konfig;
 
    public void setApp(Main konfig){
        this.konfig = konfig;
    }
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu einstellungen;
    @FXML
    private MenuItem dbSettings;
    @FXML
    private Menu help;
    @FXML
    private Menu ueber;
    @FXML
    private MenuItem Ueberuns;
    
    @FXML
    private Button addSpalte;
    
    @FXML
    private Button abbrechen;
    
    @FXML
    public VBox vBoxSpalte;
    @FXML
    public HBox hBoxText;
    
    @FXML
    public HBox hBoxTextField;
    
    
    @FXML
    private Text textZieldimension;
    @FXML
    private Text textZielSpalte;
    @FXML
    private Text textQuelltabelle;
    @FXML
    private Text textQuellspalte;
    @FXML
    private Text textFormat;
    
    @FXML
    private TextField tfZieldimension;
    @FXML
    private TextField tfZielspalte;
    @FXML
    private TextField tfQuelltabelle;
    @FXML
    private TextField tfQuellspalte;
    @FXML
    private TextField tfFormat;
    
    @FXML
   AnchorPane rooting;
    private int counter = 0;
    private int KongifNr = 2;
    private int x = 10;
    private int y= 150;
    
    
    public void pressAdd(ActionEvent event){
      
        VBox v1 = new VBox(1);
        
        HBox h2 = new HBox(5);
        HBox h3 = new HBox(5);
      
        
        TextField tfZieldimension1 = new TextField();
        tfZieldimension1.setPrefSize(163, 25);
       
        TextField tfZielspalte1 = new TextField();
        tfZielspalte1.setPrefSize(163, 25);
         
        TextField tfQuelltabelle1 = new TextField();
        tfQuelltabelle1.setPrefSize(163, 25);
        
        TextField tfQuellspalte1 = new TextField();
        tfQuellspalte1.setPrefSize(163, 25);
        
        TextField tfFormat1 = new TextField();
        tfFormat1.setPrefSize(163, 25);
         
        Text textZieldimension1 = new Text("Zieldimension:");
        textZieldimension1.setWrappingWidth(160);
        
        Text textZielSpalte1 = new Text("Zielspalte:");
        textZielSpalte1.setWrappingWidth(160);
       
        Text textQuelltabelle1 = new Text("Quelltabelle:");
        textQuelltabelle1.setWrappingWidth(160);
       
         Text textQuellspalte1= new Text("Quellspalte:");
         textQuellspalte1.setWrappingWidth(160);
       
         Text textFormat1= new Text("Format:");
         textFormat1.setWrappingWidth(160);
       
         h3.getChildren().addAll(textZieldimension1, textZielSpalte1, textQuelltabelle1, textQuellspalte1, textFormat1);
        h2.getChildren().addAll(tfZieldimension1, tfZielspalte1, tfQuelltabelle1, tfQuellspalte1, tfFormat1);
      

        h3.setPadding(new Insets(y,0,0,42));
        h2.setPadding(new Insets(0,0,0,42));
        y=y+50;
       
        h3.setMargin(textZielSpalte1, new Insets(0,0,0,10));
        h3.setMargin(textQuelltabelle1, new Insets(0,0,0,10));
        h3.setMargin(textQuellspalte1, new Insets(0,0,0,6));
        h3.setMargin(textFormat1, new Insets(0,0,0,8));
        
        h2.setMargin(tfZielspalte1, new Insets(0,0,0,5));
        h2.setMargin(tfQuelltabelle1, new Insets(0,0,0,5));
        h2.setMargin(tfQuellspalte1, new Insets(0,0,0,5));
        h2.setMargin(tfFormat1, new Insets(0,0,0,5));

        v1.setId("spalte" + KongifNr);
        
        v1.getChildren().addAll(h3,h2);
        
      
        System.out.println(h2.getChildren().get(1));
        
        rooting.getChildren().add(counter, v1);
        counter++;
        KongifNr++;
      
    }

    @FXML
    public void pressAbbrechen(){
        Stage stage = (Stage) abbrechen.getScene().getWindow();
        stage.close();

        
    }
    
    @FXML
    public void pressUeberuns() throws Exception {
        konfig.gotoUeber();
    }

    @FXML
    public void pressDbSettings() throws Exception{
    konfig.gotoSettings();
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
    
    
    
}
