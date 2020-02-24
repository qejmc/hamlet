import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile mazeTile = new MazeTile(1);
    public static Tile stoneTile = new StoneTile(2);
    public static Tile waterTile = new WaterTile(3);
    public static Tile cobbleTile = new CobbleTile(4);
    public static Tile checkerTile = new CheckerTile(5);
    public static Tile wallTile = new WallTile(6);
    public static Tile roof_1Tile = new Roof_1Tile(7);
    public static Tile roof_2Tile = new Roof_2Tile(8);
    public static Tile roof_3Tile = new Roof_3Tile(9);
    public static Tile dirtTile = new DirtTile(10);
    public static Tile bridge1Tile = new Bridge1Tile(11);
    public static Tile bridge2Tile = new Bridge2Tile(12);
    public static Tile bridge3Tile = new Bridge3Tile(13);
    public static Tile bridge4Tile = new Bridge4Tile(14);
    public static Tile bridge5Tile = new Bridge5Tile(15);
    public static Tile bridge6Tile = new Bridge6Tile(16);

    protected BufferedImage texture;
    protected final int id;
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }
}
