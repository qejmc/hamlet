public class CheckerTile extends Tile{

    public CheckerTile(int id) {
        super(Assets.checker, id);
    }

    public boolean isSolid(){
        return false;
    }
}