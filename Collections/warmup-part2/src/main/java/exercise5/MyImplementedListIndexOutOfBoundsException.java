package exercise5;

/**
 * Created by Milan.Stojiljkovic on 7/5/2017.
 */
public class MyImplementedListIndexOutOfBoundsException extends ArrayIndexOutOfBoundsException {
    public MyImplementedListIndexOutOfBoundsException() {
        super();
    }

    public MyImplementedListIndexOutOfBoundsException(String s) {
        super(s);
    }
}
