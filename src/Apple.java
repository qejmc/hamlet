import java.awt.*;

public class Apple extends StaticEntity {

    public Apple(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 10;
        bounds.y = (int) (height/1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void tick() {

    }

    public void die(){

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.apple, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width/2, height/2, null);
    }
}
