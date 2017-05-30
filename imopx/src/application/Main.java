package application;


import java.io.InputStream;

	import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
	import javafx.fxml.JavaFXBuilderFactory;
	import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
	import javafx.scene.layout.AnchorPane;

	

	public class Main extends Application {
	    
		 private Stage stage;
		    private final double MINIMUM_WINDOW_WIDTH = 1024.0;
		    private final double MINIMUM_WINDOW_HEIGHT = 600.0;
		    //private User _persowareUser =  new User();
		
		    
		    @Override
		    public void start(Stage primaryStage) throws Exception {
		        stage = primaryStage;
		       
		        stage.setTitle("ImpoXi - Import Tool");
		        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		        Image icon = new Image(getClass().getResourceAsStream("ProduktIcon.png"));
		      
		        stage.getIcons().add(icon);
		        gotoMain();
		        primaryStage.show();
		   
		    }
		    
		    public void gotoKonfig() throws Exception{
                
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Konfig.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1)); 
                            stage.setTitle("ImpoXi - Import Tool - Konfiguration");
                            Image icon = new Image(getClass().getResourceAsStream("ProduktIcon.png"));
                            stage.getIcons().add(icon);
                            stage.setWidth(1300);
                            stage.setHeight(600);
                            stage.show();
                    } catch(Exception e) {
                       e.printStackTrace();
                      }
             
            }

		    public void gotoHelp() throws Exception{
                
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Help.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1)); 
                            stage.setTitle("ImpoXi - Import Tool - Help");
                            Image icon = new Image(getClass().getResourceAsStream("ProduktIcon.png"));
                            stage.getIcons().add(icon);
                            stage.setWidth(900);
                            stage.setHeight(600);
                            stage.show();
                    } catch(Exception e) {
                       e.printStackTrace();
                      }
             
            }
		    public void gotoUeber() throws Exception{
                
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ueber.fxml"));
                            Parent root1 = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1)); 
                            stage.setTitle("ImpoXi - Import Tool - Über Uns");
                            Image icon = new Image(getClass().getResourceAsStream("ProduktIcon.png"));
                            stage.getIcons().add(icon);
                            stage.setWidth(600);
                            stage.setHeight(450);
                            stage.show();
                    } catch(Exception e) {
                       e.printStackTrace();
                      }
             
            }

		    
		    public void gotoSettings() throws Exception{
		        
		        try {
		            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
		                    Parent root1 = (Parent) fxmlLoader.load();
		                    Stage stage = new Stage();
		                    stage.setScene(new Scene(root1));
		                    stage.setTitle("ImpoXi - Import Tool - Einstellungen");
		                    Image icon = new Image(getClass().getResourceAsStream("ProduktIcon.png"));
		                    stage.getIcons().add(icon);
		                    stage.setWidth(600);
		                    stage.setHeight(600);
		                    stage.show(); 
		            } catch(Exception e) {
		               e.printStackTrace();
		              }
             
		    }
		    
		    public void gotoMain() {
		 
		        try {
		            final MainWindowController main = (MainWindowController) generateSceneContent("impoXiProto.fxml");// Pfad anpassen
		            main.setMain(this);
		            
		        }  catch ( Exception e){
		            e.printStackTrace();
		        }
		    }
		    
		    public void gotoPara() throws Exception{
		    	try{
		    		final ParaWindowController para = (ParaWindowController) replaceSceneContent("Paragraph.fxml");
		    		para.setApp(this);
		    	}
		    	catch (Exception e){
		            e.printStackTrace();
		        }
		    }
		    
		    public void gotoLoinc() throws Exception{
		    	try{
		    		final LoincWindowController loinc = (LoincWindowController) replaceSceneContent("Loinc.fxml");
		    		loinc.setApp(this);
		    	}
		    	catch (Exception e){
		            e.printStackTrace();
		        }
		    }
		    
		    public void gotoSnomed() throws Exception{
		    	try{
		    		final SnomedWindowController snomed = (SnomedWindowController) replaceSceneContent("Snomed.fxml");
		    		snomed.setApp(this);
		    	}
		    	catch (Exception e){
		            e.printStackTrace();
		        }
		    }
		    
		    
		    
		    
		    private Object replaceSceneContent(String fxml) throws Exception {
		        FXMLLoader loader = new FXMLLoader();
		        InputStream in = Main.class.getResourceAsStream(fxml);
		        loader.setBuilderFactory(new JavaFXBuilderFactory());
		        loader.setLocation(Main.class.getResource(fxml));
		        AnchorPane page;
		        try {
		            page = loader.load(in);
		        } finally {
		            in.close();
		        }
		        page.autosize();
		        stage.getScene().setRoot(page);
		        //stage.sizeToScene();
		        
		        return loader.getController();
		    }
		    
		     private Object generateSceneContent(String fxml) throws Exception {
		        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));
		        InputStream  in = Main.class.getResourceAsStream(fxml);
		        loader.setBuilderFactory(new JavaFXBuilderFactory());
		        loader.setLocation(Main.class.getResource(fxml));
		        AnchorPane page;
		        try {
		            page = loader.load(in);
		        } finally {
		            in.close();
		        }
		        Scene scene = new Scene(page, 1024, 600);
		        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		        stage.setResizable(true);
		        stage.setScene(scene);        
		        stage.sizeToScene();
		        return loader.getController();
		        
		    }
		     
	        
		
	    
		public static void main(String[] args) {
			launch(args);
		}
	}



