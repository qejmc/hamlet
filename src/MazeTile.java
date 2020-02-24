public class MazeTile extends Tile{

    public MazeTile(int id) {
        super(Assets.maze_block, id);
    }

    public boolean isSolid(){
        return true;
    }
}
