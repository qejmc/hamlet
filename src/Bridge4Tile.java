public class Bridge4Tile extends Tile{

    public Bridge4Tile(int id) {
        super(Assets.bridge4, id);
    }

    public boolean isSolid(){
        return true;
    }
}