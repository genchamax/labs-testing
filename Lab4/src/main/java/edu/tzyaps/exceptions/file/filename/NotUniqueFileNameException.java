package edu.tzyaps.exceptions.file.filename;

/**
 * Created by Max on 16.11.2016.
 */
public class NotUniqueFileNameException extends IllegalArgumentException {
    public NotUniqueFileNameException() {
        super();
    }

    public NotUniqueFileNameException(String s) {
        super(s);
    }
}
