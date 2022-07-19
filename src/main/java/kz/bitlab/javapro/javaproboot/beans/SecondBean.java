package kz.bitlab.javapro.javaproboot.beans;


public class SecondBean {
    private int price;
    private String address;

    public SecondBean(){
        System.out.println("Using default construction of Second Bean");
        this.price=3333;
        this.address="Satpaeva 9B";
    }

    public SecondBean(int price, String address) {
        System.out.println("Using parametrizing constructor of Second Page");
        this.price = price;
        this.address = address;
    }
    public String getData(){
        return this.address+" "+this.price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
