package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class Controller {

    Random random = new Random();
    player p1;
    player p2;
    thread th1;
    thread th2;
    token p1t1;
    token p1t2;
    token p1t3;
    token p1t4;
    token p2t1;
    token p2t2;
    token p2t3;
    token p2t4;

    @FXML
    private ImageView dice;

    @FXML
    private Button dice2;

    @FXML
    private Button dicebutton;

    @FXML
    private ImageView diceimage2;

    @FXML
    private GridPane grid;



    @FXML
    private Button p1o1;

    @FXML
    private Button p1o3;

    @FXML
    private Button p1o2;

    @FXML
    private Button p1o4;

    @FXML
    private Button p2o1;

    @FXML
    private Button p2o2;

    @FXML
    private Button p2o3;

    @FXML
    private Button p2o4;

    @FXML
    private Rectangle p1white;

    public void initialize(){
        p1t1 = new token(p1o1);
        p1t2 = new token(p1o2);
        p1t3 = new token(p1o3);
        p1t4 = new token(p1o4);
        p2t1 = new token(p2o1);
        p2t2 = new token(p2o2);
        p2t3 = new token(p2o3);
        p2t4 = new token(p2o4);

        p1 = new player(p1t1, p1t2, p1t3, p1t4);
        p2 = new player(p2t1, p2t2, p2t3, p2t4);
        dicebutton.setDisable(true);


//        th1 = new thread(p1);
//        th2 = new thread(p2);
//        th1.start();
    }



    @FXML
    void clickob1(ActionEvent event) {
        grid.add(p1o1,6,13);
        p1o1.setDisable(true);
    }

    @FXML
    void clickob2(ActionEvent event) {
        grid.add(p1o2,6,13);
        p1o2.setDisable(true);
    }

    @FXML
    void clickob3(ActionEvent event) {
        grid.add(p1o3,6,13);
        p1o3.setDisable(true);
    }

    @FXML
    void clickob4(ActionEvent event) {
        grid.add(p1o4,6,13);
        p1o4.setDisable(true);
    }

    @FXML
    void click1ob1(ActionEvent event) {
        grid.add(p2o1,8,1);
        p2o1.setDisable(true);
    }

    @FXML
    void click1ob2(ActionEvent event) {
        grid.add(p2o2,8,1);
        p2o2.setDisable(true);
    }

    @FXML
    void click1ob3(ActionEvent event) {
        grid.add(p2o3,8,1);
        p2o3.setDisable(true);
    }

    @FXML
    void click1ob4(ActionEvent event) {
        grid.add(p2o4,8,1);
        p2o4.setDisable(true);
    }
    boolean check_six1 = false;
    @FXML
    void roll(ActionEvent event) {
        dice2.setDisable(true);
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                File file = null;
                File file6 = new File("src/sample/attachments/dice6.jpg");
                try {
                    for (int i = 0; i < 5; i++) {
                        file = new File("src/sample/attachments/dice" + (random.nextInt(6)+1)+".jpg");
                        dice.setImage(new Image(file.toURI().toString()));

                        Thread.sleep(50);
                    }

                    if(file.equals(file6)){
                        System.out.println("its six1");
                        check_six1 = true;
                        p2.enable(p2.pt1);
                        p2.enable(p2.pt2);
                        p2.enable(p2.pt3);
                        p2.enable(p2.pt4);
                    }
                    else{
                        if(check_six1){
                            check_six1 = false;
                        }
                        else{
                            System.out.println("ok");
                            dicebutton.setDisable(true);
                        }
                        if(!p2.pt1.inside){
                            p2.enable(p2.pt1);
                        }
                        if(!p2.pt2.inside){
                            p2.enable(p2.pt2);
                        }
                        if(!p2.pt3.inside){
                            p2.enable(p2.pt3);
                        }
                        if(!p2.pt4.inside){
                            p2.enable(p2.pt4);
                        }
                        dice2.setDisable(false);
                        System.out.println("not equal");

                    }
                    System.out.println("doen");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        System.out.println("start");
        thread.start();
    }
    boolean check_six = false;
    @FXML
    void roll2(ActionEvent event) {
        dicebutton.setDisable(true);
        Thread thread = new Thread(){
            public void run(){
                File file2 = null;
                File file6 = new File("src/sample/attachments/dice6.jpg");
                System.out.println("Thread Running");

                try {
                    for (int i = 0; i < 5; i++) {
                        file2 = new File("src/sample/attachments/dice" + (random.nextInt(6)+1)+".jpg");
                        diceimage2.setImage(new Image(file2.toURI().toString()));
                        Thread.sleep(50);
                    }

                    System.out.println(file2);
                    System.out.println(file6);
                    p1.disable();
                    if(file2.equals(file6)){
                        System.out.println("its six2");
                        check_six = true;
                        p1.enable(p1.pt1);
                        p1.enable(p1.pt2);
                        p1.enable(p1.pt3);
                        p1.enable(p1.pt4);
                    }
                    else{
                        if(check_six){
                            check_six = false;
                        }
                        else{
                            dice2.setDisable(true);
                        }
                        if(!p1.pt1.inside){
                            p1.enable(p1.pt1);
                        }
                        if(!p1.pt2.inside){
                            p1.enable(p1.pt2);
                        }
                        if(!p1.pt3.inside){
                            p1.enable(p1.pt3);
                        }
                        if(!p1.pt4.inside){
                            p1.enable(p1.pt4);
                        }
                        dicebutton.setDisable(false);
                        System.out.println("not equal");


                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}

class token{
    public Button bt;
    public boolean inside = true;
    token(Button bt){
        this.bt = bt;
        this.bt.setDisable(true);
    }
    public void make_change(){
        inside = false;
    }

}
class player{
    public token pt1;
    public token pt2;
    public token pt3;
    public token pt4;
    player(token t1, token t2, token t3 , token t4){
        pt1 = t1;
        pt2 = t2;
        pt3 = t3;
        pt4 = t4;

    }

    public boolean inside_box(token t){
        if(t.inside){
            return true;
        }
        return false;
    }

    public void enable(token pt){
        pt.bt.setDisable(false);

    }

    public void disable(){
        pt1.bt.setDisable(true);
        pt2.bt.setDisable(true);
        pt3.bt.setDisable(true);
        pt4.bt.setDisable(true);
    }




}
class thread {
    player pl;
    thread(player pl){
        this.pl = pl;
    }
    public void enable(player pl){
        pl.pt1.bt.setDisable(false);
        pl.pt2.bt.setDisable(false);
        pl.pt3.bt.setDisable(false);
        pl.pt4.bt.setDisable(false);
    }

}
