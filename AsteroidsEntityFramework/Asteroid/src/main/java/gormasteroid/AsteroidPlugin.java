package gormasteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        asteroid = createAsteroidShip(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroidShip(GameData gameData) {

        float deacceleration = 0;
        float acceleration = 20;
        float maxSpeed = 15;
        float rotationSpeed = 3;
        float x = gameData.getDisplayWidth() * (float) Math.random();
        float y = gameData.getDisplayHeight() * (float) Math.random();
        float radians = 3.1415f*2* (float)Math.random();

        Entity asteroidShip = new Asteroid();
        asteroidShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroidShip.add(new PositionPart(x, y, radians));

        return asteroidShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }
}
