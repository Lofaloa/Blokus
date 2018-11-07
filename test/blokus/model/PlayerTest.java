package blokus.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        Player p = new Player(Color.BLUE);
        assertTrue(p.getColor() == Color.BLUE && !p.getStock().isEmpty()
                && p.getScore() == -89);
    }
    
    @Test
    public void playerShouldBeAbleToGetAPieceOfStock() {
        Player player = new Player(Color.BLUE);
        Piece p1 = player.getPiece(Shape.SHAPE_01);
        assertTrue(p1.equals(new Piece(Shape.SHAPE_01, Color.BLUE)));
    }

}
