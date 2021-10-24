package task2.umi.magicTools;

import java.util.ArrayList;
import java.util.List;

public class MagicTools {
    private List<int[]> mazeSolution;

    private int[][] mazeMap;
    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;
    private int road;

    public MagicTools() {
    }

    public void loadMazeMap(int[][] mazeMap, int startRow, int startCol, int endRow, int endCol) {
        this.mazeMap = mazeMap;
        this.startCol = startCol;
        this.startRow = startRow;
        this.endRow = endRow;
        this.endCol = endCol;
        this.road = mazeMap[startRow][startCol];
    }

    public void solveMaze() {
        if (mazeMap == null) {
            return;
        }
        // dfs自动解迷宫，返回路径
        boolean[][] visited = new boolean[mazeMap.length][mazeMap[0].length];
        List<int[]> path = new ArrayList<>();
        dfs(path, startRow, startCol, visited);
        mazeSolution.remove(0);
    }

    private boolean dfs(List<int[]> path, int row, int col, boolean[][] visited) {
        // 超过范围肯定找不到
        if (row < 0 || row > mazeMap.length || col < 0 || col > mazeMap[0].length || visited[row][col]
                || mazeMap[row][col] != road) {
            return false;
        }

        path.add(new int[] { row, col });
        visited[row][col] = true;
        if (row == endRow && col == endCol) {
            mazeSolution = new ArrayList<>(path);
            return true;
        }

        boolean ret = false;
        if (dfs(path, row + 1, col, visited) || dfs(path, row - 1, col, visited) || dfs(path, row, col + 1, visited)
                || dfs(path, row, col - 1, visited)) {

            ret = true;
        }

        path.remove(path.size() - 1);
        visited[row][col] = false;

        return ret;
    }

    public List<int[]> getSolution() {
        return this.mazeSolution;
    }
}
