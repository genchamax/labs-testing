package edu.tzyaps.util.generator.file;

import edu.tzyaps.util.enums.FileType;

import java.io.File;

/**
 * Created by Max on 09.12.2016.
 */
public interface FilenameGenerator {
    String generateFilename(File fileFolder, FileType fileType, String strPattern);
}
