package es.sergio.mateos.killthemole;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;



public class App extends Application {
    
    
    int posColumna = 0;
    int posFila = 0;
    boolean colocado = true;
    
    @Override
    public void start(Stage stage) {
        
        Pane root = new Pane();
        
        short tamXPantalla = 400;
        short tamYPantalla = 600;
        
        var scene = new Scene(root, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        
        LogicaInterna logicaInterna = new LogicaInterna((short)3,(short)4);
        LogicaGrafica logicaGrafica = new LogicaGrafica();
        
        logicaGrafica.dibujarPradera(root);
        logicaGrafica.scrollCielo();
        logicaGrafica.generarTopo();
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}