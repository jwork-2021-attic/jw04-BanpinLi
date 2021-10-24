package task1.com.anish.calabashbros;

import java.awt.Color;

public class Thing {

    protected World world;

    public Tile<? extends Thing> tile;

    public int getX() {
        return this.tile.getxPos();
    }

    public int getY() {
        return this.tile.getyPos();
    }

    public void setTile(Tile<? extends Thing> tile) {
        this.tile = tile;
    }

    Thing(Color color, char glyph, World world) {
        this.color = color;
        this.glyph = glyph;
        this.world = world;
    }

    private final Color color;

    public Color getColor() {
        return this.color;
    }

    // 也就是用来显示一个ascii码，不同的ascii码对应不同的图案
    private final char glyph;

    public char getGlyph() {
        return this.glyph;
    }

}
