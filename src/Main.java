import java.io.IOException;
import java.util.Scanner;

/*LAB2 Project. AUTHORS - David Selph, Angel Torres & Rafael Carmona
 * Description of program.
 *  - Validate user's input about the movement of a chess piece (in this case, official chess rules are not applicable) through the use
 * of methods, objects and javas functionality.
 */

public class Main {
    public static void main(String[] args) throws IOException{      //added IOexeption

    }

    enum chess_type{
        PAWN,ROOK,KNIGHT,BISHOP,QUEEN,KING
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
