package Opgave6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.util.EventObject;


public class Gui extends Application {
    ;

    private final ListView<Car> carsList = new ListView<>();
    private ComboBox<String> combCar;
    private TextField txfModel;
    private TextField txfPrice;
    private CheckBox cbElektrisk;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Opgave 6");
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


        Label lblname = new Label("Bil liste:");
        lblname.setPadding(new Insets(5));
        pane.add(lblname, 0, 0);

        pane.add(carsList, 0, 1, 3, 1);

        Button addCar = new Button("Tilføj bil");
        pane.add(addCar, 0, 2);
        addCar.setOnAction(event -> newWindow());

    }

    public void newWindow() {
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Tilføj bil");
        GridPane pane = new GridPane();
        this.initCarContent(pane);
        Scene scene = new Scene(pane);
        secondaryStage.setScene(scene);
        secondaryStage.show();

    }

    private void initCarContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblMærke = new Label("Mærke:");
        pane.add(lblMærke, 0, 0);

        combCar = new ComboBox<>();
        combCar.getItems().addAll("Toyota", "Ford", "Opel", "Tesla", "BMW", "Audi");
        pane.add(combCar, 1, 0);


        Label lblModel = new Label("Model:");
        pane.add(lblModel, 0, 1);
        txfModel = new TextField();
        pane.add(txfModel, 1, 1);

        Label lblPrice = new Label("Price:");
        pane.add(lblPrice, 0, 2);
        txfPrice = new TextField();
        pane.add(txfPrice, 1, 2);

        cbElektrisk = new CheckBox("Elektrisk");
        pane.add(cbElektrisk, 1, 3);


        Button btnSaveCar = new Button("Gem bil");
        pane.add(btnSaveCar, 1, 4);

        btnSaveCar.setOnAction(event -> saveCar(event));
    }


    private void saveCar(ActionEvent event) {

        String mærke = combCar.getValue();
        String model = txfModel.getText();
        boolean isElektrisk = cbElektrisk.isSelected();
        int price = Integer.parseInt(txfPrice.getText());


        Car car = new Car(model, mærke, isElektrisk, price);
        carsList.getItems().add(car);

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();


    }
}