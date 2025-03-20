/*
 * 5. Create classes “Pawn”, “RooK”, and “Knigth”  that extend abstract class Figure.
 * Also override method "String toString()" so you will be aple to print your chess pieces classes.
 */

package Classes;

public class Knight extends ChessPiece {

    public Knight(PieceName name, Color color, Column corX, Row y){
        super(name, color, corX, y);
    }

    //Needs implementation
    public boolean moveTo(int inX, int inY){
        if (!(((Math.abs(this.xCord - inX ) == 1)&&(Math.abs(this.yCord-inY) == 2))||((Math.abs(this.xCord-inX) == 2)&&(Math.abs(this.yCord-inY) == 1)))){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString(){
        return "";
    }
}
