//AUTHORS - Rafael Carmona & David Selph

public abstract class ChessPiece {
    PieceType name;
    Color color;
    protected Column y;
    protected Row x;
    
    //Default/Empty constructor
    public ChessPiece(){
        name = null;
        color = null;
        y = null;
        x = null;
    }

    //Constructor 
    public ChessPiece(PieceType pieceName, Color color, Column column, Row row){
        this.name = pieceName;
        this.color = color;
        this.y = column;
        this.x = row;
    }

    //Getters 
    public Color getColor(){
        return color;
    }
    
    public Column getColumn(){
        return y;
    }
    public Row getRow(){
        return x;
    }
    public PieceType getName(){
        return name;
    }

    //Setters
    public void setColor(Color color){
        this.color = color;
    }
    
    public void setName(PieceType name){
       this.name = name;
    }
    public void setColumn(Column column){
       y = column;
    }
    public void setRow(Row row){
       x = row;
    }

     /*This abstract method functionality is defined on each piece class, by specifying the purpose of
     each "instance" for a specific piece. For example, utilizing this method for the PAWN, the body of 
     the method would have how the pawn movement is checked or validated. Make a note that each piece class
     needs to override this method. Therefore all pieces will use inheritance to obtain this method.
     */
     abstract boolean verify_movement(int newY, int newX);
    
}
