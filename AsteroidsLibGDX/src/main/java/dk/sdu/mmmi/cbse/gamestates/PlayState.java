package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.entities.Projectile;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;
import java.util.LinkedList;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
	private Enemy enemy;
	private ArrayList<Projectile> projectiles;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		
		player = new Player();
		enemy = new Enemy();
		projectiles = enemy.getProjectiles();
	}
	
	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
		enemy.update(dt);
		Projectile.updateAll(dt);
	}
	
	public void draw() {
		player.draw(sr);
		enemy.draw(sr);
		Projectile.drawAll(sr);
	}

	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
	}
	
	public void dispose() {}
	
}









