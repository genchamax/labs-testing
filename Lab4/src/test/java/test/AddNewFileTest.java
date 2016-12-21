package test;

import edu.tzyaps.exceptions.file.filename.NotAcceptedExtensionException;
import edu.tzyaps.service.impl.FileServiceImpl;
import edu.tzyaps.service.impl.ImageFileService;
import edu.tzyaps.util.enums.FileType;
import edu.tzyaps.util.generator.file.FilenameGenerator;
import edu.tzyaps.util.generator.file.FilenameGeneratorImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;
import stub.MultipartFileStub;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddNewFileTest {
    private static final String ROOT
            = "D:\\GoogleDrive\\KPI\\7 семестр\\ТЗЯПС\\Labs\\Lab4\\target\\lab-4-1.0-SNAPSHOT\\";

    private static final String FILENAME = "someFileName.jpg";
    private static final String FILENAME_EXTENSION = "jpg";

    private MultipartFile testFile = new MultipartFileStub(FILENAME, ROOT);
    private FileServiceImpl imageService = new ImageFileService();
    private FilenameGenerator filenameGenerator = new FilenameGeneratorImpl();

    @After
    public void deleteTestFile() {
        imageService.deleteFile(FILENAME, ROOT);
    }

    @Test(expected = NotAcceptedExtensionException.class)
    public void badExtensionTest() {
        imageService.saveFile(testFile, new String[]{"bad" + FILENAME_EXTENSION}, ROOT, filenameGenerator);
    }

    @Test
    public void uniqueFilenameTest() {
        imageService.saveFile(testFile, new String[]{FILENAME_EXTENSION}, ROOT, filenameGenerator);
        Assert.assertEquals(true, isFileWithFilenameExistInFolder(FILENAME, ROOT));
    }

    @Test
    public void notUniqueFilenameTest() {
        imageService.saveFile(testFile, new String[]{FILENAME_EXTENSION}, ROOT, filenameGenerator);

        FilenameGenerator testFilenameGenerator = mock(FilenameGenerator.class);
        when(testFilenameGenerator.generateFilename(new File(ROOT + "/resources/images/")
                , FileType.IMAGE, "img([\\d]+).*"))
                .thenReturn("imgGen");

        if (isFileWithFilenameExistInFolder("imgGen" + "." + FILENAME_EXTENSION, ROOT))
            imageService.deleteFile("imgGen" + "." + FILENAME_EXTENSION, ROOT);

        imageService.saveFile(testFile, new String[]{FILENAME_EXTENSION}, ROOT, testFilenameGenerator);

        Assert.assertEquals(true, isFileWithFilenameExistInFolder("imgGen" + "." + FILENAME_EXTENSION, ROOT));

    }

    @Test
    public void successfulFileWriteExample() {
        imageService.saveFile(testFile, new String[]{FILENAME_EXTENSION}, ROOT, filenameGenerator);
        Assert.assertEquals(true, isFileWithFilenameExistInFolder(FILENAME, ROOT));
    }

    private boolean isFileWithFilenameExistInFolder(String fileName, String root) {
        File folder = new File(root + "/resources/images/");
        for (File file : folder.listFiles()) {
            if (fileName.equalsIgnoreCase(file.getName()))
                return true;
        }

        return false;
    }
}
