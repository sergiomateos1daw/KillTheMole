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

public class LogicaGrafica {
    
    LogicaInterna logicaInterna;
    LogicaGrafica logicaGrafica;
    
    
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
    ImageView bomba;
    ImageView topoDorado;
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
    ImageView explosion;
    
//    Label labelPuntos; // AÑADIMOS EL OBJETO LABELPUNTOS
    
    // VARIABLES //
    double cielo1PosX = 0;
    double cielo2PosX = 400;
    double topoPosX = 35;
    double topoPosY = 260;
    double bombaPosX = 35;
    double bombaPosY = 260;
    double topoDoradoPosX = 35;
    double topoDoradoPosY = 260;
    double fondoScorePosX = 10;
    double fondoScorePosY = 10;
    double explosionPosX = -100;
    double explosionPosY = -100;
    int direccionTopo = 0;
    int direccionBomba = 0;
    int direccionTopoDorado = 0;
//    double velocidadTopo = 2;
//    double limite1AnimacionTopo = 15;
//    double limite2AnimacionTopo = 35;
    double velocidadTopo = 1;
    double limite1AnimacionTopo = velocidadTopo * 30;
    double limite2AnimacionTopo = velocidadTopo * 70;
    double velocidadBomba = 1;
    double limite1AnimacionBomba = velocidadBomba * 30;
    double limite2AnimacionBomba = velocidadBomba * 70;
    double velocidadTopoDorado = 1;
    double limite1AnimacionTopoDorado = velocidadTopoDorado * 30;
    double limite2AnimacionTopoDorado = velocidadTopoDorado * 70;
    int contadorAnimacionTopo=0;
    int contadorAnimacionBomba=0;
    int contadorAnimacionTopoDorado=0;
    boolean permitirPulsacionTopo = true;
    boolean permitirPulsacionBomba = true;
    boolean permitirPulsacionTopoDorado = true;
    boolean colocadoTopo = true;
    boolean colocadoBomba = true;
    boolean colocadoTopoDorado = true;
    int posColumnaTopo = 0;
    int posFilaTopo = 0;
    int posColumnaBomba = 0;
    int posFilaBomba = 0;
    int posColumnaTopoDorado = 0;
    int posFilaTopoDorado = 0;
    double velocidadAparicionBomba = 10;
    boolean cambiarCursor = false;
    
