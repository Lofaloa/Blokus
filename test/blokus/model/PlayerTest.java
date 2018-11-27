package blokus.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a player.
 *
 * @author Logan Farci (47923)
 */
public class PlayerTest {

    @Test
    public void playerAfterInitializationShouldBeInExpectedState() {
        Player p = new Player(BlokusColor.BLUE);
        assertTrue(p.getColor() == BlokusColor.BLUE && !p.getStock().isEmpty()
                && p.getScore() == -89);
    }

    @Test
    public void playerShouldBeAbleToGetAPieceOfStock() {
        Player player = new Player(BlokusColor.BLUE);
        Piece p1 = player.getPiece(0);
        System.out.println(p1.getShape());
        assertTrue(p1.equals(new Piece(Shape.SHAPE_01, BlokusColor.BLUE)));
    }

}
