package task2.umi;

import java.awt.Color;

public class Thing {

    protected World world;
    private Tile<? extends Thing> tile;

    private final Color color;
    private final char glyph;

    public Thing(Color color, char glyph, World world) {
        this.color = color;
        this.glyph = glyph;
        this.world = world;
    }

    public void setTile(Tile<? extends Thing> tile) {
        this.tile = tile;
    }

    public Tile<? extends Thing> getTile() {
        return this.tile;
    }

    public char getGlyph() {
        return this.glyph;
    }

    public Color getColor() {
        return this.color;
    }
}
