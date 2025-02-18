public abstract class ChessPiece {
    protected PieceType name;
    protected Color color;
    protected Column y;
    protected int x;
    
    //Default/Empty constructor
    public ChessPiece(){
        name = null;
        color = null;
        y = null;
        x = -1;
    }

    //Constructor 
    public ChessPiece(PieceType pieceName, Color color, Column column, int row){
        this.name = pieceName;
        this.color = color;
        y = column;
        x = row;
    }

    //Getters 
    public Color getColor(){
        return color;
    }
    
    public Column getColumn(){
        return y;
    }
    public int getRow(){
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
    public void setRow(int row){
       x = row;
    }

     /*This abstract method functionality is defined on each piece class, by specifying the purpose of
     each "instance" for a specific piece. For example, utilizing this method for the PAWN, the body of 
     the method would have how the pawn movement is checked or validated. Make a note that each piece class
     needs to override this method. Therefore all pieces will use inheritance to obtain this method.
     */
     public abstract boolean verify_movement(int newY, int newX){}
    
}
