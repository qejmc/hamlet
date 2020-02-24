import java.awt.*;

public class World {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private EntityManager entityManager;

    public World(Handler handler, String path){
        int sizeFactor = 64;
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 1850, 180));
        entityManager.addEntity(new Tree(handler, sizeFactor*3, 180));
        entityManager.addEntity(new Tree(handler, sizeFactor*2 +20, sizeFactor*15));
        entityManager.addEntity(new Tree(handler, sizeFactor*10 + 30, sizeFactor*6));
        entityManager.addEntity(new Tree(handler, sizeFactor*21, sizeFactor*2));
        entityManager.addEntity(new Tree(handler, sizeFactor*19, sizeFactor*5));
        entityManager.addEntity(new Tree(handler, sizeFactor*18, sizeFactor*15));
        entityManager.addEntity(new Tree(handler, sizeFactor*28, sizeFactor*16));
        entityManager.addEntity(new Tree(handler, sizeFactor*23, sizeFactor*14));
        entityManager.addEntity(new Tree(handler, sizeFactor*21, sizeFactor*10));
        entityManager.addEntity(new Ophelia(handler, 1984, 180));
        entityManager.addEntity(new Claudius(handler, 3168, 544));
        entityManager.addEntity(new Apple(handler, sizeFactor*3, 250));
        //entityManager.addEntity(new Apple(handler, 64*3, 200));
        entityManager.addEntity(new Apple(handler, sizeFactor*2 +50, sizeFactor*16));
        entityManager.addEntity(new Ghost(handler, sizeFactor*28, sizeFactor*15));
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick(){
        entityManager.tick();
    }

    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
        for(int y = yStart; y<yEnd; y++){
            for(int x = xStart; x<xEnd; x++){
                getTile(x, y).render(g, (int) (x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        entityManager.render(g);
    }

    public Tile getTile(int x, int y){
        if(x<0 || y<0 || x>= width || y>= height){
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null){
            return Tile.dirtTile;
        }
        return t;
    }

    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y*width) + 4]);
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