    Timeline animacionTopo;
    Timeline animacionBomba;
    Timeline animacionTopoDorado;
    ///////////////
    
    
    public void reinicioPartida(){
        topoPosX = 35;
        topoPosY = 260;
        bombaPosX = 35;
        bombaPosY = 260;
        topoDoradoPosX = 35;
        topoDoradoPosY = 260;
        fondoScorePosX = 10;
        fondoScorePosY = 10;
        explosionPosX = -100;
        explosionPosY = -100;
        direccionTopo = 0;
        direccionBomba = 0;
        direccionTopoDorado = 0;
        velocidadTopo = 1;
        limite1AnimacionTopo = velocidadTopo * 30;
        limite2AnimacionTopo = velocidadTopo * 70;
        velocidadBomba = 1;
        limite1AnimacionBomba = velocidadBomba * 30;
        limite2AnimacionBomba = velocidadBomba * 70;
        velocidadTopoDorado = 1;
        limite1AnimacionTopoDorado = velocidadTopoDorado * 30;
        limite2AnimacionTopoDorado = velocidadTopoDorado * 70;
        contadorAnimacionTopo=0;
        contadorAnimacionBomba=0;
        contadorAnimacionTopoDorado=0;
        permitirPulsacionTopo = true;
        permitirPulsacionBomba = true;
        permitirPulsacionTopoDorado = true;
        colocadoTopo = true;
        colocadoBomba = true;
        colocadoTopoDorado = true;
        posColumnaTopo = 0;
        posFilaTopo = 0;
        posColumnaBomba = 0;
        posFilaBomba = 0;
        posColumnaTopoDorado = 0;
        posFilaTopoDorado = 0;
        velocidadAparicionBomba = 10;
        cambiarCursor = false;
    }
    public void dibujarPradera(Pane root, Scene scene, LogicaInterna logicaInterna, LogicaGrafica logicaGrafica){
        this.logicaInterna = logicaInterna;
        this.logicaGrafica = logicaGrafica;
        Image cieloImg = new Image(getClass().getResourceAsStream("/images/cielo.png")); // CARGA LA IMAGEN DE FONDO
        Image praderaImg = new Image(getClass().getResourceAsStream("/images/pradera.png")); // CARGA LA IMAGEN DE FONDO
        Image topoImg = new Image(getClass().getResourceAsStream("/images/topo.png")); // CARGA LA IMAGEN DEL TOPO
        Image bombaImg = new Image(getClass().getResourceAsStream("/images/bomba.png")); // CARGA LA IMAGEN DEL TOPO
        Image topoDoradoImg = new Image(getClass().getResourceAsStream("/images/topoDorado2.gif")); // CARGA LA IMAGEN DEL TOPO
        Image sueloTopoImg = new Image(getClass().getResourceAsStream("/images/agujero.png")); // CARGA LA IMAGEN DEL AGUJERO
        Image fondoScoreImg = new Image(getClass().getResourceAsStream("/images/imageScore140x70.png")); // CARGA LA IMAGEN DEL FONDO DE LA PUNTUACION
        Image explosionImg = new Image(getClass().getResourceAsStream("/images/explosion.gif")); // CARGA LA IMAGEN DEL FONDO DE LA PUNTUACION
        Image mazo0 = new Image("/images/mazo0.png");
        Image mazo1 = new Image("/images/mazo1.png");
        cielo1 = new ImageView(cieloImg); // CREA EL OBJETO cielo1
        cielo2 = new ImageView(cieloImg); // CREA EL OBJETO cielo2
        pradera = new ImageView(praderaImg); // CREA EL OBJETO pradera
        topo = new ImageView(topoImg); // CREA EL OBJETO topo
        bomba = new ImageView(bombaImg); // CREA EL OBJETO bomba
        topoDorado = new ImageView(topoDoradoImg); // CREA EL OBJETO topoDorado
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
        explosion = new ImageView(explosionImg); // CREA EL OBJETO sueloTopo
        root.getChildren().add(cielo1);
        root.getChildren().add(cielo2);
        root.getChildren().add(pradera);
        root.getChildren().add(topo);
        root.getChildren().add(bomba);
        root.getChildren().add(topoDorado);
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
        root.getChildren().add(explosion);
        cielo1.setLayoutX(cielo1PosX);
        cielo2.setLayoutX(cielo2PosX);
        topo.setLayoutX(topoPosX);
        topo.setLayoutY(topoPosY);
        bomba.setLayoutX(bombaPosX);
        bomba.setLayoutY(bombaPosY);
        topoDorado.setLayoutX(topoDoradoPosX);
        topoDorado.setLayoutY(topoDoradoPosY);
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
        explosion.setLayoutX(explosionPosX);
        explosion.setLayoutY(explosionPosY);
        TextsAndAlerts textsAndAlerts = new TextsAndAlerts(root, logicaInterna, logicaGrafica);
        
        Timeline restablecerCursorDefault= new Timeline(
                  new KeyFrame(Duration.seconds(0.5), (ActionEvent ae) -> {
                      scene.setCursor(new ImageCursor(mazo0));
                  })
        );
        restablecerCursorDefault.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        restablecerCursorDefault.play(); // EJECUTAR EL TIMELINE
        
        root.setOnMousePressed((MouseEvent mouseEvent) -> {
            scene.setCursor(new ImageCursor(mazo1));
        });
        topo.setOnMousePressed((MouseEvent mouseEvent) -> {
            if(permitirPulsacionTopo==true){
                logicaInterna.puntos++;
                textsAndAlerts.actualizarLabelPuntos();
                System.out.println("Has conseguido un punto, total: "+logicaInterna.puntos);
                permitirPulsacionTopo = false;
            }
        });
        bomba.setOnMousePressed((MouseEvent mouseEvent) -> {
            if(permitirPulsacionBomba==true){
                System.out.println("Has explotado una bomba");
                textsAndAlerts.mostrarAlertInfo();
                permitirPulsacionBomba = false;
            }
        });
        topoDorado.setOnMousePressed((MouseEvent mouseEvent) -> {
            if(permitirPulsacionTopoDorado==true){
                logicaInterna.puntos = logicaInterna.puntos+5;
                textsAndAlerts.actualizarLabelPuntos();
                System.out.println("Has conseguido un punto, total: "+logicaInterna.puntos);
                permitirPulsacionTopoDorado = false;
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
                        colocadoTopo = logicaInterna.colocarFicha(posColumnaTopo, posFilaTopo, 2);
                        posColumnaTopo = (int) (Math.random() * (3 -0)) + 0;
                        posFilaTopo = (int) (Math.random() * (4 -0)) + 0;
                        colocadoTopo = logicaInterna.colocarFicha(posColumnaTopo, posFilaTopo, 1);
                        if(colocadoTopo == true) {
                            logicaInterna.mostrarTableroConsola();
                            changeMoleImgPosition();
                            permitirPulsacionTopo = true;
                        }
                  })
        );
        generarTopo.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        generarTopo.play(); // EJECUTAR EL TIMELINE
    }
    
