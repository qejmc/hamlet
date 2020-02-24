public class Bridge2Tile extends Tile{

    public Bridge2Tile(int id) {
        super(Assets.bridge2, id);
    }

    public boolean isSolid(){
        return true;
    }
}