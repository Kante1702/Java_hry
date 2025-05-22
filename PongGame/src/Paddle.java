import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    int ID;
    int yVelocity;
    int speed = 10;

    Paddle(int x_pos, int y_pos, int width, int height, int ID) {
    super(x_pos, y_pos, width, height);
    this.ID = ID;
    }
    public void keyPressed(KeyEvent e) {
        switch(ID){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(-speed);
                    move();
                }
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                break;
                case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(-speed);
                    move();
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch(ID){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                else if(e.getKeyCode() == KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    public void setYDirection(int speed){
        yVelocity = speed;
    }
    public void move(){
        y = y + yVelocity;
    }
    public void draw(Graphics g){
        if(ID==1) {
            g.setColor(Color.black);
            g.fillRect(x,y,width, height);
        }
        else if(ID==2) {
            g.setColor(Color.red);
            g.fillRect(x,y, width, height);
        }
    }

}
