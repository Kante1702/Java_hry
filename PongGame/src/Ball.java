import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle {

    int xVelocity;
    int yVelocity;
    Random random;
    int initial_speed = 5;

    Ball(int x_pos, int y_pos, int width ,int height){
        super(x_pos,y_pos,width,height);
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0){
            randomXDirection --;
            setXDirection(randomXDirection*initial_speed);
        }
    else {
        setXDirection(randomXDirection * initial_speed);  // Nastaví 1 alebo -1
        }

        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0){
            randomYDirection --;
            setYDirection(randomYDirection*initial_speed);
        }
        else {
            setYDirection(randomYDirection * initial_speed);  // Nastaví 1 alebo -1
        }
        if(randomXDirection == 0){
            setXDirection(initial_speed);
        }

    }

    public void setXDirection (int randomXDir){
        xVelocity = randomXDir;
    }
    public void setYDirection (int randomYDir){
        yVelocity = randomYDir;
    }

    public void move(){
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, width, height);

    }

}
