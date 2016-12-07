package edu.tzyaps.util.enums;

/**
 * Created by Max on 16.10.2016.
 */
public enum FileType {

    IMAGE("img"),
    VIDEO("vid"),
    DOCUMENT("doc"),
    MUSIC("mus"),
    PHOTO("ph"),
    FLASH_DOCUMENT("flash_doc");

    private String filePrefix;

    private FileType(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    public String getFilePrefix() {
        return filePrefix;
    }

}
