/*
    Introduction to OOP with Java (5th Ed), McGraw-Hill

    Wu/Otani

    Chapter 7 Sample Program: Tic Tac Toe Board

    File: Ch14TicTacToePanel.java

*/

import javafx.scene.control.Cell;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class handles the visual display of the Tic-Tac-Toe game.
 *
 * @author Dr. Caffeine
 */
public class Ch14TicTacToePanel extends JPanel implements MouseListener {

//-----------------------------------------
//
//    Data Members:
//
//-----------------------------------------

    /** Keeps track of player turn; true if circle's turn */
    private boolean circle;
    private JMenuBar turn;
    private JLabel t;
    private JPanel turns;
    private int currentPosition;
    Ch14TicTacToeCell[][] array = new Ch14TicTacToeCell[3][3];
    private Stack<Ch14TicTacToeCell> storage = new Stack<>();
    private Queue<Ch14TicTacToeCell> cellstorage = new LinkedList<>();
    private Container container;


    /**
     * Creates a panel of N by N cells
     *
     *@param size the dimension of the rows and cols
     */
    public Ch14TicTacToePanel(Container lol, int size) {
        turns = new JPanel();

        this.container = lol;
        JMenuBar scoreBar = new JMenuBar();
        scoreBar.setOpaque(true);
        scoreBar.setBackground(new Color(165, 159, 146));
        scoreBar.setPreferredSize(new Dimension(200, 50));
        scoreBar.add(new JLabel("Turn: "));
        turns.add(scoreBar);

        turns.setBorder( BorderFactory.createTitledBorder("Turn"));
        lol.add(Ch14NestedPanels1.controlPanel.add(turns), BorderLayout.NORTH);

        turn = scoreBar;

        Ch14TicTacToeCell cell;
        setLayout(new GridLayout(size, size));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cell = new Ch14TicTacToeCell();
                this.array[row][col] = cell;
                cell.addMouseListener(this);
                add(cell);
            }
        }

        circle = true;

        t = new JLabel();
        t.setText("  Player 1 turn");
        turn.add(t);
    }

    public void mouseClicked(MouseEvent event) {


        Ch14TicTacToeCell cell = (Ch14TicTacToeCell) event.getSource();

        if(cell.getContent().getText() != null) return;

        if (t.getText().equals("Player 1 turn")) {
            t.setText("Player 2 turn");
            Bucket<Integer, Integer> posititon =  addToArray(cell, event, Ch14TicTacToeCell.Image.CIRCLE);
            if (checkforWin(cell, posititon.getRow(), posititon.getCol())) {
                displayGameOverStatus();
            }


        } else {
            t.setText("Player 1 turn");
            Bucket<Integer, Integer> position =  addToArray(cell, event, Ch14TicTacToeCell.Image.CROSS);
            if (checkforWin(cell, position.getRow(), position.getCol())) {
                displayGameOverStatus();
            }

        }
    }
    private Bucket<Integer, Integer> addToArray(Ch14TicTacToeCell cell, MouseEvent e, Ch14TicTacToeCell.Image image) {

        int roww = -1;
        int coll = -1;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] ==  e.getSource()){
                roww = i;
                coll = j;
                array[i][j].setContent(image);
                }
                }
            }
            return new Bucket<Integer, Integer>(roww, coll);
        }



    private boolean checkforWin(Ch14TicTacToeCell cell, int row, int col) {

        if(checkHorizontal(cell, row, col)) {
            LightenUp();
            return true;
        }
        storage.clear();
        if(checkVertical(cell, row, col)) {
            LightenUp();
            return true;
        }
        storage.clear();
        if(checkDiagonalRight(cell, row, col)){
            System.out.println("OK");
            LightenUp();
            return true;
        }
        storage.clear();
        if(checkDiagonalLeft(cell, row, col))return true;

        return false;

    }

    private void LightenUp() {



        while(!storage.isEmpty()){
            Ch14TicTacToeCell cell = storage.pop();
            cell.setBackground(new Color(255, 78, 71));
        }


        displayGameOverStatus();

    }

    private boolean checkHorizontal(Ch14TicTacToeCell cell, int row, int cols){

        boolean isTrue = true;
        String text = cell.getContent().getText();
        for(int col = 0; col < array[row].length; col++){
            if(!text.equals(array[row][col].getContent().getText())){

                isTrue = false;
            }

            storage.add(array[row][col]);
        }
        return isTrue;
    }

    private boolean checkVertical(Ch14TicTacToeCell cell, int row, int col){

        boolean isTrue = true;
        String text = cell.getContent().getText();
        for(int i = 0; i < array.length; i++){
            if(!text.equals(array[i][col].getContent().getText())){
                isTrue = false;
            }
            storage.add(array[i][col]);
        }
        return isTrue;
    }


    private boolean checkDiagonalRight(Ch14TicTacToeCell cell, int row, int col){



        boolean isTrue = true;
        int cols = 0;
        String text = cell.getContent().getText();
        for(int rows = 0; rows < array.length; rows++){
            if(!text.equals(array[rows][cols].getContent().getText())){
                isTrue = false;

            }
            storage.add(array[rows][cols]);
            cols++;

        }

        return isTrue;
    }


    private boolean checkDiagonalLeft(Ch14TicTacToeCell cell, int row, int col){


        return false;


    }
    private void displayGameOverStatus() {



    }

    public void mouseEntered   ( MouseEvent event) {

       for(Ch14TicTacToeCell c : cellstorage){
           c.setBackground(Color.black);
       }
        Ch14TicTacToeCell cell = (Ch14TicTacToeCell) event.getSource();
        cellstorage.add(cell);
        cell.setBackground(new Color(100, 122, 154));




    }
    public void mouseExited    ( MouseEvent event ) { }
    public void mousePressed   ( MouseEvent event ) { }
    public void mouseReleased  ( MouseEvent event ) { }

}