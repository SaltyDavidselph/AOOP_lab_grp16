/*
* 10. Create interface IntChessBoard with signature Boolean verifyCoordinate( X: LocationX, int Y)
* that verifies that the coordinates (X: LocationX, int Y) are within the chess board.
*
* << packages >>
12. Create a package for all classes and interfaces related to chess figures (make sure the first line of all your classes has the name of the package)
Note: you may have to create a package for the interfaces first so you can import it when your classes implement these interfaces. You may have to play with these and do some experiments
*
* */
package lab2.AOOP_lab_grp16.src.Interfaces;

public interface IntChessBoard{
    public boolean verifyCoordinate(char corX, int y);
}
