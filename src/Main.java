import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        // Executes runnable on AWT dispatch thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // Initialize frame
        JFrame frame = new JFrame("Chess Piece move checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);


        //board parts
        JPanel boardContainerPanel = new JPanel(new GridLayout(8, 8));
        JPanel[][] boardCells = new JPanel[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                //create a 8x8 grid
                JPanel boardCell = new JPanel(new GridLayout());
                // color the parts black is needed
                boolean isWhite = (row + col) % 2 == 0;
                boardCell.setBackground(isWhite ? Color.WHITE : Color.BLACK);
                boardCells[row][col] = boardCell;
                boardContainerPanel.add(boardCell);
            }
        }

        frame.add(boardContainerPanel,BorderLayout.CENTER);

        //North control panel parts; for selecting a piece
        JPanel controlPanelNorth = new JPanel();

        JComboBox<PieceName> pie_selc = new JComboBox<>(PieceName.values());
        JComboBox<Colors> color_selc = new JComboBox<>(Colors.values());
        JComboBox<Row> row_selc_start = new JComboBox<>(Row.values());
        JComboBox<Column> col_selc_start = new JComboBox<>(Column.values());

        controlPanelNorth.add(new JLabel("Piece:"));
        controlPanelNorth.add(pie_selc);
        controlPanelNorth.add(new JLabel("Color:"));
        controlPanelNorth.add(color_selc);
        controlPanelNorth.add(new JLabel("Starting Row:"));
        controlPanelNorth.add(row_selc_start);
        controlPanelNorth.add(new JLabel("Starting Column:"));
        controlPanelNorth.add(col_selc_start);

        frame.add(controlPanelNorth,BorderLayout.NORTH);

        //South Control Panel for selecting the target postion
        JPanel controlPanelSouth = new JPanel();


        JComboBox<Row> row_selc_tar = new JComboBox<>(Row.values());
        JComboBox<Column> col_selc_tar = new JComboBox<>(Column.values());

        controlPanelSouth.add(new JLabel("Target Row:"));
        controlPanelSouth.add(row_selc_tar);
        controlPanelSouth.add(new JLabel("Target Column:"));
        controlPanelSouth.add(col_selc_tar);
        JButton placePiece = new JButton("Place Piece");
        JButton resetPiece = new JButton("Reset Piece");
        JButton movePiece = new JButton("Move Piece");

        controlPanelSouth.add(placePiece);
        controlPanelSouth.add(resetPiece);
        controlPanelSouth.add(movePiece);

        frame.add(controlPanelSouth,BorderLayout.SOUTH);

        frame.setVisible(true);


        AtomicReference<ChessPiece> current_piece = new AtomicReference<>();

        placePiece.addActionListener(e -> {
            clearAll(boardCells);
            ChessPiece piece = setPieceData(pie_selc,color_selc,col_selc_start,row_selc_start);
            current_piece.set(piece);
            String path = "assets/betterArt/" + piece.getColor().getValue() + piece.getName().getValue()+".png";
            placeImage(boardCells,piece.getColumn().getValue()-1,piece.getRow().getValue()-1,path);
        });

        movePiece.addActionListener(e -> {
            Row tar_row = getTarRow(row_selc_tar);
            Column tar_col = getTarColumn(col_selc_tar);
            if(current_piece.get() == null){
                //do nothin
            }
            else if(current_piece.get().moveTo(tar_col.getValue(),tar_row.getValue())) {
                clearAll(boardCells);
                String path = "assets/betterArt/" + current_piece.get().getColor().getValue() + current_piece.get().getName().getValue()+".png";
                placeImage(boardCells,getTarRow(row_selc_tar).getValue()-1,getTarColumn(col_selc_tar).getValue()-1,path);

                ChessPiece new_piece = setPieceData(pie_selc,color_selc,col_selc_tar,row_selc_tar);
                current_piece.set(new_piece);
            }
        });

        resetPiece.addActionListener(e -> {
            clearAll(boardCells);
        });



    }

    private static void clearAll(JPanel[][] boardCells){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boardCells[row][col].removeAll();
                boardCells[row][col].revalidate();
                boardCells[row][col].repaint();
            }
        }
    }

    private static ChessPiece setPieceData(JComboBox<PieceName> jcbPiece, JComboBox<Colors> jcbColor,JComboBox<Column> jcbColumn, JComboBox<Row> jcbRow) {
        PieceName pieceName = (PieceName) jcbPiece.getSelectedItem();
        Colors color = (Colors) jcbColor.getSelectedItem();
        Column column = (Column) jcbColumn.getSelectedItem();
        Row row = (Row) jcbRow.getSelectedItem();
        return switch ((PieceName) jcbPiece.getSelectedItem()) {
            case KNIGHT -> new Knight(pieceName, color, column, row);
            case BISHOP -> new Bishop(pieceName, color, column, row);
            case ROOK -> new Rook(pieceName, color, column, row);
            case QUEEN -> new Queen(pieceName, color, column, row);
            case KING -> new King(pieceName, color, column, row);
            case PAWN -> new Pawn(pieceName, color, column, row);
        };
    }

    private static Column getTarColumn(JComboBox<Column> jcbColumn) {
        return (Column) jcbColumn.getSelectedItem();
    }
    private static Row getTarRow(JComboBox<Row> jcbRow) {
        return (Row) jcbRow.getSelectedItem();
    }

    private static void placeImage(JPanel[][] boardCells, int row, int col, String path) {
        ImageIcon icon = new ImageIcon(path);
        Image scaledImage = icon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        boardCells[row][col].add(imageLabel);
        boardCells[row][col].revalidate();
        boardCells[row][col].repaint();
    }
}




