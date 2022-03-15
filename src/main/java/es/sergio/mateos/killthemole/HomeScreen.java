package es.sergio.mateos.killthemole;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HomeScreen {
    LogicaInterna logicaInterna;
    LogicaGrafica logicaGrafica;
    Timeline animacionBajarPoster;
    Timeline animacionSubirStart;
    Timeline animacionSubirExit;
    
    // CREACIÓN DE OBJETOS //
    ImageView cieloScreen1;
    ImageView cieloScreen2;
    ImageView posterTitulo;
    ImageView botonStart;
    ImageView botonExit;
    Timeline movimientoCieloScreen;
    Timeline comprobarAnimaciones;
    
    // VARIABLES //
//    double cieloScreen1PosX = 0;
//    double cieloScreen2PosX = 400;
//    double posterTituloPosX = 0;
//    double posterTituloPosY = 30;
//    double botonStartPosX = 50;
//    double botonStartPosY = 280;
//    double botonExitPosX = 210;
//    double botonExitPosY = 280;
    double cieloScreen1PosX = 0;
    double cieloScreen2PosX = 400;
    double posterTituloPosX = 0;
    double posterTituloPosY = -100;
    double botonStartPosX = 50;
    double botonStartPosY = 600;
    double botonExitPosX = 210;
    double botonExitPosY = 600;
    
    public void creacionPosterTitulo(Pane root,  Scene scene, LogicaInterna logicaInterna, LogicaGrafica logicaGrafica){
        this.logicaInterna = logicaInterna;
        this.logicaGrafica = logicaGrafica;
        
        Image cieloScreenImg = new Image(getClass().getResourceAsStream("/images/cieloScreen.png")); // CARGA LA IMAGEN DE FONDO
        Image posterTituloImg = new Image(getClass().getResourceAsStream("/images/imageTitle.png")); // CARGA LA IMAGEN DE FONDO
        Image botonStartImg = new Image(getClass().getResourceAsStream("/images/botonStart.png")); // CARGA LA IMAGEN DE FONDO
        Image botonExitImg = new Image(getClass().getResourceAsStream("/images/botonExit.png")); // CARGA LA IMAGEN DE FONDO
        cieloScreen1 = new ImageView(cieloScreenImg); // CREA EL OBJETO cielo1
        cieloScreen2 = new ImageView(cieloScreenImg); // CREA EL OBJETO cielo2
        posterTitulo = new ImageView(posterTituloImg);
        botonStart = new ImageView(botonStartImg);
        botonExit = new ImageView(botonExitImg);
        root.getChildren().add(cieloScreen1);
        root.getChildren().add(cieloScreen2);
        root.getChildren().add(posterTitulo);
        root.getChildren().add(botonStart);
        root.getChildren().add(botonExit);
        cieloScreen1.setLayoutX(cieloScreen1PosX);
        posterTitulo.setLayoutX(posterTituloPosX);
        posterTitulo.setLayoutY(posterTituloPosY);
        botonStart.setLayoutX(botonStartPosX);
        botonStart.setLayoutY(botonStartPosY);
        botonExit.setLayoutX(botonExitPosX);
        botonExit.setLayoutY(botonExitPosY);
        scrollCieloScreen();
        iniciarPantalla();
        controlAnimaciones();
        botonStart.setOnMousePressed((MouseEvent mouseEvent) -> {
            logicaGrafica.dibujarPradera(root, scene, logicaInterna, logicaGrafica);
            logicaGrafica.scrollCielo();
            logicaGrafica.generarTopo();
            logicaGrafica.generarBomba();
            logicaGrafica.generarTopoDorado();
        });
        botonExit.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Salir de la partida");
            System.exit(0);
        });
    }
    
    public void scrollCieloScreen(){
        movimientoCieloScreen = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                cieloScreen1PosX = cieloScreen1PosX - 0.5;
                cieloScreen2PosX = cieloScreen2PosX - 0.5;
                cieloScreen1.setLayoutX(cieloScreen1PosX);
                cieloScreen2.setLayoutX(cieloScreen2PosX);
                if(cieloScreen1PosX <= -400){
                    cieloScreen1PosX = 400;
                } else if(cieloScreen2PosX <= - 400){
                    cieloScreen2PosX = 400;
                }
                
            })
        );
        movimientoCieloScreen.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        movimientoCieloScreen.play(); // EJECUTAR EL TIMELINE
    }
    
    public void controlAnimaciones(){
        comprobarAnimaciones = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                if(posterTituloPosY>=50){
                    animacionBajarPoster.stop();
                }
                if(botonStartPosY<=280){
                    animacionSubirStart.stop();
                }
                if(botonExitPosY<=280){
                    animacionSubirExit.stop();
                }
            })
        );
        comprobarAnimaciones.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        comprobarAnimaciones.play(); // EJECUTAR EL TIMELINE
    }
    
    public void iniciarPantalla(){
        animacionBajarPoster = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                posterTituloPosY = posterTituloPosY + 5;
                posterTitulo.setLayoutY(posterTituloPosY);
            })
        );
        animacionBajarPoster.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionBajarPoster.play(); // EJECUTAR EL TIMELINE
        
        animacionSubirStart = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                botonStartPosY = botonStartPosY - 5;
                botonStart.setLayoutY(botonStartPosY);
            })
        );
        animacionSubirStart.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionSubirStart.play(); // EJECUTAR EL TIMELINE
        
        animacionSubirExit = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                botonExitPosY = botonExitPosY - 5;
                botonExit.setLayoutY(botonExitPosY);
            })
        );
        animacionSubirExit.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionSubirExit.play(); // EJECUTAR EL TIMELINE
    }
    
}
