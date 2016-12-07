package edu.tzyaps.exceptions.file.filename;

/**
 * Created by Max on 16.11.2016.
 */
public class EmptyFileNameException extends IllegalArgumentException {

    public EmptyFileNameException() {
        super();
    }

    public EmptyFileNameException(String s) {
        super(s);
    }
}
