import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*LAB1 Project. AUTHORS - David Selph, Angel Torres & Rafael Carmona
 * Description of program.
 *  - Validate user's input about the movement of a chess piece (in this case, official chess rules are not applicable) through the use
 * of methods, objects and javas functionality.
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException{      //added IOexeption

        //This section reads the input file
        //AUTHORS - David Selph, Angel Torres & Rafael Carmona
        String input_path = "input_file.txt";
        
        //testing git commit
        //also testing
        List<String> piece_info = getTextFileInput(input_path);

        int[] inputs =  get_user_inputs();

        List<ChessPiece>  pieces = pieceInfoToChessPiece(piece_info);

        for (ChessPiece piece : pieces) {
            switch (piece.type) {
                case "pawn" -> pawn_movement(piece, inputs);
                case "knight" -> knight_movement(piece, inputs);
                case "bishop" -> bishop_movement(piece, inputs);
                case "rook" -> rook_movement(piece, inputs);
                case "queen" -> queen_movement(piece, inputs);
                case "king" -> king_movement(piece, inputs);
                default -> {
                    //nothing to do if the type of piece is not a known chess piece
                }
            }

        }

    }

    //Object that holds the chess piece information
    public static class ChessPiece {
        public String type;
        public String color;
        public String x_cord_str;
        public String y_cord_str;
        public int x_cord;
        public int y_cord;
    }

    enum chess_type{
        pawn,rook,knight,bishop,queen,king
    }


    //Store the information from the file into a data structure (String Array)
    public static ArrayList getTextFileInput(String fileName) {
        List<String> piece_info = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                piece_info.add(scanner.nextLine().trim().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList(piece_info);
    }

    //Get the users input to move a chess piece, using x and y coordinates as positions. Check for valid input
    public static int[] get_user_inputs(){
        Exception input_err = new Exception("user input not within string length or board size");
        
        boolean invalid_input = true;
        Scanner user_input = new Scanner(System.in);
        String x_movement_str = "";
        while (invalid_input) {
            System.out.println("Enter the Letter for a space on the board: ");
            try {
                x_movement_str = user_input.nextLine().toLowerCase();
                if(x_movement_str.length() >1){         //checking for length is kind of redundant since i only use the first char later anyway
                    throw input_err;
                }else{
                    char []user_input_arr = x_movement_str.toCharArray();
                    if((user_input_arr[0]>'h')||(user_input_arr[0]<'a')){
                        throw input_err;
                    }
                }
                invalid_input = false;      //escape this mortal coil
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("please enter the valid letter for a space within the board");
            }
        }
        invalid_input = true;
        int y_movement_int = 0;
        while(invalid_input){
            System.out.println("Enter the number for a space on the board: ");
            try {
                y_movement_int = user_input.nextInt();
                if((y_movement_int > 8)||(y_movement_int<1)){
                    throw input_err;
                }
                invalid_input = false;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("please enter the valid number for a space within the board");
            }

        }

        return new int[]{letterToNumber(x_movement_str), y_movement_int};     //changed y_movement form string to int
    }

    //Takes the input from the user that corresponds to the x coordinate as a parameter
    //Convert the letter corresponding to the x position into an integer value
    public static int letterToNumber(String letter) {
        return switch (letter){
            case "a" -> 1;
            case "b" -> 2;
            case "c" -> 3;
            case "d" -> 4;
            case "e" -> 5;
            case "f" -> 6;
            case "g" -> 7;
            case "h" -> 8;
            default -> throw new IllegalStateException("Value not on the x-asis of the chess board: " + letter);
        };
    }

    //Takes the "letter to number" conversion from previous method as a parameter and converts it back to its corresponding number
    //Convert back 
    public static char numberToLetter(int number) {
        return switch (number){
            case 1 -> 'a';
            case 2 -> 'b';
            case 3 -> 'c';
            case 4 -> 'd';
            case 5 -> 'e';
            case 6 -> 'f';
            case 7 -> 'g';
            case 8 -> 'h';
            default -> throw new IllegalStateException("Value not on the x-asis of the chess board: " + number);
        };
    }

    //Takes the array list of chess pieces (object) as a paramter and places the information with its correspoding attribute
    public static List<ChessPiece> pieceInfoToChessPiece(List<String> piece_info){
        List<ChessPiece> pieces = new ArrayList<ChessPiece>();
        for(String info : piece_info){
           String[]  split_info = info.split(", ");
            ChessPiece cp = new ChessPiece();
            cp.type = split_info[0];
            cp.color= split_info[1];
            cp.x_cord_str = split_info[2];
            cp.y_cord_str = split_info[3];
            cp.x_cord = switch (split_info[2]) {
                case "a" -> 1;
                case "b" -> 2;
                case "c" -> 3;
                case "d" -> 4;
                case "e" -> 5;
                case "f" -> 6;
                case "g" -> 7;
                case "h" -> 8;
                default -> throw new IllegalStateException("Value not on the x-asis of the chess board: ");
            };
            cp.y_cord = Integer.parseInt(split_info[3]);
           pieces.add(cp);
        }
        return pieces;
    }

     /*Following methods validate the movement of a specific chess piece, taking the information from the object (Chess Piece) and the user's input as 
    parameters.
    */
//    public static void pawn_movement(ChessPiece piece, int[] inputs){
//        if(piece.x_cord != inputs[0] ||  (inputs[1] - piece.y_cord) > 1 || (inputs[1] - piece.y_cord) < 1) {
//            move_failure(piece, inputs);
//        }
//        else {
//            move_succsess(piece, inputs);
//        }
//    }
//
//     //AUTHORS - David Selph
//    public static void rook_movement(ChessPiece piece, int[] inputs){
//        if (Math.abs((piece.x_cord - inputs[0])) > 0 && Math.abs((piece.y_cord - inputs[1] )) > 0){
//            // if the new cords are not in both the x and y plane it is an invalid move
//            move_failure(piece, inputs);
//        }else {
//            //nothing caught it to say it can not do it so it can
//            move_succsess(piece, inputs);
//        }
//    }
//
//    //AUTHORS - David Selph
//    public static void bishop_movement(ChessPiece piece, int[] inputs){
//        if (Math.abs(piece.x_cord-inputs[0]) != Math.abs(piece.y_cord-inputs[1])){
//            // if the new cord are both changed the same amount on the x and y it is an invalid move
//            move_failure(piece, inputs);
//        }else {
//            //nothing caught it to say it can not do it so it can
//            move_succsess(piece, inputs);
//        }
//    }
//
//    //AUTHORS - Angel Torres
//    public static void knight_movement(ChessPiece piece, int[] inputs){
//        if (!(((Math.abs(piece.x_cord-inputs[0]) == 1)&&(Math.abs(piece.y_cord-inputs[1]) == 2))||((Math.abs(piece.x_cord-inputs[0]) == 2)&&(Math.abs(piece.y_cord-inputs[1]) == 1)))){
//            move_failure(piece, inputs);
//            return;
//        }
//        move_succsess(piece, inputs);
//    }
//
//    //AUTHORS - David Selph
//    public static void queen_movement(ChessPiece piece, int[] inputs){
//        if ((Math.abs((piece.x_cord - inputs[0])) > 0 && Math.abs((piece.y_cord - inputs[1] )) > 0) && ((Math.abs(piece.x_cord-inputs[0]) != Math.abs(piece.y_cord-inputs[1])))){
//            //same logic as the rook
//            move_failure(piece, inputs);
//        }
//        else {
//            //nothing caught it to say it can not do it so it can
//            move_succsess(piece, inputs);
//        }
//    }
//
//    //AUTHORS - Rafael Carmona
//    public static void king_movement(ChessPiece piece, int[] inputs){
//        if(Math.abs(piece.x_cord - inputs[0]) > 1 || Math.abs(piece.y_cord - inputs[1]) > 1){
//            move_failure(piece, inputs);
//        }
//        else{
//            move_succsess(piece, inputs);
//
//        }
//    }

    
    //helper methods to reduce bulk
    /**
     * Print a messge that the desired move is possible
     * 
     * @param piece current chess piece
     * @param inputs the desired move
     */
    public static void move_succsess(ChessPiece piece, int[] inputs){
        System.out.println("The "+piece.type+" can move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
    }
    /**
     * Print a messge that the desired move is NOT possible
     * 
     * @param piece current chess piece
     * @param inputs the desired move
     */
    public static void move_failure(ChessPiece piece, int[] inputs){
        System.out.println("The "+piece.type+" can NOT move from (" + piece.x_cord_str +"," + piece.y_cord_str +") to (" + numberToLetter(inputs[0]) + "," + inputs[1] + ")"  );
    }

}
