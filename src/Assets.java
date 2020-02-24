import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 16, height = 16;
    public static BufferedImage dirt, grass, stone, tree, water, cobble, roof_1, roof_2, roof_3, checker, wall, ophelia, claudius, maze_block, apple;
    public static BufferedImage bridge1, bridge2, bridge3, bridge4, bridge5, bridge6, ghost;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage[] start_button;
    public static BufferedImage[] attack_down, attack_up, attack_left, attack_right;
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite.png"));
        player_down = new BufferedImage[2];
        player_down[0] = sheet.crop(0, height, width, height);
        player_down[1] = sheet.crop(width, height, width, height);

        player_up = new BufferedImage[2];
        player_up[0] = sheet.crop(width*2, height, width, height);
        player_up[1] = sheet.crop(width*3, height, width, height);

        player_left = new BufferedImage[2];
        player_left[0] = sheet.crop(width*2, height*2, width, height);
        player_left[1] = sheet.crop(width*3, height*2, width, height);

        player_right = new BufferedImage[2];
        player_right[0] = sheet.crop(0, height*2, width, height);
        player_right[1] = sheet.crop(width, height*2, width, height);

        grass = sheet.crop(width,0, width, height);
        dirt = sheet.crop(0,0, width, height);
        stone = sheet.crop(width*3,0, width, height);
        tree = sheet.crop(width*4, 0, width, height*2);
        claudius = sheet.crop(width*2, height*3, width*2, height*2);
        water = sheet.crop(0, height*5, width, height);
        cobble = sheet.crop(width, height*5, width, height);
        roof_1 = sheet.crop(0, height*6, width, height);
        roof_2 = sheet.crop(width, height*6, width, height);
        roof_3 = sheet.crop(0, height*7, width, height);
        checker = sheet.crop(width, height*7, width, height);
        wall = sheet.crop(0, height*8, width, height);
        ophelia = sheet.crop( width*2, height* 5, width, height*2);
        maze_block = sheet.crop(width, height*8, width, height);
        apple = sheet.crop(width*2, height*8, width, height);
        bridge1 = sheet.crop(width*2, height*7, width, height);
        bridge2 = sheet.crop(width*3, height*8, width, height);
        bridge3 = sheet.crop(width*3, height*7, width, height);
        bridge4 = sheet.crop(0, height*9, width, height);
        bridge5 = sheet.crop(width, height*9, width, height);
        bridge6 = sheet.crop(width*2, height*9, width, height);
        ghost = sheet.crop(width, height*10, width*2, height*2);

        start_button = new BufferedImage[2];
        start_button[0] = sheet.crop(0, height*3, width*2, height);
        start_button[1] = sheet.crop(0, height*4, width*2, height);

        attack_right = new BufferedImage[2];
        attack_right[0] = sheet.crop(0, height*10, width, height);
        attack_right[1] = sheet.crop(0, height*2, width, height);

    }
}
