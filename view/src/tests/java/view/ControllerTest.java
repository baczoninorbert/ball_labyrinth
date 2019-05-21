package view;

import model.Labyrinth;
import model.Reader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {
    @Test
    void test() {

        Labyrinth labyrinth;
        Reader reader = new Reader();
        labyrinth = reader.startLabyrinth();
        Controller controller = new Controller();
        assertEquals(1, controller.checkUp(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        assertEquals(3, controller.checkDown(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        assertEquals(2, controller.checkRight(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        assertEquals(4, controller.checkLeft(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        labyrinth.setPlayery(-40);
        labyrinth.setPlayerx(-13);
        assertEquals(0, controller.checkUp(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        assertEquals(0, controller.checkDown(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        assertEquals(0, controller.checkRight(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        assertEquals(0, controller.checkLeft(labyrinth, labyrinth.getPlayerx(), labyrinth.getPlayery()));
        System.out.println(labyrinth.getPlayerx() + " , " + labyrinth.getPlayery());
        labyrinth.setPlayerx(1);
        labyrinth.setPlayery(4);
    }
}
