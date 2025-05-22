import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = (int)(SCREEN_WIDTH * 0.555);
    static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    static final int ballDiameter = 20;
    static final int paddleWidth = 20;
    static final int paddleHeight = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    private boolean running = true;
    private boolean paused = false;


    GamePanel (){
        newPaddle();
        newBall();
        score = new Score(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setPreferredSize(SCREEN_SIZE);
        this.setFocusable(true);
        this.addKeyListener(new ActListener());

        gameThread = new Thread(this);
        gameThread.start();

    }


    public void newBall(){
        random = new Random();
        ball = new Ball((SCREEN_WIDTH/2)- (ballDiameter/2), random.nextInt(SCREEN_HEIGHT-ballDiameter), ballDiameter,ballDiameter);

    }

    public void newPaddle(){
        paddle1 = new Paddle(0,(SCREEN_HEIGHT/2)-(paddleHeight/2),paddleWidth,paddleHeight,1);
        paddle2 = new Paddle(SCREEN_WIDTH-paddleWidth,(SCREEN_HEIGHT/2)-(paddleHeight/2),paddleWidth,paddleHeight,2);

    }
    public void paint (Graphics g){
        //vytvarame grafiku
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw (Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    public void move(){
        if(!paused) {
            paddle1.move();
            paddle2.move();
            ball.move();
        }
    }
    public void collision(){
        //toto zastavuje paddles
        if(paddle1.y <= 0){
            paddle1.y = 0;
        }
        else if (paddle1.y >= (SCREEN_HEIGHT-paddleHeight)){
            paddle1.y = (SCREEN_HEIGHT-paddleHeight);
        }

        if(paddle2.y <= 0){
            paddle2.y = 0;
        }
        else if (paddle2.y >= (SCREEN_HEIGHT-paddleHeight)){
            paddle2.y = (SCREEN_HEIGHT-paddleHeight);
        }
        //bouncuje loptu od okrajov okna

        if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }

        else if(ball.y >= (SCREEN_HEIGHT-ballDiameter)){
            ball.setYDirection(-ball.yVelocity);
        }

        //toto bouncuje od paddle
        if(ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//for more difficulty ... more speed
            if(ball.yVelocity > 0){
                ball.yVelocity++;
            }
            else if(ball.yVelocity < 0){
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if(ball.yVelocity > 0){
                ball.yVelocity++;
            }
            else if(ball.yVelocity < 0){
                ball.yVelocity--;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        //bodovanie pridava 1 bod a resetuje to
        if(ball.x <=0){
            score.playeer_2 ++;
            newPaddle();
            newBall();
        }
        if(ball.x >= SCREEN_WIDTH-ballDiameter){
            score.playeer_1 ++;
            newPaddle();
            newBall();
        }
    }

    //game loop
    @Override
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1) {
                if (!paused) {

                move();
                collision();
                repaint();
                }
                delta--;
            }
        }

    }

    public void pauseGame(){
        paused = true;
    }
    public void resumeGame(){
        paused = false;
    }



    public class ActListener extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);

        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);

        }


    }

}
