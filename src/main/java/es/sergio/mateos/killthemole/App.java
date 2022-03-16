package es.sergio.mateos.killthemole;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Pane root = new Pane();
        
        short tamXPantalla = 400;
        short tamYPantalla = 600;
        
        var scene = new Scene(root, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false); // BLOQUEAR REESCALADO DE LA VENTANA
        Image image = new Image("/images/mazo0.png");  //pass in the image path
        scene.setCursor(new ImageCursor(image));
        
        LogicaInterna logicaInterna = new LogicaInterna((short)3,(short)4);
        LogicaGrafica logicaGrafica = new LogicaGrafica();
        UserRegister userRegister = new UserRegister();
        HomeScreen homeScreen = new HomeScreen();
        
        homeScreen.creacionPosterTitulo(root, scene, logicaInterna, logicaGrafica, userRegister);
    }
    
    
    public static void main(String[] args) {
        launch();
    }

}