package edu.tzyaps.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Max on 13.11.2016.
 */
public interface FileService {

    void saveFile(MultipartFile file, String[] acceptedExtensions, String root);

    void deleteFile(String fileName, String root);

    void renameFile(String oldName, String newName, String root);

    List<String> getFileList(String[] fileExtension, String root);
}
