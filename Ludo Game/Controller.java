package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller2 {

    @FXML
    private Button bt;

    @FXML
    private ImageView img;

    @FXML
    private Label locval;

    private double inpx;
    private double inpy;
    private double tarinpx;
    private double targinpy;

    @FXML
    void mouseclick(MouseEvent event) {
        locval.setText("x: " + String.valueOf(event.getSceneX()) + "\n y: "+ String.valueOf(event.getScreenX()));
        tarinpx = event.getSceneX();
        targinpy = event.getSceneY();
    }
    @FXML
    void move(ActionEvent actionEvent) {
        bt.setTranslateX(tarinpx-inpx);
        bt.setTranslateY(targinpy-inpy);
    }
    @FXML
    public void initialize(){
        Bounds bts = bt.localToScene(bt.getBoundsInLocal());
        inpx = bts.getMinX();
        inpy = bts.getMinY();
    }
}
