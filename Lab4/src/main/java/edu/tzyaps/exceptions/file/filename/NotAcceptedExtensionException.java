package edu.tzyaps.exceptions.file.filename;

/**
 * Created by Max on 16.11.2016.
 */
public class NotAcceptedExtensionException extends IllegalArgumentException {
    public NotAcceptedExtensionException() {
        super();
    }

    public NotAcceptedExtensionException(String s) {
        super(s);
    }
}
