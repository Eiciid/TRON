package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Model.Player;

public class GameLogicTest {
    

    Color colorP1= new Color(3,3,173);
    Player playerTest= new Player("bleu",3, colorP1, 15, 15, 0);
    String resultatAttendu = "bleu";
    String result = getP1Name();
    
    @Test    
    public void testAssert(){    

        assertEquals(resultatAttendu, result);
    }
    private String getP1Name() {
        return playerTest.getName();		//Test la fonction getP1Name
    }
}