package edu.tzyaps.service.impl;

import edu.tzyaps.util.enums.FileType;
import org.springframework.stereotype.Service;

@Service("imageFileService")
public class ImageFileService extends FileServiceImpl {

    public ImageFileService() {
        super("/images/", "img([\\d]+).*", FileType.IMAGE);
    }
}
