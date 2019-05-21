package model;

/**
 * Exception class thrown when trying to read an Unidentified map Element
 */
public class IllegalGameElement extends Exception {

    /**
     * Constructs a IllegalGameElement object.
     * @param message the error message.
     */
    public IllegalGameElement(String message) {
        super(message);
    }
}
