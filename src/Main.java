import com.isep.rpg.Dragon;
import com.isep.rpg.Game;
import com.isep.rpg.Warrior;

public class Main {
    public static void main(String[] args) {
        new Game();
    }

    private static void showStatus(Warrior w, Dragon d) {
        System.out.println(w.getName()+ ":" + w.getPointsvie() + "\n"
                + d.getName()+ ":"+ d.getPointsvie());
    }
}
