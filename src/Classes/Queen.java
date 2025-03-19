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

    public boolean moveToBishop(Column corX, Row y){
        return true;
    }

    @Override
    public boolean moveToBishop(int x, int y) {
        return false;
    }

    @Override
    public boolean moveTo(int corX, int y){
        //Use Rook's moveTo method and moveToBishop method
        return true;
    }

    @Override
    public String toString(){
        return "";
    }
}
