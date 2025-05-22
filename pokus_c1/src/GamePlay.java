import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.PublicKey;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;
    private int bricksRows = 5; //riadky
    private int bricksCols = 9; //stlpce
    private int padding = 5; //medzera
    private int recWidth = 105; //sirka
    private int recHeight = 30; //vyska

    private Timer timer;
    private int delay = 6;

    private int playerX=550;
    private int ballX = 590;
    private int ballY = 500;
    private int ballXDir = -1;
    private int ballYDir = -2;
    private MapGenerator map;

    public GamePlay() {
        map = new MapGenerator(bricksRows, bricksCols);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        map.draw((Graphics2D) g);

        g.setColor(Color.red);
        g.fillRect(playerX, 600,100,10);

        g.setColor(Color.CYAN);
        g.fillOval(ballX , ballY,20,20);

        g.setColor(Color.ORANGE);
        /*for(int i = 0; i < bricksRows; i++) {
            for(int j = 0; j < bricksCols; j++) {
                int x = j*(recWidth+padding) +50;
                int y = i*(recHeight+padding) +50;

                g.fillRect(x, y, recWidth,recHeight);
            }
        }
        */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play) {
            ballX += ballXDir;
            ballY += ballYDir;

            if(ballX <= 0|| ballX >= getWidth()-20 ) {
                ballXDir = -ballXDir;
            }
            if(ballY <=0 ) {
                ballYDir = -ballYDir;
            }

            if(ballY-20 >= getHeight()-100 && ballX >= playerX && ballX <= playerX+100 ) {
                ballYDir = -ballYDir;
            }
            if(ballY >= getHeight()) {
                play = false;
                ballXDir = 0;
                ballYDir = 0;
                System.out.println("polib prdel");
            }
        }
        for (int i = 0; i < bricksRows; i++) {
            for (int j = 0; j < bricksCols; j++) {
                if (map.map[i][j] > 0) { // Tehlička existuje
                    int brickX = j * map.brickWidth + 80;
                    int brickY = i * map.brickHeight + 50;
                    int brickWidth = map.brickWidth;
                    int brickHeight = map.brickHeight;

                    Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
                    Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);

                    if (ballRect.intersects(brickRect)) {
                        map.setBrickValue(0, i, j); // Zničíme tehličku
                        score += 10;

                        // Kontrola smeru kolízie
                        if (ballX + 19 <= brickX || ballX >= brickX + brickWidth) {
                            ballXDir = -ballXDir; // Horizontálny odraz
                        } else {
                            ballYDir = -ballYDir; // Vertikálny odraz
                        }
                    }
                }
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            resetGame();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX >=1090)
                playerX = 1090;
            else {
                moveRight();
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 10)
            {
                playerX = 10;
            }
            else {
                moveLeft();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private void moveLeft() {
        play = true;
        playerX -= 20;
    }

    private void moveRight() {
        play = true;
        playerX += 20;
    }
    private void resetGame() {
        play = true;
        ballX = 590;
        ballY = 500;
        ballXDir = -1;
        ballYDir = -2;
        score = 0;
        repaint();
    }
}

