public class CobbleTile extends Tile{

    public CobbleTile(int id) {
        super(Assets.cobble, id);
    }

    public boolean isSolid(){
        return false;
    }
}