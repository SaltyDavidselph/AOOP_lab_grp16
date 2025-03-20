/*
* 7. Create class Queen which extends Rook and implements IntBishop. First, provide an  implementation of moveToBishop method.
* When overriding moveTo method in Queen, make use of Rook's moveTo method and moveToBishop implementation
*
* 8. When overriding moveTo method in Queen, make use of Rook's moveTo implementation and
*/

package Classes;
import Interfaces.IntBishop;

public class Queen extends Rook implements IntBishop{

    public Queen(PieceName pieceName, Color color, Column column, Row row){
        super(pieceName, color, column, row);
    }

    @Override
    public boolean moveToBishop(int inX, int inY) {
        if(Math.abs(this.xCord - inX) != Math.abs(this.yCord - inY)){
            // if the new cord are both changed the same amount on the x androw it is an invalid move
            return false;
        }else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }

    @Override
    public boolean moveTo(int inX, int inY){
        if( moveToBishop(inX,inY) ){
            return false;
        } else if (super.moveTo(inX,inY)){
            return false;
        }
        else{
            return true;
        }
    }
}