    public void generarBomba(){
        Timeline generarBombaTimeline = new Timeline(
                  new KeyFrame(Duration.seconds(velocidadAparicionBomba), (ActionEvent ae) -> {
                        if(velocidadAparicionBomba>0.5){
                            velocidadAparicionBomba -= 0.5;
                        }
                        colocadoBomba = logicaInterna.colocarFicha(posColumnaBomba, posFilaBomba, 2);
                        posColumnaBomba = (int) (Math.random() * (3 -0)) + 0;
                        posFilaBomba = (int) (Math.random() * (4 -0)) + 0;
                        colocadoBomba = logicaInterna.colocarFicha(posColumnaBomba, posFilaBomba, 3);
                        if(colocadoBomba == true) {
                            logicaInterna.mostrarTableroConsola();
                            changeBombaImgPosition();
                            System.out.println("LA VELOCIDAD DE LA BOMBA ES "+velocidadAparicionBomba);
                            permitirPulsacionBomba = true;
                        }
                        generarBomba();
                  })
        );
        generarBombaTimeline.setCycleCount(1); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        generarBombaTimeline.play(); // EJECUTAR EL TIMELINE
    }
    
    public void generarTopoDorado(){
        Timeline generarTopoDorado = new Timeline(
                  new KeyFrame(Duration.seconds(15), (ActionEvent ae) -> {
                        
                        colocadoTopoDorado = logicaInterna.colocarFicha(posColumnaTopoDorado, posFilaTopoDorado, 2);
                        posColumnaTopoDorado = (int) (Math.random() * (3 -0)) + 0;
                        posFilaTopoDorado = (int) (Math.random() * (4 -0)) + 0;
                        colocadoTopoDorado = logicaInterna.colocarFicha(posColumnaTopoDorado, posFilaTopoDorado, 4);
                        if(colocadoTopoDorado == true) {
                            logicaInterna.mostrarTableroConsola();
                            changeTopoDoradoImgPosition();
                            permitirPulsacionTopoDorado = true;
                        }
                  })
        );
        generarTopoDorado.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        generarTopoDorado.play(); // EJECUTAR EL TIMELINE
    }
    
