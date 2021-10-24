package task2.umi;

import task2.asciiPanel.AsciiPanel;

public class Creature extends Thing {

    public Creature(World world) {
        super(AsciiPanel.brightGreen, (char) 11, world);
    }

    public void moveTo(int xPos, int yPos) {
        if (canMove(xPos, yPos)) {
            int x = this.getTile().getxPos();
            int y = this.getTile().getyPos();
            world.put(this, xPos, yPos);
            world.put(new Trace(world), x, y);
        }
    }

    private boolean canMove(int xPos, int yPos) {
        if (xPos < 0 || xPos >= World.HEIGHT || yPos < 0 || yPos >= World.WIDTH) {
            return false;
        }
        int[][] mazeMap = world.getMazeMap();
        if (mazeMap[xPos][yPos] == 0) {
            return false;
        }
        int x = this.getTile().getxPos();
        int y = this.getTile().getyPos();
        if (x == xPos && y == yPos) {
            return false;
        }
        return true;
    }
}
