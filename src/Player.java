import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;
    private Animation animAttackRight;
    private boolean isAttackRight;
    private long lastAttackTimer, attackCooldown = 300, attackTimer = attackCooldown;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 12;
        bounds.y = 0;
        bounds.width = 42;
        bounds.height = 64;

        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
        animAttackRight = new Animation(500, Assets.attack_right);
    }

    public void tick() {
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        animAttackRight.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        checkAttacks();
    }

    private void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown){
            return;
        }
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
            isAttackRight = false;
        }
        else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            isAttackRight = false;
        }
        else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height /2 - arSize / 2;
            isAttackRight = false;
        }
        else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height /2 - arSize / 2;
            isAttackRight = true;
        }
        else{
            return;
        }
        attackTimer = 0;
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
    }

    public void die(){
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(handler.getKeyManager().up){
            yMove = -speed;
            isAttackRight = false;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
            isAttackRight = false;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
            isAttackRight = false;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height,null);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }
        else if (xMove > 0){
            if(isAttackRight){
                return animAttackRight.getCurrentFrame();
            }
            return animRight.getCurrentFrame();
        }
        else if (yMove < 0){
            return animUp.getCurrentFrame();
        }
        else{
            return animDown.getCurrentFrame();
        }
    }
}
