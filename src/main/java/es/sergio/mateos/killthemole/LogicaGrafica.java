package es.sergio.mateos.killthemole;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventType;
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

public class LogicaGrafica {
    
    LogicaInterna logicaInterna = new LogicaInterna();
    
    //CONSTANTES//
    final double suelo1TopoPosX = 16;
    final double suelo1TopoPosY = 242;
    
    final double suelo2TopoPosX = 139;
    final double suelo2TopoPosY = 242;
    
    final double suelo3TopoPosX = 265;
    final double suelo3TopoPosY = 242;
    
    final double suelo4TopoPosX = 16;
    final double suelo4TopoPosY = 334;
    
    final double suelo5TopoPosX = 139;
    final double suelo5TopoPosY = 334;
    
    final double suelo6TopoPosX = 265;
    final double suelo6TopoPosY = 334;
    
    final double suelo7TopoPosX = 16;
    final double suelo7TopoPosY = 424.5;
    
    final double suelo8TopoPosX = 139;
    final double suelo8TopoPosY = 424.5;
    
    final double suelo9TopoPosX = 265;
    final double suelo9TopoPosY = 424.5;
    
    final double suelo10TopoPosX = 16;
    final double suelo10TopoPosY = 516;
    
    final double suelo11TopoPosX = 139;
    final double suelo11TopoPosY = 516;
    
    final double suelo12TopoPosX = 265;
    final double suelo12TopoPosY = 516;
    /////////////
    
    ImageView cielo1;
    ImageView cielo2;
    ImageView pradera;
    ImageView topo;
    ImageView suelo1Topo;
    ImageView suelo2Topo;
    ImageView suelo3Topo;
    ImageView suelo4Topo;
    ImageView suelo5Topo;
    ImageView suelo6Topo;
    ImageView suelo7Topo;
    ImageView suelo8Topo;
    ImageView suelo9Topo;
    ImageView suelo10Topo;
    ImageView suelo11Topo;
    ImageView suelo12Topo;
    ImageView fondoScore;
    
    Label labelPuntos; // AÑADIMOS EL OBJETO LABELPUNTOS
    
    // VARIABLES //
    double cielo1PosX = 0;
    double cielo2PosX = 400;
    double topoPosX = 35;
    double topoPosY = 260;
    double fondoScorePosX = 10;
    double fondoScorePosY = 10;
    int direccionTopo = 0;
//    double velocidadTopo = 2;
//    double limite1AnimacionTopo = 15;
//    double limite2AnimacionTopo = 35;
    double velocidadTopo = 1;
    double limite1AnimacionTopo = velocidadTopo * 30;
    double limite2AnimacionTopo = velocidadTopo * 70;
    int contadorAnimacion=0;
    boolean continuarAnimacion = true;
    boolean permitirPulsacion = true;
    
    boolean colocado = true;
    int posColumna = 0;
    int posFila = 0;
    int puntos = 0;
    
    Timeline animacion;
    ///////////////
    
    public void crearLabelPuntos(Pane root){ // ESTE METODO CREA LOS TEXTOS QUE VAMOS A VER EN PANTALLA Y NOS DICEN LAS PUNTUACIÓN EN EL JUEGO
        labelPuntos = new Label(""+puntos); // ESTO MUESTRA EN PANATALLA LOS PUTNOS ACUTALES
        Font font = Font.loadFont("file:resources/fonts/go3v2.ttf", 25);
        font = Font.font("Gang Of Three Normal", FontWeight.BOLD, FontPosture.REGULAR, 25); // ESTABLECEMOS ALGUNAS DE LAS PROPIEDADES DE LA FUENTE DEL TEXTO
        labelPuntos.setFont(font); // CON ESTO LE APLICAMOS LAS POPIEDADES DE LA FUENTE AL TEXTO
        labelPuntos.setTextFill(Color.rgb(65, 45, 42)); // CAMBIA EL COLOR DEL TEXTO A NEGRO
        labelPuntos.setTranslateX(105); // CAMBIA LAS COORDENADAS X DEL TEXTO
        labelPuntos.setTranslateY(26); // CAMBIA LAS COORDENADAS Y DEL TEXTO
        root.getChildren().add(labelPuntos); // AÑADE EL TEXTO LABELPUTNOS AL ROOT
    }
    
