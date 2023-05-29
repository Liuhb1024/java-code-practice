import java.awt.*;

/**
 * @author 刘浩彬
 * @date 2023/5/28
 */
public class Chess {
    private int x;
    private int y;
    private Color color;
    public static int DIAMETER = 30;
    public Chess(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}
