import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int brickWidth, brickHeight , padding =8;

    public MapGenerator(int row, int col) {
        map = new int[row][col];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = 1;
            }
        }
        brickWidth = 980/col;
        brickHeight = 200/row;
    }

    public void draw(Graphics2D g) {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y] >0) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(y*(brickWidth+padding) +80, x*(brickHeight+padding)+50, brickWidth, brickHeight);
                    //g.getStroke(new BasicStroke(3));
                    //g.getStroke((Stroke) Color.black);
                    g.setColor(Color.BLACK);
                    g.drawRect(y*(brickWidth+padding) +80, x*(brickHeight+padding)+50, brickWidth, brickHeight);

                }
            }
        }
    }
    public void setBrickValue(int value, int row , int col) {
        map[row][col] = value;
    }
}