    private void cambiarLabelPuntos(){ // ESTE METODO ACTUALIZA EL LABEL DE PUTNOS QUE SE MUESTRA EN LA PANTALLA DURANTE LA PARTIDA
        
        labelPuntos.setText(""); // PRIMERO BORRAMOS EL TEXTO QUE YA SE ESTABA MOSTRANDO
        labelPuntos.setText(""+puntos); // Y ESCRIBIMOS EL TEXTO NUEVO, CON LA PUNTUACION ACTUALIZADA
    }
    
    public void dibujarPradera(Pane root){
        Image cieloImg = new Image(getClass().getResourceAsStream("/images/cielo.png")); // CARGA LA IMAGEN DE FONDO
        Image praderaImg = new Image(getClass().getResourceAsStream("/images/pradera.png")); // CARGA LA IMAGEN DE FONDO
        Image topoImg = new Image(getClass().getResourceAsStream("/images/topo.png")); // CARGA LA IMAGEN DEL TOPO
        Image sueloTopoImg = new Image(getClass().getResourceAsStream("/images/agujero.png")); // CARGA LA IMAGEN DEL AGUJERO
        Image fondoScoreImg = new Image(getClass().getResourceAsStream("/images/imageScore140x70.png")); // CARGA LA IMAGEN DEL FONDO DE LA PUNTUACION
        cielo1 = new ImageView(cieloImg); // CREA EL OBJETO cielo1
        cielo2 = new ImageView(cieloImg); // CREA EL OBJETO cielo2
        pradera = new ImageView(praderaImg); // CREA EL OBJETO pradera
        topo = new ImageView(topoImg); // CREA EL OBJETO topo
        suelo1Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo2Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo3Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo4Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo5Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo6Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo7Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo8Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo9Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo10Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo11Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo12Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        suelo12Topo = new ImageView(sueloTopoImg); // CREA EL OBJETO sueloTopo
        fondoScore = new ImageView(fondoScoreImg); // CREA EL OBJETO sueloTopo
        root.getChildren().add(cielo1);
        root.getChildren().add(cielo2);
        root.getChildren().add(pradera);
        root.getChildren().add(topo);
        root.getChildren().add(suelo1Topo);
        root.getChildren().add(suelo2Topo);
        root.getChildren().add(suelo3Topo);
        root.getChildren().add(suelo4Topo);
        root.getChildren().add(suelo5Topo);
        root.getChildren().add(suelo6Topo);
        root.getChildren().add(suelo7Topo);
        root.getChildren().add(suelo8Topo);
        root.getChildren().add(suelo9Topo);
        root.getChildren().add(suelo10Topo);
        root.getChildren().add(suelo11Topo);
        root.getChildren().add(suelo12Topo);
        root.getChildren().add(fondoScore);
        cielo1.setLayoutX(cielo1PosX);
        cielo2.setLayoutX(cielo2PosX);
        topo.setLayoutX(topoPosX);
        topo.setLayoutY(topoPosY);
        suelo1Topo.setLayoutX(suelo1TopoPosX);
        suelo1Topo.setLayoutY(suelo1TopoPosY);
        suelo2Topo.setLayoutX(suelo2TopoPosX);
        suelo2Topo.setLayoutY(suelo2TopoPosY);
        suelo3Topo.setLayoutX(suelo3TopoPosX);
        suelo3Topo.setLayoutY(suelo3TopoPosY);
        suelo4Topo.setLayoutX(suelo4TopoPosX);
        suelo4Topo.setLayoutY(suelo4TopoPosY);
        suelo5Topo.setLayoutX(suelo5TopoPosX);
        suelo5Topo.setLayoutY(suelo5TopoPosY);
        suelo6Topo.setLayoutX(suelo6TopoPosX);
        suelo6Topo.setLayoutY(suelo6TopoPosY);
        suelo7Topo.setLayoutX(suelo7TopoPosX);
        suelo7Topo.setLayoutY(suelo7TopoPosY);
        suelo8Topo.setLayoutX(suelo8TopoPosX);
        suelo8Topo.setLayoutY(suelo8TopoPosY);
        suelo9Topo.setLayoutX(suelo9TopoPosX);
        suelo9Topo.setLayoutY(suelo9TopoPosY);
        suelo10Topo.setLayoutX(suelo10TopoPosX);
        suelo10Topo.setLayoutY(suelo10TopoPosY);
        suelo11Topo.setLayoutX(suelo11TopoPosX);
        suelo11Topo.setLayoutY(suelo11TopoPosY);
        suelo12Topo.setLayoutX(suelo12TopoPosX);
        suelo12Topo.setLayoutY(suelo12TopoPosY);
        fondoScore.setLayoutX(fondoScorePosX);
        fondoScore.setLayoutY(fondoScorePosY);
        
        topo.setOnMousePressed((MouseEvent mouseEvent) -> {
            // Cambia el color del circulo cuando clickas en un circulo
            if(permitirPulsacion==true){
                puntos++;
                cambiarLabelPuntos();
                System.out.println("Has conseguido un punto, total: "+puntos);
                permitirPulsacion = false;
            }
        });
    }
    
