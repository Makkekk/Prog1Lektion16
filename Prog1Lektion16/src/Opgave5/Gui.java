package Opgave5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Gui extends Application { ;
    private final TextField txfAddName = new TextField();
    private final TextArea nameList = new TextArea();



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Opgave 5");
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


        Label lblname = new Label("Name:");
        lblname.setPadding(new Insets(5));
        pane.add(lblname, 0, 0);

        pane.add(txfAddName,0, 1,3,1);

        Button addName = new Button("Tilføj navn");
        pane.add(addName, 0, 2);
        addName.setOnAction(event -> AddToList());

        nameList.setPadding(new Insets(5));
        pane.add(nameList,0,3);


    }

    private void AddToList() {

        String trimmedName = txfAddName.getText().trim();
        if(!trimmedName.isEmpty()) {
            nameList.appendText(trimmedName + "\n");
            txfAddName.clear();
        }

    }
}