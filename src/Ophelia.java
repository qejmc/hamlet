import java.awt.*;

public class Ophelia extends StaticEntity {

    public Ophelia(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);

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
        g.drawImage(Assets.ophelia, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