    public void animacionTopo(){
        direccionTopo = 1;
        contadorAnimacionTopo = 0;
        animacionTopo = new Timeline(
                  new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                        ejecutarAnimacionTopo();
                  })
        );
        animacionTopo.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionTopo.play(); // EJECUTAR EL TIMELINE
    }
    public void animacionBomba(){
        direccionBomba = 1;
        contadorAnimacionBomba = 0;
        animacionBomba = new Timeline(
                  new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                        ejecutarAnimacionBomba();
                  })
        );
        animacionBomba.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionBomba.play(); // EJECUTAR EL TIMELINE
    }
    public void animacionTopoDorado(){
        direccionTopoDorado = 1;
        contadorAnimacionTopoDorado = 0;
        animacionTopoDorado = new Timeline(
                  new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                        ejecutarAnimacionTopoDorado();
                  })
        );
        animacionTopoDorado.setCycleCount(Timeline.INDEFINITE); // DEFINIR QUE SE EJECUTE INDEFINIDAMENTE
        animacionTopoDorado.play(); // EJECUTAR EL TIMELINE
    }
    public void ejecutarAnimacionTopo(){
        contadorAnimacionTopo++;
        if (contadorAnimacionTopo==limite2AnimacionTopo)
        {
            direccionTopo = 0;
            animacionTopo.stop();
        }
        if (contadorAnimacionTopo==limite1AnimacionTopo)
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
    
    public void ejecutarAnimacionBomba(){
        contadorAnimacionBomba++;
        if (contadorAnimacionBomba==limite2AnimacionBomba)
        {
            direccionBomba = 0;
            animacionBomba.stop();
        }
        if (contadorAnimacionBomba==limite1AnimacionBomba)
        {
            direccionBomba = -1;
        }
        if (direccionBomba == 1)
        {
            bombaPosY = bombaPosY - velocidadBomba;
            bomba.setLayoutY(bombaPosY);
        }
        if (direccionBomba == -1)
        {
            bombaPosY = bombaPosY + velocidadBomba;
            bomba.setLayoutY(bombaPosY);
        }
    }
    
    public void ejecutarAnimacionTopoDorado(){
        contadorAnimacionTopoDorado++;
        if (contadorAnimacionTopoDorado==limite2AnimacionTopoDorado)
        {
            direccionTopoDorado = 0;
            animacionTopoDorado.stop();
        }
        if (contadorAnimacionTopoDorado==limite1AnimacionTopoDorado)
        {
            direccionTopoDorado = -1;
        }
        if (direccionTopoDorado == 1)
        {
            topoDoradoPosY = topoDoradoPosY - velocidadTopoDorado;
            topoDorado.setLayoutY(topoDoradoPosY);
        }
        if (direccionTopoDorado == -1)
        {
            topoDoradoPosY = topoDoradoPosY + velocidadTopoDorado;
            topoDorado.setLayoutY(topoDoradoPosY);
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
    
    public void changeBombaImgPosition(){
        int posicionXBomba = logicaInterna.obtenerPosicionBomba()[0];
        int posicionYBomba = logicaInterna.obtenerPosicionBomba()[1];
        if(posicionXBomba==0){
            bombaPosX = 30;
            bomba.setLayoutX(bombaPosX);
            System.out.println("te cambio la X  de la bomba a: "+bombaPosX);
        }
        if(posicionXBomba==1){
            bombaPosX = 155;
            bomba.setLayoutX(bombaPosX);
            System.out.println("te cambio X de la bomba a: "+bombaPosX);
        }
        if(posicionXBomba==2){
            bombaPosX = 285;
            bomba.setLayoutX(bombaPosX);
            System.out.println("te cambio la X de la bomba a: "+bombaPosX);
        }
        if(posicionYBomba==0){
            bombaPosY = 250;
            bomba.setLayoutY(bombaPosY);
            System.out.println("te cambio la Y de la bomba a: "+bombaPosY);
        }
        if(posicionYBomba==1){
            bombaPosY = 340;
            bomba.setLayoutY(bombaPosY);
            System.out.println("te cambio la Y de la bomba a: "+bombaPosY);
        }
        if(posicionYBomba==2){
            bombaPosY = 430;
            bomba.setLayoutY(bombaPosY);
            System.out.println("te cambio la Y  de la bomba a: "+bombaPosY);
        }
        if(posicionYBomba==3){
            bombaPosY = 525;
            bomba.setLayoutY(bombaPosY);
            System.out.println("te cambio la Y de la bomba a: "+bombaPosY);
        }
        animacionBomba();
    }
    
    public void changeTopoDoradoImgPosition(){
        int posicionXTopoDorado = logicaInterna.obtenerPosicionTopoDorado()[0];
        int posicionYTopoDorado = logicaInterna.obtenerPosicionTopoDorado()[1];
        if(posicionXTopoDorado==0){
            topoDoradoPosX = 40;
            topoDorado.setLayoutX(topoDoradoPosX);
            System.out.println("te cambio la X del topo dorado a: "+topoDoradoPosX);
        }
        if(posicionXTopoDorado==1){
            topoDoradoPosX = 165;
            topoDorado.setLayoutX(topoDoradoPosX);
            System.out.println("te cambio la X del topo dorado a: "+topoDoradoPosX);
        }
        if(posicionXTopoDorado==2){
            topoDoradoPosX = 295;
            topoDorado.setLayoutX(topoDoradoPosX);
            System.out.println("te cambio la X del topo dorado a: "+topoDoradoPosX);
        }
        if(posicionYTopoDorado==0){
            topoDoradoPosY = 250;
            topoDorado.setLayoutY(topoDoradoPosY);
            System.out.println("te cambio la Y del topo dorado a: "+topoDoradoPosY);
        }
        if(posicionYTopoDorado==1){
            topoDoradoPosY = 340;
            topoDorado.setLayoutY(topoDoradoPosY);
            System.out.println("te cambio la Y del topo dorado a: "+topoDoradoPosY);
        }
        if(posicionYTopoDorado==2){
            topoDoradoPosY = 430;
            topoDorado.setLayoutY(topoDoradoPosY);
            System.out.println("te cambio la Y del topo dorado a: "+topoDoradoPosY);
        }
        if(posicionYTopoDorado==3){
            topoDoradoPosY = 525;
            topoDorado.setLayoutY(topoDoradoPosY);
            System.out.println("te cambio la Y del topo dorado a: "+topoDoradoPosY);
        }
        animacionTopoDorado();
    }
    
    
}