//import java.util.HashSet;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
//
//import Classes.*;
//
//import static Classes.ChessPiece.letterToNumber;
//
///*LAB3 Project. AUTHORS - David Selph
// * Description of program.
// *  -This program prompts the user to enter six chess pieces with their corresponding information (name, color & starting position)
// * to move all the pieces to a designated position (official chess rules dont apply).
// */
//
//public class Main {
//    public static void main(String[] args){
//        //start by running a loop over getuserpieces with the control being check_piece
//
//        boolean all_parts = true;
//        Set<ChessPiece> pieces = new HashSet<ChessPiece>();
//
//        while (all_parts){
//            ChessPiece piece = get_user_chess_piece();
//            pieces.add( piece );
//            //each piece given stored in an array until we have one of each piece
//            if( check_pieces(pieces)){
//                all_parts = false;
//            }else{
//            }
//            System.out.println("Your pieces are:");
//            for(ChessPiece pos : pieces){
//                System.out.println(pos.toString());
//            }
//        }
//
//        System.out.println("Congratulations! You gave one of each piece!! \nOnto where they are gonna move!");
//
//        //once that is done we need to get the target pos
//        Column target_col = get_user_input_target_col();
//        Row target_row = get_user_input_target_row();
//
//        //loop over the array from the inputs and polymorph a chess piece
//        for(ChessPiece piece : pieces){
//            if(piece.moveTo(letterToNumber(target_col),target_row.getValue())){
//                move_succsess(piece,target_col,target_row);
//            }else{
//                move_failure(piece,target_col,target_row);
//            }
//        }
//
//
//
//        System.out.println("Goodbye!");
//    }
//
//
//
//    private static boolean check_pieces(Set<ChessPiece> user_pieces){
//        //this kinda sucks a lot a bit
//        boolean queen = false;
//        boolean king = false;
//        boolean bishop = false;
//        boolean rook = false;
//        boolean pawn = false;
//        boolean knight = false;
//
//        for (ChessPiece piece : user_pieces ){
//            switch (piece.getName()){
//                case QUEEN: {
//                    queen = true;
//                    break;
//                }
//                case KING: {
//                    king = true;
//                    break;
//                }
//                case BISHOP: {
//                    bishop = true;
//                    break;
//                }
//                case ROOK: {
//                    rook = true;
//                    break;
//                }
//                case PAWN: {
//                    pawn = true;
//                    break;
//                }
//                case KNIGHT: {
//                    knight = true;
//                    break;
//                }
//            }
//        }
//
//        return queen && king && bishop && rook && pawn && knight;
//    }
//
//    private static ChessPiece get_user_chess_piece(){
//        PieceName pt = getPiece();
//        Color color = get_color();
//        Column col = get_user_input_starting_col(color,pt);
//        Row row = get_user_input_starting_row(color,pt);
//        while (true) {
//            switch (pt) {
//                case QUEEN: {
//                    return new Queen(PieceName.QUEEN,color, col, row);
//                }
//                case KING: {
//                    return new King(PieceName.KING, color, col, row);
//                }
//                case BISHOP: {
//                    return new Bishop(PieceName.BISHOP, color, col, row);
//                }
//                case ROOK: {
//                    return new Rook(PieceName.ROOK ,color, col, row);
//                }
//                case PAWN: {
//                    return new Pawn(PieceName.PAWN , color, col, row);
//                }
//                case KNIGHT: {
//                    return new Knight( PieceName.KNIGHT,color, col, row);
//                }
//            }
//        }
//    }
//
//
///**
// * get the next string input from user
// * sanitize it with lowercase
// * @return
// */
////Author:Angel Torres
//    public static String get_user_string(String query){
//        System.out.println(query);
//        boolean invalid_string = true;
//        Scanner user_input = new Scanner(System.in);
//        String user_string = "";
//        while(invalid_string){
//            try {
//                user_string = user_input.nextLine();
//                invalid_string = false;
//            } catch (Exception e) {
//            }
//        }
//        return user_string.toLowerCase();
//    }
//    /**
//     * prompts user to enter peice type
//     * @return enum of correct peice
//     * Author: Angel Torres
//     */
//    public static PieceName getPiece( ){
//        String user_input = get_user_string("what piece would you like to test?");
//        while (true) {
//            try {
//                if (user_input.equals("queen")) {
//                    return PieceName.QUEEN;
//                } else if (user_input.equals("king")) {
//                    return PieceName.KING;
//                } else if (user_input.equals("knight")) {
//                    return PieceName.KNIGHT;
//                } else if (user_input.equals("rook")) {
//                    return PieceName.ROOK;
//                } else if (user_input.equals("bishop")) {
//                    return PieceName.BISHOP;
//                } else if (user_input.contains("pawn")) {
//                    return PieceName.PAWN;
//                } else {
//                    user_input = get_user_string("Please Try again with a real chess piece not " + user_input);
//                }
//            } catch (Exception e) {
//                throw new RuntimeException("Not valid input");
//            }
//        }
//    }
//    public static Color get_color(){
//        String input =  get_user_string("Would you like it to be a White or Black Piece?");
//        while(true){
//            switch(input){
//                case "white" -> {
//                    //if the user gave a string of white return the white enum
//                    return Color.WHITE;
//                }
//                case "black" -> {
//                    //if the user gave a string of black return the black enum
//                    return Color.BLACK;
//                }
//                default -> {
//                    //keep going and get another input
//                    input = get_user_string("Please Sir I want a Color... White or Black");
//                }
//            }
//        }
//    }
//    //Author:Angel Torres
//    public static Row get_user_input_starting_row( Color color, PieceName pieceType){
//        String input =  get_user_string("What is the starting Row of this "+ color + " "+ pieceType +"?");
//        return strToRow(input);
//    }
//
//    public static Row get_user_input_target_row( ){
//        String input =  get_user_string("What is the target Row of these chess pieces?");
//        return strToRow(input);
//    }
//
//    private static Row strToRow(String input){
//        while(true){
//            switch(input){
//                case "1" -> {
//                    //if the user gave a string of one return the one enum
//                    return Row.ONE;
//                }
//                case "2" -> {
//                    //if the user gave a string of two return the two enum
//                    return Row.TWO;
//                }
//                case "3" -> {
//                    //if the user gave a string of three return the three enum
//                    return Row.THREE;
//                }
//                case "4" -> {
//                    //if the user gave a string of four return the four enum
//                    return Row.FOUR;
//                }
//                case "5" -> {
//                    //if the user gave a string of five return the five enum
//                    return Row.FIVE;
//                }
//                case "6" -> {
//                    //if the user gave a string of six return the six enum
//                    return Row.SIX;
//                }
//                case "7" -> {
//                    //if the user gave a string of seven return the seven enum
//                    return Row.SEVEN;
//                }
//                case "8" -> {
//                    //if the user gave a string of eight return the eight enum
//                    return Row.EIGHT;
//                }
//                default -> {
//                    //keep going and get another input
//                    input = get_user_string("Please stop this silliness and input a single number 1-8");
//                }
//            }
//        }
//    }
//
//    //Author: Angel Torres
//    public static Column get_user_input_starting_col( Color color, PieceName pieceType){
//        String input =  get_user_string("What is the starting Column of this "+ color + " " + pieceType +"?");
//        return strToCol(input);
//    }
//    public static Column get_user_input_target_col(){
//        String input =  get_user_string("What is the Target Column of this montly crew of chess pieces?");
//        return strToCol(input);
//    }
//
//    private static Column strToCol(String input){
//        while(true){
//            switch(input){
//                case "a" -> {
//                    //if the user gave a string of one return the one enum
//                    return Column.A;
//                }
//                case "b" -> {
//                    //if the user gave a string of two return the two enum
//                    return Column.B;
//                }
//                case "c" -> {
//                    //if the user gave a string of three return the three enum
//                    return Column.C;
//                }
//                case "d" -> {
//                    //if the user gave a string of four return the four enum
//                    return Column.D;
//                }
//                case "e" -> {
//                    //if the user gave a string of five return the five enum
//                    return Column.E;
//                }
//                case "f" -> {
//                    //if the user gave a string of six return the six enum
//                    return Column.F;
//                }
//                case "g" -> {
//                    //if the user gave a string of seven return the seven enum
//                    return Column.G;
//                }
//                case "h" -> {
//                    //if the user gave a string of eight return the eight enum
//                    return Column.H;
//                }
//                default -> {
//                    //keep going and get another input
//                    input = get_user_string("Please stop this silliness and input a letter a-h");
//                }
//            }
//        }
//    }
//
//    //helper methods to reduce bulk
//    /**
//     * Print a messge that the desired move is possible
//     * Author: Angel Torres, David Selph
//     */
//    public static void move_succsess(ChessPiece chessPiece, Column x_end, Row y_end){
//        System.out.println( chessPiece +" CAN move to (" + x_end + "," + y_end.getValue() + ")"  );
//    }
//    /**
//     * Print a messge that the desired move is NOT possible
//     * Author: Angel Torres, David Selph
//     */
//    public static void move_failure(ChessPiece chessPiece,  Column x_end, Row y_end){
//        System.out.println(chessPiece +" CAN NOT move to (" + x_end + "," + y_end.getValue() + ")"    );
//    }
//}
