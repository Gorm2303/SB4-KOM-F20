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
    private static Entity player;
    private static PositionPart position;
    private static MovingPart movement;
            
    public PlayerControlSystemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("Before All");
        gameData = new GameData();
        world = new World();
        player = new Player();
        position = new PositionPart(0,0,0);
        movement = new MovingPart(0,12,300,2);
        
        gameData.setDisplayHeight(500);
        gameData.setDisplayWidth(500);
        player.add(position);
        player.add(movement);
        world.addEntity(player);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
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
        gameData.setDelta(0);
        
        System.out.println("movingpart: " + movingPart.getDx() + " " + movingPart.getDy());
        
        assertEquals(0, movingPart.getDx(), 0);
        assertEquals(0, movingPart.getDy(), 0);
        
        gameData.setDelta(1);
        movingPart.setUp(true);
        //PlayerControlSystem instance = new PlayerControlSystem();
        //instance.process(gameData, world);
        movingPart.process(gameData, player);
        movingPart.setUp(false);
        
        System.out.println("movingpart: " + movingPart.getDx() + " " + movingPart.getDy());
        
        assertTrue(movingPart.getDx() > 0 || movingPart.getDy() > 0);

        
        // TODO review the generated test code and remove the default call to fail.
        

    }
    
}
