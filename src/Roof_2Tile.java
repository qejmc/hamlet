public class Roof_2Tile extends Tile{

    public Roof_2Tile(int id) {
        super(Assets.roof_2, id);
    }

    public boolean isSolid(){
        return true;
    }
}