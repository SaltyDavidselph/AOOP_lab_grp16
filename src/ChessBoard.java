//AUTHORS - Angel Torres

public class ChessBoard{
    private static int MAX_ROW = 8;
    private static int MIN_ROW = 1;
    private static char MAX_COL = 'h';
    private static char MIN_COL = 'a';
    ChessBoard(){

    }
/**
 * checks weather given column and row are within the chessboard
 * @param column 
 * @param row
 * @return
 */
    public boolean withinChessboard(char column, int row){
        if((column > MAX_COL)||(column < MIN_COL)){
            return false;
        }
        if((row > MAX_ROW)||(row < MIN_ROW)){
            return false;
        }
        return true;
    } 
}