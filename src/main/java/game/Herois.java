package game;

abstract class Herois {
    private String name;
    private int level=1;
    transient private Point place;

    public Herois(String name) throws Exception {
        this.name=name;
        place = new Point(0,0);
    }

    public void greet(Herois s){

    }

}
