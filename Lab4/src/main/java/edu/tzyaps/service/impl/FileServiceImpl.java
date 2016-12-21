package edu.tzyaps.service.impl;

import edu.tzyaps.exceptions.file.filename.EmptyFileNameException;
import edu.tzyaps.exceptions.file.filename.NotAcceptedExtensionException;
import edu.tzyaps.exceptions.file.filename.NotUniqueFileNameException;
import edu.tzyaps.service.interfaces.FileService;
import edu.tzyaps.util.enums.FileType;
import edu.tzyaps.util.generator.file.FilenameGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Max on 13.10.2016.
 */
//@Service("basicFileService")
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

    private static final String FILE_PATH = "/resources/";
    private FileType fileType;
    private String contentPath = "";
    private String pattern;

    public FileServiceImpl(String contentPath, String pattern, FileType fileType) {
        this.contentPath = contentPath;
        this.pattern = pattern;
        this.fileType = fileType;
    }

    public FileServiceImpl(String pattern, FileType fileType) {
        this.pattern = pattern;
        this.fileType = fileType;
    }

    public FileServiceImpl() {
    }

    public void saveFile(MultipartFile file, String[] acceptedExtensions, String root, FilenameGenerator filenameGenerator) {

        if (!isExtensionAccepted(file, acceptedExtensions)) {
            LOGGER.error("File {} have not accepted extension. Accepted extensions: {}", file.getName(),
                    Arrays.toString(acceptedExtensions));
            throw new NotAcceptedExtensionException("Not accepted extension");
        }

        String filePath = generateFullFilePath(root, contentPath);
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());

        File fileFolder = createFolder(root + FILE_PATH + contentPath);

        String originalFileName = null;
        try {
            originalFileName = new String(file.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage());
        }

        // if original file name not unique generate unique file name
        String fileNameWithExtension = (isFilenameUnique(originalFileName, fileFolder.getPath())) ? (originalFileName) :
                (filenameGenerator.generateFilename(fileFolder, this.fileType, this.pattern) + "." + fileExtension);


        File newFile = new File(filePath + fileNameWithExtension);

        try {
            FileUtils.writeByteArrayToFile(newFile, file.getBytes());
            LOGGER.info("Write file {}. Path: {} ", newFile.getName(), newFile.getAbsolutePath());
        } catch (IOException e) {
            LOGGER.error("Can't write {} to file {} \n Cause: {}", file.getName(), newFile.getName(), e.getMessage());
            throw new IllegalArgumentException("Can't write file");
        }

    }

    public boolean deleteFile(String fileName, String root) {
        String imagePath = root + FILE_PATH + contentPath + fileName;

        File imageFile = new File(imagePath);

        boolean isDeleted = imageFile.delete();

        if (isDeleted) {
            LOGGER.info("File {} deleted", imageFile.getName());
        } else {
            LOGGER.error("Can't delete file {} .\n Path: {} ", imageFile.getName(), imageFile.getAbsolutePath());
        }

        return isDeleted;
    }

    /**
     * @param oldName old file name with extension
     * @param newName new file name without extension
     * @param root
     */
    public void renameFile(String oldName, String newName, String root) {
        String fileFullPath = generateFullFilePath(root, contentPath);

        String extension = FilenameUtils.getExtension(oldName);

        if (newName.isEmpty()) {
            LOGGER.warn("Filename is empty");
            throw new EmptyFileNameException();
        }

        if (!isFilenameUnique(newName + "." + extension, fileFullPath)) {
            LOGGER.warn("File with name {} already exist.", newName);
            throw new NotUniqueFileNameException("File with name " + newName + " already exist");
        }

        String oldFileFullName = fileFullPath + oldName;
        String newFileFullName = fileFullPath + newName + "." + extension;

        File oldFile = new File(oldFileFullName);
        File newFile = new File(newFileFullName);

        boolean isRenamed = oldFile.renameTo(newFile);

        if (isRenamed) {
            LOGGER.info("Rename {} to {} ", oldFileFullName, newFileFullName);
        } else {
            LOGGER.warn("Can't rename {} to {} ", oldFileFullName, newFileFullName);
            throw new IllegalArgumentException("Can't rename " + oldFileFullName + " to " +
                    newFileFullName);
        }
    }

    @Override
    public List<String> getFileList(String[] fileExtension, String root) {
        List<String> fileList = new ArrayList<>();

        File folder = new File(root + FILE_PATH + this.contentPath);
        File[] filesInFolder = folder.listFiles();

        if (filesInFolder == null)
            return fileList;
        else if (filesInFolder.length < 1)
            return fileList;

        for (File file : filesInFolder) {
            for (String extension : fileExtension) {
                if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase(extension))
                    fileList.add(file.getName());
            }
        }
        return fileList;
    }

    //TODO: Check it
    public String generateFullFilePath(String root, String contentPath) {
        return root + FILE_PATH + contentPath;
    }

    /**
     * Check does filename unique in current folder
     *
     * @param fileName
     * @param filePath current folder
     * @return true if filename unique
     */
    private boolean isFilenameUnique(String fileName, String filePath) {
        File fileFolder = new File(filePath);
        File[] files = fileFolder.listFiles();

        if (files == null)
            return true;
        if (files.length < 1)
            return true;

        for (File file : files) {
            if (!file.isDirectory())
                if (file.getName().equals(fileName))
                    return false;
        }

        return true;
    }

    /**
     * Check if file extension is accepted
     *
     * @param file
     * @param acceptedExtensions array of accepted exception
     * @return true if file extension in list of accepted extensions
     */
    private boolean isExtensionAccepted(MultipartFile file, String[] acceptedExtensions) {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());

        boolean result = false;

        for (String acceptedExtension : acceptedExtensions) {
            result = result || (fileExtension.equalsIgnoreCase(acceptedExtension));
        }

        return result;
    }


    /**
     * Create new folder if it not exist.
     *
     * @param folderName Name of the folder
     * @return new folder (java.io.File);
     */
    private File createFolder(String folderName) {
        File newFolder = new File(folderName);

        if (!newFolder.exists()) {
            boolean isFolderCreated = newFolder.mkdirs();

            if (isFolderCreated) {
                LOGGER.info("Create folder {} ", newFolder.getAbsolutePath());
            } else {
                LOGGER.error("Can't create folder {} ", newFolder.getAbsolutePath());
            }
        } else {
            LOGGER.trace("File {} already exist", newFolder.getAbsolutePath());
        }

        return newFolder;
    }

}
