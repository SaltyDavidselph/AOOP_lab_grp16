/*
* 5. Create classes “Pawn”, “RooK”, and “Knigth”  that extend abstract class Figure.
* Also override method "String toString()" so you will be aple to print your chess pieces classes.
*/

package Classes;

public class Pawn extends ChessPiece {
    public Pawn(PieceName name, Colors color, Column corX, Row y){
        super(name, color, corX, y);
    }

    //Needs implementation
    public boolean moveTo(int inX, int inY){
        if(this.xCord != inX ||  (inY - this.yCord) > 1 || (inY - this.yCord) < 1 || checkForSameness(inX, inY)) {
            return false;
        }
        else {
            return true;
        }
    }
}
