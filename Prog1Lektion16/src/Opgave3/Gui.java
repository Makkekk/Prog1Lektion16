package Opgave3;

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
    private final Label lbloutput = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Opgave 3");
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

        Label lblname = new Label("Indskud");
        lblname.setPadding(new Insets(5));
        pane.add(lblname, 0, 1);
        pane.add(txfName, 2, 1);


        Label lblname2 = new Label("Rente (%)");
        pane.add(lblname2, 0, 2);
        lblname.setPadding(new Insets(5));
        pane.add(txfName2, 2, 2);

        Label lblname3 = new Label("Antal renteindskrivninger");
        pane.add(lblname3, 0, 3);
        lblname.setPadding(new Insets(5));
        pane.add(txfName3, 2, 3);


        Button btnCalc = new Button("Beregn");
        pane.add(btnCalc, 1, 4);

    btnCalc.setOnAction(event -> this.calcFutureValue());

    lbloutput.setPadding(new Insets(10));
    pane.add(lbloutput,0,5,2,1);
    }

    private void calcFutureValue() {
        double indskud = Double.parseDouble(txfName.getText());
        double rate = Double.parseDouble(txfName2.getText());
        int periode = Integer.parseInt(txfName3.getText());

        double futureValue = indskud * Math.pow(1 + (rate / 100), periode);

        lbloutput.setText(String.format("Fremtidig værdi: %.2f", futureValue));
    }
}

