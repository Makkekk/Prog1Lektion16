package Opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private final TextField txfName = new TextField();
    private final TextField txfName2 = new TextField();
    private final TextField txfName3 = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Opgave 1");
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

        Label lblname = new Label("First name");
        lblname.setPadding(new Insets(5));
        pane.add(lblname, 0, 0);
        pane.add(txfName, 1, 0);


        Label lblname2 = new Label("Surname");
        pane.add(lblname2, 2, 0);
        lblname.setPadding(new Insets(20));
        pane.add(txfName2, 3, 0);

        Label lblname3 = new Label("Full name");
        pane.add(lblname3, 1, 2);
        lblname.setPadding(new Insets(20));
        pane.add(txfName3, 1, 3, 2, 1);

        Button btnCombine = new Button("Combine Name");
        pane.add(btnCombine, 4, 0);


        //Button actions
        btnCombine.setOnAction(event -> this.combineName());
    }

    private void combineName() {
        String firstName = txfName.getText();
        String surname = txfName2.getText();
        String fullname = firstName + " " + surname;
        txfName3.setText(fullname);
    }
}
