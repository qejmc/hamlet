public class Roof_1Tile extends Tile{

    public Roof_1Tile(int id) {
        super(Assets.roof_1, id);
    }

    public boolean isSolid(){
        return true;
    }
}