package edu.tzyaps.service.impl;


import edu.tzyaps.util.enums.FileType;

/**
 * Created by Max on 13.10.2016.
 */
public class ImageFileService extends FileServiceImpl {

    public ImageFileService() {
        super("/images/", "img([\\d]+).*", FileType.IMAGE);
    }
}
