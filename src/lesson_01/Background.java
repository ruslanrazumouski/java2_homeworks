package lesson_01;

import java.awt.*;

public class Background /*extends GameCanvas*/{
    private Color color;
    /*private final Color color = new Color (
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );

     */

    Background() {
        color = new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
    }

    /*
    Background(MainCircles gameController, GameCanvas canvas) {
        super(gameController);
        //canvas.setBackground(color);
    }

     */

    public Color getColor() {
        return color;
    }
}
