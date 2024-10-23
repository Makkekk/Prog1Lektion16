package Opgave6;

public class Car {
    private String mærke;
    private String model;
    private boolean elektrisk;
    private int price;


    public Car(String model, String mærke, boolean elektrisk, int price) {
        this.model = model;
        this.mærke = mærke;
        this.elektrisk = elektrisk;
        this.price = price;
    }

    public String getModel() {

        return model;
    }

    public String getMærke() {

        return mærke;
    }

    public int getPrice() {

        return price;
    }

    public boolean isElektrisk() {

        return elektrisk;
    }

    @Override
    public String toString() {
        return getMærke() + " " + getModel() + " - " + getPrice() + " DKK (" + (isElektrisk() ? "Elektrisk" : "Ikke Elektrisk") + ")";

    }
}
