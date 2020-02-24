public class Bridge3Tile extends Tile{

    public Bridge3Tile(int id) {
        super(Assets.bridge3, id);
    }

    public boolean isSolid(){
        return true;
    }
}