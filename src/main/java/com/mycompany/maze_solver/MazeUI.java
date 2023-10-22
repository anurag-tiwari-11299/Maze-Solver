// author tiwari

package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class MazeUI extends JFrame {
    // inheritance
    
    // 2D grid
    // 1 - boundary
    // 2 - obstacle
    // 0 - path
    // 9 - final point
    private int [][] maze = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 1},
        {1, 0, 2, 0, 0, 0, 2, 0, 2, 2, 2, 0, 1},
        {1, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 2, 0, 0, 0, 0, 2, 2, 2, 0, 1},
        {1, 0, 2, 0, 2, 2, 2, 0, 2, 0, 0, 0, 1},
        {1, 0, 2, 0, 2, 0, 0, 0, 2, 2, 2, 0, 1},
        {1, 0, 2, 0, 2, 2, 2, 0, 2, 0, 2, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 9, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    // to store coordinates of path which lead to destination point
    public List<Integer> path = new ArrayList<>();
    
    // constructor for window
    public MazeUI(){
        setTitle("Maze Solver"); //  window name
        setSize(640, 480); // window size
        // when click on exit button, JFrame get close with all operations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DFS.searchpath(maze, 1, 1, path);
        System.out.println(path);
    }
    
    // here implement the predefined funct paint
    @Override
    public void paint(Graphics g){
        // put the graphics to these coordinates in window
        g.translate(125, 100);
        
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                Color color;
                
                switch(maze[i][j]){
                    case 1: color = Color.BLACK; // boundary
                            break;
                    case 2: color = Color.darkGray; // obstacle
                            break;
                    case 9: color = Color.orange; // final
                            break;
                    default: color = Color.white; // path
                            break;
                }
                
                // set the color to that particular box
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                
                // boundaries to segregate with adjacent elements
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }
        
        for(int i=0;i<path.size();i+=2){
            int path_j = path.get(i);
            int path_i = path.get(i + 1);
            
            System.out.println("i coordinates " + path_i);
            System.out.println("j coordinates " + path_j);
            
            g.setColor(Color.green);
            g.fillRect(30 * path_j, 30 * path_i, 25, 25);
        }
    }
    
    public static void main(String[] args) {
        MazeUI view = new MazeUI();
        view.setVisible(true);
    }
}