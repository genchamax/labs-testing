package test;

import edu.tzyaps.service.impl.ImageFileService;
import edu.tzyaps.service.interfaces.FileService;
import edu.tzyaps.util.generator.file.FilenameGeneratorImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;
import stub.MultipartFileStub;

/**
 * Created by Max on 21.12.2016.
 */
public class DeleteFileTest {

    private static final String ROOT
            = "D:\\GoogleDrive\\KPI\\7 семестр\\ТЗЯПС\\Labs\\Lab4\\target\\lab-4-1.0-SNAPSHOT\\";

    private static final String FILENAME = "someFileName.jpg";
    private static final String FILENAME_EXTENSION = "jpg";

    private FileService imageService = new ImageFileService();

    @Before
    public void writeTestFileToPath() {
        MultipartFile testFile = new MultipartFileStub(FILENAME, FILENAME_EXTENSION);
        imageService.saveFile(testFile, new String[]{FILENAME_EXTENSION}, ROOT, new FilenameGeneratorImpl());
    }

    @Test
    public void successfulFileDeleteTest() {
        Assert.assertEquals(true, imageService.deleteFile(FILENAME, ROOT));
    }

    @Test
    public void failureFileDeleteTest() {
        Assert.assertEquals(false, imageService.deleteFile("fake" + FILENAME, ROOT));
    }
}
