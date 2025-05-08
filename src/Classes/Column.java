/**
 * 2. Create a public enum type for the
 * X Coordinate a, b, c, d, ..., h (e.g., LocationX) and save it in a separate file.
 */

package Classes;
public enum Column{
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);
    private int value;
    Column(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
