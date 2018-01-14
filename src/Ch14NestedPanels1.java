

import javax.swing.*;
import java.awt.*;

/**
 * A sample frame to illustrate the placing of nested panels.
 * This class illustrates the building of user interface only,
 * logic control for actually playing the game is NOT included.
 */
class Ch14NestedPanels1 extends JFrame {

//----------------------------------
//    Data Members
//----------------------------------
    public static  JPanel controlPanel = new JPanel();

    /**
     * Default frame width
     */
    private static final int FRAME_WIDTH    = 700;

    /**
     * Default frame height
     */
    private static final int FRAME_HEIGHT   = 450;

    /**
     * X coordinate of the frame default origin point
     */
    private static final int FRAME_X_ORIGIN = 150;

    /**
     * Y coordinate of the frame default origin point
     */
    private static final int FRAME_Y_ORIGIN = 250;


//----------------------------------
//      Main method
//----------------------------------
    public static void main(String[] args) {
        Ch14NestedPanels1 frame = new Ch14NestedPanels1();
        frame.setVisible(true);
    }


//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch14NestedPanels1() {


        Container         contentPane;
        Ch14TicTacToePanel gamePanel = null;
        JPanel            scorePanel = null;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setTitle     ("TicTacToe Game");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 0));

        gamePanel = new Ch14TicTacToePanel(contentPane, 3);
        gamePanel.setBorder(BorderFactory.createLoweredBevelBorder());
        controlPanel.setLayout(new BorderLayout());


        contentPane.add(gamePanel, BorderLayout.CENTER);
        contentPane.add(controlPanel, BorderLayout.WEST);
        scorePanel = new JPanel();
        scorePanel.setBorder( BorderFactory.createTitledBorder("Scores:"));
        scorePanel.setLayout(new GridLayout(2, 2));
        scorePanel.add(new JLabel("Player 1:"));
        scorePanel.add(new JLabel("     0"));
        scorePanel.add(new JLabel("Player 2:"));
        scorePanel.add(new JLabel("     0"));

        controlPanel.add(scorePanel,BorderLayout.NORTH);
        controlPanel.add(new JButton("New Game"), BorderLayout.SOUTH);

        //register 'Exit upon closing' as a default close operation
        setResizable(false);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

}
