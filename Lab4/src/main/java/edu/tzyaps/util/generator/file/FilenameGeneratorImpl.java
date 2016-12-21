package edu.tzyaps.util.generator.file;

import edu.tzyaps.util.enums.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Max on 21.12.2016.
 */
public class FilenameGeneratorImpl implements FilenameGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilenameGeneratorImpl.class);

    /**
     * Generate filename file prefix + max filename index
     *
     * @param fileFolder the folder where the file will be saved
     * @return filename
     */
    @Override
    public String generateFilename(File fileFolder, FileType fileType, String strPattern) {
        return fileType.getFilePrefix() + getMaxFileIndex(fileFolder.listFiles(), strPattern) + 1;
    }

    /**
     * Find max index in filename, who's match with pattern
     *
     * @param files files in folder
     * @return max index in filename
     */
    private int getMaxFileIndex(File[] files, String strPattern) {
        int maxFileIndex = 0;

        if (files == null)
            return -1;
        else if (files.length < 1)
            return -1;

        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher;


        for (File file : files) {
            matcher = pattern.matcher(file.getName());
            int currentFileIndex = 0;
            try {
                currentFileIndex = optionalParseInt(matcher, matcher.groupCount());
            } catch (IllegalArgumentException e) {
                LOGGER.error("{} not a number", matcher.groupCount() - 1);
            }
            if (currentFileIndex > maxFileIndex)
                maxFileIndex = currentFileIndex;
        }

        return maxFileIndex;
    }

    /**
     * If filename match with pattern get index of file.
     *
     * @param matcher
     * @param groupIndex
     * @return index of file
     */
    private Integer optionalParseInt(Matcher matcher, int groupIndex) {
        boolean isMatches = matcher.matches();
        if (!isMatches) {
            LOGGER.warn("File name {} don't match with pattern", matcher.pattern().pattern());
            throw new IllegalArgumentException("File name " + matcher.pattern().pattern() + " don't match with pattern");
        }
        String id = matcher.group(groupIndex);
        if (id.equals(""))
            throw new IllegalArgumentException("Empty group");

        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            LOGGER.error("Can't parse number \n Cause: {}", e.getMessage());
            throw new IllegalArgumentException("Not a number: " + id);
        }
    }
}
