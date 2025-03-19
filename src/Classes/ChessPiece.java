/*
* 4. Create an abstract class Figure that partially implements IntFigure (provides the fields and constructors to initialize its values,
* but does not implement method moveTo.
*/

package Classes;
import Interfaces.*;


public abstract class ChessPiece implements IntFigure{
    PieceName name;
    Color color;
    Column corX;
    Row y;

    //Empty/Default constructor
    public ChessPiece(){
        this.name = null;
        this.color = null;
        this.corX = null;
        this.y = null;
    }

    //Constructor with values
    public ChessPiece(PieceName name, Color color, Column corX, Row y){
        this.name = name;
        this.color = color;
        this.corX = corX;
        this.y = y;
    }

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
//
//    //Getters
    public PieceName getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }

    public Column getColumn(){
        return corX;
    }

    public Row getRow(){
        return y;
    }
}