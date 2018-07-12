package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Model.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class GameLogicTest.
 */
public class GameLogicTest {
    

    /** The color P 1. */
    Color colorP1= new Color(3,3,173);
    
    /** The player test. */
    Player playerTest= new Player("bleu",3, colorP1, 15, 15, 0);
    
    /** The resultat attendu. */
    String resultatAttendu = "bleu";
    
    /** The result. */
    String result = getP1Name();
    
    /**
     * Test assert.
     */
    @Test    
    public void testAssert(){    

        assertEquals(resultatAttendu, result);
    }
    
    /**
     * Gets the p 1 name.
     *
     * @return the p 1 name
     */
    private String getP1Name() {
        return playerTest.getName();		//Test la fonction getP1Name
    }
}