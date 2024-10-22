package Opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
private int number = 0;
private Label lblNumber = new Label();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Opgave 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblname = new Label("Nummer");
        lblname.setPadding(new Insets(5));
        pane.add(lblname, 1, 1);
        lblNumber.setText(String.valueOf(number));
        pane.add(lblNumber,2,1);


        Button btnPlus = new Button("+1");
        pane.add(btnPlus, 4, 2);
        btnPlus.setOnAction(event -> this.increaseNumber());

        Button btnMinus = new Button("-1");
        pane.add(btnMinus, 4, 0);
        btnMinus.setOnAction(event -> this.decreaseNumber());
    }


//Button actions
        private void increaseNumber() {
        number++;
        lblNumber.setText(String.valueOf(number));
        }

        private void decreaseNumber() {
        number--;
        lblNumber.setText(String.valueOf(number));
        }

    }

