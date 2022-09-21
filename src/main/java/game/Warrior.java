package game;

public class Warrior extends Herois{

    public Warrior(String name) throws Exception {
        super(name);
    }

    @Override
    public void greet(Herois s){
        System.out.println("Hello");
    }
}
