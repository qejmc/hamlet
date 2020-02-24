import java.awt.*;

public class MenuState extends State {
    public MenuState(Handler handler){
        super(handler);
    }

    public void tick() {
        if(handler.getMouseManager().isLeftPressed() || handler.getMouseManager().isRightPressed()){
            State.setState(handler.getGame().gameState);
        }
    }

    public void render(Graphics g) {
        Image menu = ImageLoader.loadImage("/textures/hamlet.png");
        g.drawImage(menu, 0, 0, null);
    }
}
