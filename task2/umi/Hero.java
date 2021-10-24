package task2.umi;

import java.util.List;

import task2.umi.magicTools.MagicTools;

public class Hero extends Creature {

    private List<int[]> mazeSolution;

    public Hero(World world) {
        super(world);
    }

    private void useMagicTools() {
        MagicTools magicTool = new MagicTools();
        int[][] mazeMap = world.getMazeMap();
        int xPos = getTile().getxPos();
        int yPos = getTile().getyPos();
        magicTool.loadMazeMap(mazeMap, xPos, yPos, mazeMap.length - 2, mazeMap[0].length - 1);
        magicTool.solveMaze();
        mazeSolution = magicTool.getSolution();
    }

    public void autoMove() {
        if (mazeSolution == null) {
            useMagicTools();
        }
        if (mazeSolution.size() != 0) {
            moveTo(mazeSolution.get(0)[0], mazeSolution.get(0)[1]);
            mazeSolution.remove(0);
        }
    }

    public void abandonMazeSolution() {
        mazeSolution = null;
    }
}
