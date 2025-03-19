/*
* 6. Create interface “IntBishop” which is not related to IntFigure and defines method moveToBishop
create a class Bishop that implements your interface
*/

package Classes;
import Interfaces.*;

public class Bishop extends ChessPiece implements IntBishop, IntFigure {

    protected PieceName name;
    protected Color color;
    protected Column corX;
    protected Row y;
    protected int xCoord;
    protected int yCoord;

    //Empty/Default constructor
    public Bishop() {
        this.name = null;
        this.color = null;
        this.corX = null;
        this.y = null;
    }

    public Bishop(PieceName name, Color color, Column corX, Row row){
        this.name = name;
        this.color = color;
        this.corX = corX;
        this.y = row;
        this.xCoord = letterToNumber(corX);
        this.yCoord = row.getValue();
    }

    //Author:David Selph
    //Takes the input from the user that corresponds to the x coordinate as a parameter
    //Convert the letter corresponding to the x position into an integer value
    public static int letterToNumber(Column letter) {
        return switch (letter){
            case A-> 1;
            case B -> 2;
            case C -> 3;
            case D -> 4;
            case E -> 5;
            case F -> 6;
            case G -> 7;
            case H -> 8;
            default -> throw new IllegalStateException("Value not on the x-asis of the chess board: " + letter);
        };
    }


    //Setters
    public void setName(PieceName name){
        this.name = name;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setColumn(Column corX){
        this.corX  = corX;
    }

    public void setRow(Row row){
        this.y = row;
    }


    //Getters
    public PieceName getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Column getColumn() {
        return corX;
    }

    public Row getRow() {
        return y;
    }


    @Override
    public boolean moveToBishop(int corX, int y){
        if(Math.abs(this.xCoord - corX) != Math.abs(this.yCoord - y)){
            // if the new cord are both changed the same amount on the x and y it is an invalid move
            return false;
        }else {
            //nothing caught it to say it can not do it so it can
            return true;
        }
    }

    @Override
    public boolean moveTo(int corX, int y) {
        return false;
    }
}
