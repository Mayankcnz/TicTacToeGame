/**
 * Created by Owner on 27/12/2017.
 */
public class Bucket<E1, E2> {

    private E1 row;
    private E2 col;

    public Bucket(E1 row, E2 col) {

        this.row = row;
        this.col = col;

        }

    public E1 getRow() {
        return row;
    }

    public E2 getCol() {
        return col;
    }

}
