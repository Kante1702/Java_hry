import java.awt.*;

public class Score extends Rectangle {

    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    int playeer_1;
    int playeer_2;

    Score (int SCREEN_WIDTH, int SCREEN_HEIGHT) {
        Score.SCREEN_WIDTH = SCREEN_WIDTH;
        Score.SCREEN_HEIGHT = SCREEN_HEIGHT;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.BOLD, 30));
        g.drawLine(SCREEN_WIDTH/2,0,SCREEN_WIDTH/2,SCREEN_HEIGHT);
        g.drawString(String.valueOf(playeer_1/10)+String.valueOf(playeer_1%10)+" "+String.valueOf(playeer_2/10)+String.valueOf(playeer_2%10),SCREEN_WIDTH/2 - 42,40);
        g.drawString("Player1" ,10, 40);
        g.drawString("Player2" , 870, 40);

    }
}
