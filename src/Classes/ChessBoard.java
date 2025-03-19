package Classes;
import Interfaces.IntChessBoard;

public class ChessBoard implements IntChessBoard{

    private static int MAX_ROW = 8;
    private static int MIN_ROW = 1;
    private static char MAX_COL = 'h';
    private static char MIN_COL = 'a';
    ChessBoard(){

    }
   //Needs implementation
    @Override
    public boolean verifyCoordinate(char column, int row){
        if((column > MAX_COL)||(column < MIN_COL)){
            return false;
        }
        if((row > MAX_ROW)||(row < MIN_ROW)){
            return false;
        }
        return true;
    }
}
