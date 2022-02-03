package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.main.Game;

public class Projectile extends SpaceObject {

    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    public Projectile(float x, float y) {

        this.x = x;
        this.y = y;

        maxSpeed = 300;
        acceleration = 200;
        deceleration = 10;

        shapex = new float[4];
        shapey = new float[4];

        radians = 3.1415f / 2;
        rotationSpeed = 3;

    }

    private void setShape() {
        shapex[0] = x + MathUtils.cos(radians) * 8;
        shapey[0] = y + MathUtils.sin(radians) * 8;

        shapex[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 8;
        shapey[1] = y + MathUtils.sin(radians - 4 * 3.1145f / 5) * 8;

        shapex[2] = x + MathUtils.cos(radians + 3.1415f) * 5;
        shapey[2] = y + MathUtils.sin(radians + 3.1415f) * 5;

        shapex[3] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 8;
        shapey[3] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 8;
    }

    public void update(float dt) {

        // accelerating
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;

        // hit an object

        float vec = (float) Math.sqrt(dx * dx + dy * dy);

        if (vec > maxSpeed) {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        // set position
        x += dx * dt;
        y += dy * dt;

        // set shape
        setShape();

        // screen wrap
        wrap();

    }

    public void draw(ShapeRenderer sr) {

        sr.setColor(0.5f, 0.5f, 1, 1);

        sr.begin(ShapeRenderer.ShapeType.Line);

        for (int i = 0, j = shapex.length - 1;
             i < shapex.length;
             j = i++) {

            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        sr.end();

    }

}
