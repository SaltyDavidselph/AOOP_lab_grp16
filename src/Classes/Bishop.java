/*
* 6. Create interface “IntBishop” which is not related to IntFigure and defines method moveToBishop
create a class Bishop that implements your interface
*/

package Classes;
import Interfaces.*;

public class Bishop extends ChessPiece implements IntBishop, IntFigure {
    
    //Empty/Default constructor
    public Bishop() {
        this.name = null;
        this.color = null;
        this.column = null;
        this.row = null;
        this.xCord =0;
        this.yCord = 0;
    }

    public Bishop(PieceName name, Color color, Column column, Row row){
        this.name = name;
        this.color = color;
        this.column = column;
        this.row = row;
        this.xCord = letterToNumber(column);
        this.yCord = row.getValue();
    }

    @Override
    public boolean moveToBishop(int column, int y){
        if(Math.abs(this.xCord - column) != Math.abs(this.yCord - y)){
            // if the new cord are both changed the same amount on the x androw it is an invalid move
            return false;
        }else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }

    @Override
    public boolean moveTo(int column, int row) {
        return moveToBishop(column, row);
    }
}
