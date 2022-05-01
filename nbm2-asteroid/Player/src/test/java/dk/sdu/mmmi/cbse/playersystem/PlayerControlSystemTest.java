/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gorm
 */
public class PlayerControlSystemTest {
    private static GameData gameData;
    private static World world;
    private Entity player;
    private PositionPart position;
    private MovingPart movement;
            
    public PlayerControlSystemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Before All");
        gameData = new GameData();
        world = new World();

        
        gameData.setDisplayHeight(500);
        gameData.setDisplayWidth(500);
        gameData.setDelta(0);

        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        player = new Player();
        position = new PositionPart(0,0,0);
        movement = new MovingPart(0,12,300,2);
        
        player.add(position);
        player.add(movement);
        world.addEntity(player);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of process method, of class PlayerControlSystem.
     */
    @Test
    public void testPlayerMovement() {
        System.out.println("Testing PlayerControlSystem process");
        MovingPart movingPart = player.getPart(MovingPart.class);
        
        System.out.println("movingpart: " + movingPart.getDx() + " " + movingPart.getDy());
        
        assertEquals(0, movingPart.getDx(), 0); // Test that player is in coordinate (0,0)
        assertEquals(0, movingPart.getDy(), 0); 
        
        gameData.setDelta(1);                   // 1 unit of time has went by
        movingPart.setUp(true);                 // Player wants to move forward
        movingPart.process(gameData, player);   // Process the input of the player
        
        System.out.println("movingpart: " + movingPart.getDx() + " " + movingPart.getDy());
        
        assertTrue(movingPart.getDx() > 0 || movingPart.getDy() > 0); // Test succeeds if player has left coordinate (0,0)
    }
    
}
