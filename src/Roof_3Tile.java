public class Roof_3Tile extends Tile{

    public Roof_3Tile(int id) {
        super(Assets.roof_3, id);
    }

    public boolean isSolid(){
        return true;
    }
}