    public void scrollCielo(){
        Timeline movimientoCielo = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                cielo1PosX = cielo1PosX - 0.5;
                cielo2PosX = cielo2PosX - 0.5;
                cielo1.setLayoutX(cielo1PosX);
                cielo2.setLayoutX(cielo2PosX);
                if(cielo1PosX <= -400){
                    cielo1PosX = 400;
                } else if(cielo2PosX <= - 400){
                    cielo2PosX = 400;
                }
                
            })
        );
          
        movimientoCielo.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        movimientoCielo.play(); // EJECUTAR EL TIMELINE
    }
    
    public void generarTopo(){
        Timeline generarTopo = new Timeline(
                  new KeyFrame(Duration.seconds(2), (ActionEvent ae) -> {
                        
                        colocado = logicaInterna.colocarFicha(posColumna, posFila, 2);
                        posColumna = (int) (Math.random() * (3 -0)) + 0;
                        posFila = (int) (Math.random() * (4 -0)) + 0;
                        colocado = logicaInterna.colocarFicha(posColumna, posFila, 1);
                        if(colocado == true) {
                            logicaInterna.mostrarTableroConsola();
                            changeMoleImgPosition();
                            permitirPulsacion = true;
                        }
                  })
        );
        generarTopo.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        generarTopo.play(); // EJECUTAR EL TIMELINE
    }
    
    public void animacionTopo(){
        direccionTopo = 1;
        contadorAnimacion = 0;
        animacion = new Timeline(
                  new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                        ejecutarAnimacionTopo();
                  })
        );
        animacion.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacion.play(); // EJECUTAR EL TIMELINE
    }
    public void ejecutarAnimacionTopo(){
        contadorAnimacion++;
        if (contadorAnimacion==limite2AnimacionTopo)
        {
            direccionTopo = 0;
            animacion.stop();
        }
        if (contadorAnimacion==limite1AnimacionTopo)
        {
            direccionTopo = -1;
        }
        if (direccionTopo == 1)
        {
            topoPosY = topoPosY - velocidadTopo;
            topo.setLayoutY(topoPosY);
        }
        if (direccionTopo == -1)
        {
            topoPosY = topoPosY + velocidadTopo;
            topo.setLayoutY(topoPosY);
        }
    }
    
    
    public void changeMoleImgPosition(){
        int posicionXTopo = logicaInterna.obtenerPosicionTopo()[0];
        int posicionYTopo = logicaInterna.obtenerPosicionTopo()[1];
        if(posicionXTopo==0){
            topoPosX = 30;
            topo.setLayoutX(topoPosX);
            System.out.println("te cambio la X a: "+topoPosX);
        }
        if(posicionXTopo==1){
            topoPosX = 155;
            topo.setLayoutX(topoPosX);
            System.out.println("te cambio la X a: "+topoPosX);
        }
        if(posicionXTopo==2){
            topoPosX = 285;
            topo.setLayoutX(topoPosX);
            System.out.println("te cambio la X a: "+topoPosX);
        }
        if(posicionYTopo==0){
            topoPosY = 250;
            topo.setLayoutY(topoPosY);
            System.out.println("te cambio la Y a: "+topoPosY);
        }
        if(posicionYTopo==1){
            topoPosY = 340;
            topo.setLayoutY(topoPosY);
            System.out.println("te cambio la Y a: "+topoPosY);
        }
        if(posicionYTopo==2){
            topoPosY = 430;
            topo.setLayoutY(topoPosY);
            System.out.println("te cambio la Y a: "+topoPosY);
        }
        if(posicionYTopo==3){
            topoPosY = 525;
            topo.setLayoutY(topoPosY);
            System.out.println("te cambio la Y a: "+topoPosY);
        }
        animacionTopo();
    }
    
    
}
