package game;

public class Wizard extends Herois {

    public Wizard(String name) throws Exception {
        super(name);
    }

    @Override
    public void greet(Herois s){
        System.out.println("Hi");
    }
}
