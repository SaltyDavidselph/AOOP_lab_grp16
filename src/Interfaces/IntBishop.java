/*
* 6. Create interface “IntBishop” which is not related to IntFigure and defines method moveToBishop
create a class Bishop that implements your interface
*
* << packages >>
12. Create a package for all classes and interfaces related to chess figures (make sure the first line of all your classes has the name of the package)
Note: you may have to create a package for the interfaces first so you can import it when your classes implement these interfaces. You may have to play with these and do some experiments
*
*/
package Interfaces;

public interface IntBishop  {
    boolean moveToBishop(int x, int y);
}