import java.awt.*;

public class WinState extends State {
    public WinState(Handler handler){
        super(handler);
    }

    public void tick() { }


    public void render(Graphics g) {
        Image menu = ImageLoader.loadImage("/textures/win.png");
        g.drawImage(menu, 0, 0, null);
    }
}