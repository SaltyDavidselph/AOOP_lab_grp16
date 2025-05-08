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
                boardCell.setBackground(isWhite ? Color.WHITE : Color.DARK_GRAY);
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