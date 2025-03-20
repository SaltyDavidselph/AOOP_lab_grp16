/*
* 9. Create class king which extends Queen
 */

package Classes;

public class King extends Queen{
    public King(PieceName pieceName, Color color ,Column column, Row row){
        super(PieceName.KING, color, column, row);
    }

    @Override
    public boolean moveTo(int inX, int inY){
        if(Math.abs(this.xCord - inX) > 1 || Math.abs(this.yCord - inY) > 1){
            return false;
        }
        else{
            return true;
        }
    }
}