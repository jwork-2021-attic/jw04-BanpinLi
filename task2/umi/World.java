package task2.umi;

import task2.mazeGenerate.MazeGenerator;

public class World {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;

    private Tile<Thing>[][] tiles;
    private int[][] mazeMap;
    private Creature creature;

    // 这个是world从开始存在的时候就有的状态
    public World() {
        if (this.tiles == null) {
            this.tiles = new Tile[WIDTH][HEIGHT];
        }
        // 加载地图``````````
        if (mazeMap == null) {
            MazeGenerator mg = new MazeGenerator(WIDTH);
            mg.generateMaze();
            mazeMap = mg.getMazeMap();
        }

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                tiles[i][j] = new Tile<>(i, j);
                if (mazeMap[i][j] == 0) {
                    tiles[i][j].setThing(new Wall(this));
                } else {
                    tiles[i][j].setThing(new Floor(this));
                }
            }
        }
    }

    public Thing get(int x, int y) {
        return this.tiles[x][y].getThing();
    }

    public void put(Thing t, int x, int y) {
        this.tiles[x][y].setThing(t);
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public Creature getCreatrue() {
        return this.creature;
    }

    public int[][] getMazeMap() {
        return this.mazeMap;
    }

}
