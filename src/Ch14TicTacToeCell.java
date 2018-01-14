

import javafx.scene.text.*;

import java.awt.*;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import javax.swing.*;


 
public class Ch14TicTacToeCell extends JPanel  {

//-----------------------------------------
//
//    Data Members:
//
//-----------------------------------------
    
    /** Enum for icon images */
    public static enum Image {BLANK, CIRCLE, CROSS}

    /** The image file of the cross */
    private static final String CROSS_IMAGE_FILE = "cross.gif";

    /** The image file of the circle */
    private static final String CIRCLE_IMAGE_FILE = "circle.gif";

    /** The image file of a blank */
    private static final String BLANK_IMAGE_FILE  = "blank.gif";

    /** Label object occuping this JPanel */
    private JLabel content;

    /** Location of this cell in the board */
   // private Point location;


//-----------------------------------------
//
//    Constructors:
//
//-----------------------------------------

    /**
     * Default constructor.
     */
    public Ch14TicTacToeCell( ) {
        this(null);
    }

    /**
     * Construct a cell with a given position
     *
     * @param pt the position of this cell on the board
     */
    public Ch14TicTacToeCell(Point pt) {

        ImageIcon initImage = new ImageIcon("blank.gif");

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        content = new JLabel(initImage);
        add(content);

       //location = pt;

    }

    public JLabel getContent() {

        return content;
    }



    /**
     * Returns its location.
     *
     * @return this cell's location in the board
     */
   // public Point getPosition( ) {
        //return location;
    //}

    /**
     * Changes the content to the designated image
     *
     * @param image the shape to occupy the content
     */
    public void setContent(Image image) {



        content.setFont(new Font("Serif", Font.BOLD, 26));
        content.setForeground(Color.GREEN);

        switch (image) {

            case CIRCLE: //content.setIcon(new ImageIcon("circle.gif"));
                content.setText("X");
                break;

            case CROSS:  content.setText("O");
                         break;

            default:     //do nothing
                         break;
        }
    }



}
