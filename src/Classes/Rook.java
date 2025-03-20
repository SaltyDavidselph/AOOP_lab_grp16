/*
 * 5. Create classes “Pawn”, “RooK”, and “Knigth”  that extend abstract class Figure.
 * Also override method "String toString()" so you will be aple to print your chess pieces classes.
 */

package Classes;

public class Rook extends ChessPiece {

    public Rook(PieceName name, Color color, Column corX, Row y){
        super(name, color, corX, y);
    }

    //Needs implementation
    public boolean moveTo(int inX, int inY){
        if (Math.abs((this.xCord - inX)) > 0 && Math.abs((this.yCord - inY )) > 0 || checkForSameness(inX, inY)){
            // if the new cords are not in both the x and y plane it is an invalid move
            return false;
        }else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }
}
