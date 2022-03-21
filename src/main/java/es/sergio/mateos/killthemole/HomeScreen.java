package es.sergio.mateos.killthemole;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class HomeScreen {
    LogicaInterna logicaInterna;
    LogicaGrafica logicaGrafica;
    UserRegister userRegister;
    Timeline animacionBajarPoster;
    Timeline animacionSubirStart;
    Timeline animacionSubirExit;
    Timeline animacionBajarStart;
    Timeline animacionBajarExit;
    Timeline animacionMoverCreditos;
    Timeline animacionQuitarCreditos;
    Timeline animacionMoverPlay;
    Timeline animacionSubirPlay;
    Timeline animacionMoverPosterGrande;
    Timeline animacionMoverRecord;
    
    // CREACIÓN DE OBJETOS //
    Label labelCreditos;
    Label labelRecord;
    ImageView cieloScreen1;
    ImageView cieloScreen2;
    ImageView posterTitulo;
    ImageView botonStart;
    ImageView botonExit;
    ImageView botonPlay;
    ImageView posterGrande;
    Timeline movimientoCieloScreen;
    Timeline comprobarAnimaciones;
    
    // VARIABLES //
    
    boolean depuracion = false;
    
    double cieloScreen1PosX = 0;
    double cieloScreen2PosX = 400;
    double posterTituloPosX = 0;
    double posterTituloPosY = -200;
    double botonStartPosX = 50;
    double botonStartPosY = 600;
    double botonExitPosX = 210;
    double botonExitPosY = 600;
    double botonPlayPosX = 115;
    double botonPlayPosY = 600;
    double labelCreditosPosX = 600;
    double posterGrandePosX = 600;
    double posterGrandePosY = 130;
    double labelRecordPosX = 600;
    
    public void creacionPosterTitulo(Pane root,  Scene scene, LogicaInterna logicaInterna, LogicaGrafica logicaGrafica, UserRegister userRegister){
        this.logicaInterna = logicaInterna;
        this.logicaGrafica = logicaGrafica;
        this.userRegister = userRegister;
        
        Image cieloScreenImg = new Image(getClass().getResourceAsStream("/images/cieloScreen.png")); // CARGA LA IMAGEN DE FONDO
        Image posterTituloImg = new Image(getClass().getResourceAsStream("/images/imageTitle.png")); // CARGA LA IMAGEN DEL POSTER DEL TITULO
        Image botonStartImg = new Image(getClass().getResourceAsStream("/images/botonStart.png")); // CARGA LA IMAGEN DEL BOTON START
        Image botonExitImg = new Image(getClass().getResourceAsStream("/images/botonExit.png")); // CARGA LA IMAGEN DEL BOTON EXIT
        Image botonPlayImg = new Image(getClass().getResourceAsStream("/images/botonPlay.png")); // CARGA LA IMAGEN DEL BOTON PLAY
        Image posterGrandeImg = new Image(getClass().getResourceAsStream("/images/tablonGrande.png")); // CARGA LA IMAGEN DEL POSTER GRANDE
        cieloScreen1 = new ImageView(cieloScreenImg); // CREA EL OBJETO cielo1
        cieloScreen2 = new ImageView(cieloScreenImg); // CREA EL OBJETO cielo2
        posterTitulo = new ImageView(posterTituloImg); // CREA EL OBJETO posterTitulo
        botonStart = new ImageView(botonStartImg); // CREA EL OBJETO botonStart
        botonExit = new ImageView(botonExitImg); // CREA EL OBJETO botonExit
        botonPlay = new ImageView(botonPlayImg); // CREA EL OBJETO botonPlay
        posterGrande = new ImageView(posterGrandeImg); // CREA EL OBJETO posterGrande
        root.getChildren().add(cieloScreen1); // AÑADE EL OBJETO AL ROOT
        root.getChildren().add(cieloScreen2); // AÑADE EL OBJETO AL ROOT
        root.getChildren().add(posterTitulo); // AÑADE EL OBJETO AL ROOT
        root.getChildren().add(botonStart); // AÑADE EL OBJETO AL ROOT
        root.getChildren().add(botonExit); // AÑADE EL OBJETO AL ROOT
        root.getChildren().add(botonPlay); // AÑADE EL OBJETO AL ROOT
        root.getChildren().add(posterGrande); // AÑADE EL OBJETO AL ROOT
        cieloScreen1.setLayoutX(cieloScreen1PosX); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        posterTitulo.setLayoutX(posterTituloPosX); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        posterTitulo.setLayoutY(posterTituloPosY); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        botonStart.setLayoutX(botonStartPosX); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        botonStart.setLayoutY(botonStartPosY); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        botonExit.setLayoutX(botonExitPosX); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        botonExit.setLayoutY(botonExitPosY); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        botonPlay.setLayoutX(botonPlayPosX); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        botonPlay.setLayoutY(botonPlayPosY); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        posterGrande.setLayoutX(posterGrandePosX); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        posterGrande.setLayoutY(posterGrandePosY); // ESTABLECEMOS LAS COORDENADAS DEL OBJETO HA LAS ESPECIFICADAS EN EL INICIO DEL PROGRAMA
        
        userRegister.readFileInt("files/record.txt"); // LLAMA AL METODO QUE LEE EL FICHERO QUE ALMACENA LA PUNTUACION RECORD
        userRegister.readFileString("files/usuarioRecord.txt"); // LLAMA AL METODO QUE LEE EL FICHERO QUE ALMACENA EL NOMBRE DEL JUGADOR QUE TIENE EL RECORD DE PUNTUACION
        
        ///////// CREAMOS EL LABEL DE CREDITOS ////////////
        labelCreditos = new Label("Developed by Sergio Mateos"); // CREAMOS UN LABEL PARA LOS CREDITOS DE DESAROLLO
        Font font = Font.loadFont(getClass().getResourceAsStream("/fonts/go3v2.ttf"), 20); // ESTABLECE ALGUNOS AJUSTES EN EL LABEL DE LOS CREDITOS
        font = Font.font("Gang of Three", FontWeight.BOLD, FontPosture.REGULAR, 20); // ESTABLECEMOS ALGUNAS DE LAS PROPIEDADES DE LA FUENTE DEL TEXTO
        labelCreditos.setFont(font); // CON ESTO LE APLICAMOS LAS POPIEDADES DE LA FUENTE AL TEXTO
        labelCreditos.setTextFill(Color.rgb(65, 45, 42)); // CAMBIA EL COLOR DEL TEXTO A NEGRO
        labelCreditos.setTranslateX(400); // CAMBIA LAS COORDENADAS X DEL TEXTO
        labelCreditos.setTranslateY(500); // CAMBIA LAS COORDENADAS Y DEL TEXTO
        root.getChildren().add(labelCreditos); // AÑADE EL OBJETO AL ROOT
        /////////////////////////////////////////////////
        ///////// CREAMOS EL LABEL DE RECORD ////////////
        labelRecord = new Label(userRegister.usuarioRecord+": "+userRegister.recordActual);
        font = Font.font("Gang of Three", FontWeight.BOLD, FontPosture.REGULAR, 30); // ESTABLECEMOS ALGUNAS DE LAS PROPIEDADES DE LA FUENTE DEL TEXTO
        labelRecord.setFont(font); // CON ESTO LE APLICAMOS LAS POPIEDADES DE LA FUENTE AL TEXTO
        labelRecord.setTextFill(Color.rgb(65, 45, 42)); // CAMBIA EL COLOR DEL TEXTO A NEGRO
        labelRecord.setTranslateX(400); // CAMBIA LAS COORDENADAS X DEL TEXTO
        labelRecord.setTranslateY(300); // CAMBIA LAS COORDENADAS Y DEL TEXTO
        root.getChildren().add(labelRecord); // AÑADE EL OBJETO AL ROOT
        /////////////////////////////////////////////////
        userRegister.registroNombre(logicaInterna); // LLAMA AL METODO QUE REALIZA EL REGISTRO DEL NOMBRE DEL USUARIO ACTUAL
        scrollCieloScreen(); // LLAMA AL METODO QUE SE ENCARGA DEL SCROLL DEL FONDO
        iniciarPantalla(); // LLAMA AL METODO QUE SE ENCARGA DE INICIAR LAS ANIMACIONES DEL MENUI PRINCIPAL
        controlAnimaciones(); // LLAMA AL METODO QUE CONTROLA LAS ANIMACIONES DEL MENU
        botonStart.setOnMousePressed((MouseEvent mouseEvent) -> { // CONTROLA LA DETECCION DEL BOTON START
            if(depuracion==true){
                System.out.println("Se pulsa el botón Start");
            }
            animacionBajarStart.play();
            animacionBajarExit.play();
            animacionQuitarCreditos.play();
        });
        botonExit.setOnMousePressed((MouseEvent mouseEvent) -> { // CONTROLA LA DETECCION DEL BOTON EXIT
            if(depuracion==true){
                System.out.println("Salir de la partida");
            }
            System.exit(0);
        });
        labelCreditos.setOnMousePressed((MouseEvent mouseEvent) -> { // CONTROLA LA DETECCION DEL LABEL DE LOS CREDITOS
            if(depuracion==true){
                System.out.println("Se pulsa el label Creditos");
            }
            if(depuracion==true){
                System.out.println("Visitando sergiomateosdev.es");
            }
            String url = "http://sergiomateosdev.es/"; // CARGA LA URL QUE VA A MOSTRAR EN UNA VARIABLE
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url); // BUSCA LA URL ALMACENADA EN LA VARIABLE EN LA WEB
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        });
        botonPlay.setOnMousePressed((MouseEvent mouseEvent) -> { // CONTROLA LA DETECCION DEL BOTON PLAY
            logicaGrafica.dibujarPradera(root, scene, logicaInterna, logicaGrafica, userRegister);
            logicaGrafica.scrollCielo();
            logicaGrafica.generarTopo();
            logicaGrafica.generarBomba();
            logicaGrafica.generarTopoDorado();
            animacionBajarStart.stop();
            animacionBajarExit.stop();
            animacionQuitarCreditos.stop();
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
                if(labelCreditosPosX <=60){
                    animacionMoverCreditos.stop();
                }
                if(botonStartPosY>600){
                    animacionBajarStart.stop();
                    animacionMoverPosterGrande.play();
                    animacionSubirPlay.play();
                    animacionMoverRecord.play();
                }
                if(botonExitPosY>600){
                    animacionBajarExit.stop();
                }
                if(labelCreditosPosX>400){
                    animacionQuitarCreditos.stop();
                }
                if(posterGrandePosX<=10){
                    animacionMoverPosterGrande.stop();
                }
                if(botonPlayPosY<=470){
                    animacionSubirPlay.stop();
                }
                if(labelRecordPosX <=100){
                    animacionMoverRecord.stop();
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
        
        animacionBajarStart = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                botonStartPosY = botonStartPosY + 7;
                botonStart.setLayoutY(botonStartPosY);
            })
        );
        animacionBajarStart.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionBajarStart.stop(); // EJECUTAR EL TIMELINE
        
        animacionSubirExit = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                botonExitPosY = botonExitPosY - 5;
                botonExit.setLayoutY(botonExitPosY);
            })
        );
        animacionSubirExit.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionSubirExit.play(); // EJECUTAR EL TIMELINE
        
        animacionBajarExit = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                botonExitPosY = botonExitPosY + 7;
                botonExit.setLayoutY(botonExitPosY);
            })
        );
        animacionBajarExit.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionBajarExit.stop(); // EJECUTAR EL TIMELINE
        
        animacionMoverCreditos = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                labelCreditosPosX = labelCreditosPosX - 9;
                 labelCreditos.setTranslateX(labelCreditosPosX);
            })
        );
        animacionMoverCreditos.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionMoverCreditos.play(); // EJECUTAR EL TIMELINE
        
        animacionQuitarCreditos = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                labelCreditosPosX = labelCreditosPosX + 9;
                 labelCreditos.setTranslateX(labelCreditosPosX);
            })
        );
        animacionQuitarCreditos.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionQuitarCreditos.stop(); // EJECUTAR EL TIMELINE
        
        animacionSubirPlay = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                botonPlayPosY = botonPlayPosY - 5;
                botonPlay.setLayoutY(botonPlayPosY);
            })
        );
        animacionSubirPlay.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionSubirPlay.stop(); // EJECUTAR EL TIMELINE
        
        animacionMoverPosterGrande = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                posterGrandePosX = posterGrandePosX - 9;
                posterGrande.setLayoutX(posterGrandePosX);
            })
        );
        animacionMoverPosterGrande.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionMoverPosterGrande.stop(); // EJECUTAR EL TIMELINE
        
        animacionMoverRecord = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                labelRecordPosX = labelRecordPosX - 7;
                labelRecord.setTranslateX(labelRecordPosX);
            })
        );
        animacionMoverRecord.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionMoverRecord.stop(); // EJECUTAR EL TIMELINE
    }
    
}
