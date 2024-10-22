package Opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private final TextField txfCelcius = new TextField();
    private final TextField txfFahrenheit = new TextField();


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Opgave 4");
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

        Label lblname = new Label("Celcius");
        lblname.setPadding(new Insets(5));
        pane.add(lblname, 0, 0);
        pane.add(txfCelcius, 0, 1);


        Label lblname2 = new Label("Fahrenheit");
        lblname.setPadding(new Insets(5));
        pane.add(lblname2, 2, 0);
        pane.add(txfFahrenheit,2, 1);

        Button btnFahrenheit = new Button(">>");
        pane.add(btnFahrenheit, 1, 1);
        btnFahrenheit.setOnAction(event -> this.convertToFahrenheit());

        Button btnCelcius = new Button("<<");
        pane.add(btnCelcius, 1, 2);
        btnCelcius.setOnAction(event -> this.convertToCelcius());

    }

    private void convertToFahrenheit() {
        String celsiusText = txfCelcius.getText();
        if (!celsiusText.isEmpty()) {
            double celsius = Double.parseDouble(celsiusText);
            double fahrenheit = (celsius * 9 / 5) + 32;
            txfFahrenheit.setText(String.format("%.2f", fahrenheit));
        } else {
            txfFahrenheit.clear();
        }
    }

    private void convertToCelcius() {
        String fahrenheitText = txfFahrenheit.getText();
        if (!fahrenheitText.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitText);
            double celcius = (fahrenheit - 32) * 5 / 9;
            txfCelcius.setText(String.format("%.2f", celcius));
        } else {
            txfCelcius.clear();
        }
    }
}