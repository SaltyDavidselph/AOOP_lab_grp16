/*
* 5. Create classes “Pawn”, “RooK”, and “Knigth”  that extend abstract class Figure.
* Also override method "String toString()" so you will be aple to print your chess pieces classes.
*/

package lab2.AOOP_lab_grp16.src.Classes;

public class Pawn extends ChessPiece {
    public Pawn(PieceName name, Color color, Column corX, Row y){
        super(name, color, corX, y);
    }

    //Needs implementation
    public boolean moveTo(int corX, int y){
        return true;
    }
    
    @Override
    public String toString(){
        return "";
    }
}
