package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    @FXML
    private GridPane grid1;

    @FXML
    private GridPane grid10;

    @FXML
    private GridPane grid11;

    @FXML
    private GridPane grid12;

    @FXML
    private GridPane grid13;

    @FXML
    private GridPane grid14;

    @FXML
    private GridPane grid15;

    @FXML
    private GridPane grid16;

    @FXML
    private GridPane grid17;

    @FXML
    private GridPane grid18;

    @FXML
    private GridPane grid19;

    @FXML
    private GridPane grid2;

    @FXML
    private GridPane grid20;

    @FXML
    private GridPane grid21;

    @FXML
    private GridPane grid22;

    @FXML
    private GridPane grid23;

    @FXML
    private GridPane grid24;

    @FXML
    private GridPane grid25;

    @FXML
    private GridPane grid26;

    @FXML
    private GridPane grid27;

    @FXML
    private GridPane grid28;

    @FXML
    private GridPane grid29;

    @FXML
    private GridPane grid3;

    @FXML
    private GridPane grid30;

    @FXML
    private GridPane grid31;

    @FXML
    private GridPane grid32;

    @FXML
    private GridPane grid33;

    @FXML
    private GridPane grid34;

    @FXML
    private GridPane grid35;

    @FXML
    private GridPane grid36;

    @FXML
    private GridPane grid37;

    @FXML
    private GridPane grid38;

    @FXML
    private GridPane grid39;

    @FXML
    private GridPane grid4;

    @FXML
    private GridPane grid40;

    @FXML
    private GridPane grid41;

    @FXML
    private GridPane grid42;

    @FXML
    private GridPane grid43;

    @FXML
    private GridPane grid44;

    @FXML
    private GridPane grid45;

    @FXML
    private GridPane grid46;

    @FXML
    private GridPane grid47;

    @FXML
    private GridPane grid48;

    @FXML
    private GridPane grid49;

    @FXML
    private GridPane grid5;

    @FXML
    private GridPane grid50;

    @FXML
    private GridPane grid51;

    @FXML
    private GridPane grid52;

    @FXML
    private GridPane grid6;

    @FXML
    private GridPane grid7;

    @FXML
    private GridPane grid8;

    @FXML
    private GridPane grid9;

    public void initialize(){
        p2o1.setStyle("-fx-background-color:#29ef23;");
        p2o2.setStyle("-fx-background-color:#29ef23;");
        p2o3.setStyle("-fx-background-color:#29ef23;");
        p2o4.setStyle("-fx-background-color:#29ef23;");
        p1o1.setStyle("-fx-background-color:#21d0ff;");
        p1o2.setStyle("-fx-background-color:#21d0ff;");
        p1o3.setStyle("-fx-background-color:#21d0ff;");
        p1o4.setStyle("-fx-background-color:#21d0ff;");
        p1t1 = new token(p1o1);
        p1t2 = new token(p1o2);
        p1t3 = new token(p1o3);
        p1t4 = new token(p1o4);
        p2t1 = new token(p2o1);
        p2t2 = new token(p2o2);
        p2t3 = new token(p2o3);
        p2t4 = new token(p2o4);

        int[][] pos_arr= {{6,13},{6,12},{6,11},{6,10},{6,9},{5,8},{4,8},{3,8},{2,8},{1,8},{0,8}
                ,{0,7},{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0},{8,0},{8,1},
                {8,2},{8,3},{8,4},{8,5},{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{14,8},{13,8}
                ,{12,8},{11,8},{10,8},{9,8},{8,9},{8,10},{8,11},{8,12},{8,13},{8,14},{7,14}};

        int[][] pos_arr1= {{8,1},
                {8,2},{8,3},{8,4},{8,5},{9,6},{10,6},{11,6},{12,6},{13,6},{14,6},{14,7},{14,8},{13,8}
                ,{12,8},{11,8},{10,8},{9,8},{8,9},{8,10},{8,11},{8,12},{8,13},{8,14},{7,14},{6,14},{6,13},
                {6,12},{6,11},{6,10},{6,9},{5,8},{4,8},{3,8},{2,8},{1,8},{0,8}
                ,{0,7},{0,6},{1,6},{2,6},{3,6},{4,6},{5,6},{6,5},{6,4},{6,3},{6,2},{6,1},{6,0},{7,0}};

//        int[][] present = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
//                {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
//                {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
//                {0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};

        int[] present = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0};

        GridPane[] small1 = {grid1,grid2,grid3,grid4,grid5,grid6,grid7,grid8,grid9,grid10,grid11,grid12,grid13,
                        grid14,grid15,grid16,grid17,grid18,grid19,grid20,grid21,grid22,grid23,grid24,grid25, grid26,
                        grid27,grid28,grid29,grid30,grid31,grid32,grid33,grid34,grid35,grid36,grid37,grid38,grid40,
                        grid41,grid42,grid43,grid45,grid46,grid47,grid48,grid49,grid50,grid51};

        GridPane[] small2 = {grid27,grid28,grid29,grid30,grid31,grid32,grid33,grid34,grid35,grid36,grid37,grid38,grid40,
                grid41,grid42,grid43,grid45,grid46,grid47,grid48,grid49,grid50,grid51,grid52,grid1,
                grid2,grid3,grid4,grid5,grid6,grid7,grid8,grid9,grid10,grid11,grid12,grid13,
                grid14,grid15,grid16,grid17,grid18,grid19,grid20,grid21,grid22,grid23,grid24,grid25};

        p1 = new player(p1t1, p1t2, p1t3, p1t4, grid,pos_arr, present,small1);
        p2 = new player(p2t1, p2t2, p2t3, p2t4, grid,pos_arr1,present,small2);
        dicebutton.setDisable(true);


//        th1 = new thread(p1);
//        th2 = new thread(p2);
//        th1.start();
    }



    @FXML
    void clickob1(ActionEvent event) throws InterruptedException {
        p1.move_step(p1.pt1);
        p1.disable();
    }

    @FXML
    void clickob2(ActionEvent event) throws InterruptedException {
        p1.move_step(p1.pt2);
        p1.disable();
    }

    @FXML
    void clickob3(ActionEvent event) throws InterruptedException {
        p1.move_step(p1.pt3);
        p1.disable();
    }

    @FXML
    void clickob4(ActionEvent event) throws InterruptedException {
        p1.move_step(p1.pt4);
        p1.disable();
    }

    @FXML
    void click1ob1(ActionEvent event) throws InterruptedException {
        p2.move_step(p2.pt1);
        p2.disable();
    }

    @FXML
    void click1ob2(ActionEvent event) throws InterruptedException {
        p2.move_step(p2.pt2);
        p2.disable();
    }

    @FXML
    void click1ob3(ActionEvent event) throws InterruptedException {
        p2.move_step(p2.pt3);
        p2.disable();
    }

    @FXML
    void click1ob4(ActionEvent event) throws InterruptedException {
        p2.move_step(p2.pt4);
        p2.disable();
    }
    boolean check_six1 = false;
    @FXML
    void roll(ActionEvent event) {
        dice2.setDisable(true);
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                File file_2 = null;
                File file1 = new File("src/sample/attachments/dice1.jpg");
                File file2 = new File("src/sample/attachments/dice2.jpg");
                File file3 = new File("src/sample/attachments/dice3.jpg");
                File file4 = new File("src/sample/attachments/dice4.jpg");
                File file5 = new File("src/sample/attachments/dice5.jpg");
                File file6 = new File("src/sample/attachments/dice6.jpg");
                try {
                    for (int i = 0; i < 5; i++) {
                        file_2 = new File("src/sample/attachments/dice" + (random.nextInt(6)+1)+".jpg");
                        dice.setImage(new Image(file_2.toURI().toString()));

                        Thread.sleep(50);
                    }
                    p2.disable();
                    if(file_2.equals(file6)){
                        System.out.println("its six1");
                        check_six1 = true;
                        p2.move = 6;
                        p2.enable(p2.pt1);
                        p2.enable(p2.pt2);
                        p2.enable(p2.pt3);
                        p2.enable(p2.pt4);
                    }
                    else{

                        System.out.println("ok");
                        dicebutton.setDisable(true);
                        System.out.println(p2.pt1.inside);
                        System.out.println(p2.pt2.inside);
                        System.out.println(p2.pt3.inside);
                        System.out.println(p2.pt4.inside);
                        if(file_2.equals(file1)){
                            p2.move = 1;
                        }
                        else if(file_2.equals(file2)){
                            p2.move = 2;
                        }
                        else if(file_2.equals(file3)){
                            p2.move = 3;
                        }
                        else if(file_2.equals(file4)){
                            p2.move = 4;
                        }
                        else if(file_2.equals(file5)){
                            p2.move = 5;
                        }
                        else if(file_2.equals(file6)){
                            p2.move = 6;
                        }
                        if(!p2.inside_box(p2.pt1)){
                            System.out.println("enable p1");
                            p2.enable(p2.pt1);
                        }
                        if(!p2.inside_box(p2.pt2)){
                            System.out.println("enable p2");
                            p2.enable(p2.pt2);
                        }
                        if(!p2.inside_box(p2.pt3)){
                            System.out.println("enable p3");
                            p2.enable(p2.pt3);
                        }
                        if(!p2.inside_box(p2.pt4)){
                            System.out.println("enable p4");
                            p2.enable(p2.pt4);
                        }
                        dice2.setDisable(false);
                        System.out.println("not equal");


                    }
                    System.out.println("after");
                    System.out.println(p2.pt1.inside);
                    System.out.println(p2.pt2.inside);
                    System.out.println(p2.pt3.inside);
                    System.out.println(p2.pt4.inside);
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
                File file_2 = null;
                File file6 = new File("src/sample/attachments/dice6.jpg");
                File file1 = new File("src/sample/attachments/dice1.jpg");
                File file2 = new File("src/sample/attachments/dice2.jpg");
                File file3 = new File("src/sample/attachments/dice3.jpg");
                File file4 = new File("src/sample/attachments/dice4.jpg");
                File file5 = new File("src/sample/attachments/dice5.jpg");
                System.out.println("Thread Running");

                try {
                    for (int i = 0; i < 5; i++) {
                        file_2 = new File("src/sample/attachments/dice" + (random.nextInt(6)+1)+".jpg");
                        diceimage2.setImage(new Image(file_2.toURI().toString()));
                        Thread.sleep(50);
                    }

                    System.out.println(file_2);
                    System.out.println(file6);
                    p1.disable();
                    if(file_2.equals(file6)){
                        System.out.println("its six2");
                        check_six = true;
                        p1.move = 6;
                        p1.enable(p1.pt1);
                        p1.enable(p1.pt2);
                        p1.enable(p1.pt3);
                        p1.enable(p1.pt4);
                    }
                    else{
                        System.out.println("gone");
                        dice2.setDisable(true);
                        if(file_2.equals(file1)){
                            p1.move = 1;
                        }
                        else if(file_2.equals(file2)){
                            p1.move = 2;
                        }
                        else if(file_2.equals(file3)){
                            p1.move = 3;
                        }
                        else if(file_2.equals(file4)){
                            p1.move = 4;
                        }
                        else if(file_2.equals(file5)){
                            p1.move = 5;
                        }
                        else if(file_2.equals(file6)){
                            p1.move = 6;
                        }
                        System.out.println(p1.pt1.inside);
                        System.out.println(p1.pt2.inside);
                        System.out.println(p1.pt3.inside);
                        System.out.println(p1.pt4.inside);
                        if(!p1.inside_box(p1.pt1)){
                            System.out.println("enable p1");
                            p1.enable(p1.pt1);
                        }
                        if(!p1.inside_box(p1.pt2)){
                            System.out.println("enable p2");
                            p1.enable(p1.pt2);
                        }
                        if(!p1.inside_box(p1.pt3)){
                            System.out.println("enable p3");
                            p1.enable(p1.pt3);
                        }
                        if(!p1.inside_box(p1.pt4)){
                            System.out.println("enable p4");
                            p1.enable(p1.pt4);
                        }
                        dicebutton.setDisable(false);
                        System.out.println("not equal");


                    }
                    System.out.println("after");
                    System.out.println(p1.pt1.inside);
                    System.out.println(p1.pt2.inside);
                    System.out.println(p1.pt3.inside);
                    System.out.println(p1.pt4.inside);

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
    public int posx = 0;
    public int posy = 0;
    public boolean inside = true;
    token(Button bt){
        this.bt = bt;
        this.bt.setDisable(true);
    }
    public void make_change(){
        inside = false;
    }

}
class Grid_pane{
    public GridPane grid;
    public int[][] move_pos;
    public int[][] element_present;
    public token[][] present_token;
    public int n;
    public int m;


}

class player{
    public token pt1;
    public token pt2;
    public token pt3;
    public token pt4;
    public int move = 0;
    public GridPane grid;
    public int[][] move_pos;
    public int n;
    public int m;
    public int[] present_p1_p2;
    public GridPane[] small_grid;
    public ArrayList<ArrayList<token>> p1_token = new ArrayList<>(51);
    public ArrayList<ArrayList<token>> p2_token = new ArrayList<>(51);

    player(token t1, token t2, token t3 , token t4, GridPane grid, int[][] pos, int[] present, GridPane[] g){
        pt1 = t1;
        pt2 = t2;
        pt3 = t3;
        pt4 = t4;
        move_pos = pos;
        this.grid = grid;
        n = move_pos[0].length;
        m = move_pos.length;
        present_p1_p2 = present;
        small_grid = g;

    }
    int linearCheck(int ar[][], int arr[])
    {
        for (int i = 0; i < m; i++)
        {

            boolean matched = true;

            for (int j = 0; j < n; j++)
            {
                if (ar[i][j] != arr[j])
                {
                    matched = false;
                    break;
                }
            }
            if (matched)
                return i + 1;
        }
        return -1;
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

    public void move_step(token pt) throws InterruptedException {
        if(pt.inside){
            grid.add(pt.bt, move_pos[0][0], move_pos[0][1]);
            pt.posx = move_pos[0][0];
            pt.posy = move_pos[0][1];
            int[] temp_arr = new int[]{pt.posx, pt.posy};
            pt.inside = false;
            System.out.println(pt.inside);
            int ind = linearCheck(move_pos,temp_arr);
            present_p1_p2[ind] += 1;
        }
        else{
            System.out.println("else");
            int[] temp_arr = new int[]{pt.posx, pt.posy};
            System.out.println(Arrays.deepToString(move_pos));
            System.out.println(Arrays.toString(temp_arr));
            int ind = linearCheck(move_pos, temp_arr);
            System.out.println(move);
            for (int i = ind; i <ind + move ; i++) {
                pt.posx = move_pos[i][0];
                pt.posy = move_pos[i][1];
                System.out.println(Arrays.toString(move_pos[i]));
//                grid.add(pt.bt, move_pos[i][0], move_pos[i][1],1,1);
//                GridPane.setColumnIndex(pt.bt, move_pos[i][0]);
//                GridPane.setRowIndex(pt.bt, move_pos[i][1]);
                GridPane.setConstraints(pt.bt, move_pos[i][0],move_pos[i][1],1,1,HPos.LEFT,VPos.TOP);


            }
        }


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
