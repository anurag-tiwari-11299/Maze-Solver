// author tiwari

package com.mycompany.maze_solver;

import java.util.List;

public class DFS {

    public static boolean searchpath(int maze[][], int j, int i, List<Integer> path) {
        
        // base case
        if(maze[i][j] == 9){
            path.add(j);
            path.add(i);
            return true;
        }
        
        // condition, maze[2][2]
        if(maze[i][j] == 0){
            maze[i][j] = 5;
            
            // maze[2 + 0][2 + (-1)] = maze[2][1], left
            int di = 0;
            int dj = -1;
            if(searchpath(maze, j + dj, i + di, path)){
                path.add(j);
                path.add(i);
                return true;
            }
            
            // maze[2 + 0][2 + 1] = maze[2][3], right
            di = 0;
            dj = 1;
            if(searchpath(maze, j + dj, i + di, path)){
                path.add(j); 
                path.add(i);
                return true;
            }
            
            // maze[2 + (-1)][2 + 0] = maze[1][2], top
            di = -1;
            dj = 0;
            if(searchpath(maze, j + dj, i + di, path)){
                path.add(j);
                path.add(i);
                return true;
            }
            
            // maze[2 + 1][2 + 0] = maze[3][2], bottom
            di = 1;
            dj = 0;
            if(searchpath(maze, j + dj, i + di, path)){
                path.add(j);
                path.add(i);
                return true;
            }
        }
        
        // if (maze[y][j] == 1 || 2 || 5)
        return false;
    }
}