public class Bridge1Tile extends Tile{

    public Bridge1Tile(int id) {
        super(Assets.bridge1, id);
    }

    public boolean isSolid(){
        return true;
    }
}