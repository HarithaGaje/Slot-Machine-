import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by acer on 12/16/2016.
 */
public class Reel extends Thread{
    //making a array to make the reel
    List<Symbol> symbol = new ArrayList<Symbol>();

    public Reel() {

        symbol.add(new Symbol("images/cherry.png", 2));
        symbol.add(new Symbol("images/lemon.png", 3));
        symbol.add(new Symbol("images/plum.png", 4));
        symbol.add(new Symbol("images/watermelon.png", 5));
        symbol.add(new Symbol("images/bell.png", 6));
        symbol.add(new Symbol("images/redseven.png", 7));
    }

    public List<Symbol> spin() {
        Collections.shuffle(symbol);
        return symbol;

    }

    public int getTop(){
        return symbol.get(0).getValue();
    }
}
