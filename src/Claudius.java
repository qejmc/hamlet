import java.awt.*;

public class Claudius extends StaticEntity {

    public Claudius(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = width;
        bounds.height = height;
    }

    @Override
    public void tick() {

    }

    public void die(){
        State.setState(handler.getGame().winState);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.claudius, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
