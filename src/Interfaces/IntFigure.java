/*
* 3. Create an interface for the chess figure. Interface “IntFigure” should only include the following method signature:
Boolean moveTo(X: LocationX, int Y).
*
* << packages >>
12. Create a package for all classes and interfaces related to chess figures (make sure the first line of all your classes has the name of the package)
Note: you may have to create a package for the interfaces first so you can import it when your classes implement these interfaces. You may have to play with these and do some experiments
*
*/

package lab2.AOOP_lab_grp16.src.Interfaces;
import lab2.AOOP_lab_grp16.src.Classes.Column;
import lab2.AOOP_lab_grp16.src.Classes.Row;

public interface IntFigure{
    public boolean moveTo(int corX, int y);
}
