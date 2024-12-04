package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args){
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allPaths("", board,0, 0);
    }

    static int count(int row, int col){
        if(row == 1 || col == 1) return 1;

        System.out.println();

        int left = count(row - 1, col);
        int right = count(row, col - 1);

        return left + right;
    }

    static List<String> path(String p, int row, int col){
        if(row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();

        if(row > 1){
            list.addAll(path(p + "D", row - 1, col));
        }

        if(col > 1){
            list.addAll(path(p + "R", row, col - 1));
        }

        return list;
    }

    static void allPaths(String p, boolean[][] maze ,int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(!maze[row][col]){
            return;
        }

        maze[row][col] = false;

        if(row < maze.length - 1){
            allPaths(p + "D", maze,row + 1, col);
        }

        if(col < maze[0].length - 1){
            allPaths(p + "R",maze, row, col + 1);
        }

        if(row > 0){
            allPaths(p + "U", maze, row - 1, col);
        }

        if(col > 0){
            allPaths(p + "L", maze, row, col - 1);
        }

        maze[row][col] = true;

    }
}
