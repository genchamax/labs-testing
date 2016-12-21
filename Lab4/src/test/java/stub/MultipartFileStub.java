package stub;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Max on 21.12.2016.
 */
public class MultipartFileStub implements MultipartFile {

    private String stubOriginalFilename = "";
    private String stubContentType = "";

    public MultipartFileStub(String stubOriginalFilename, String stubContentType) {
        this.stubOriginalFilename = stubOriginalFilename;
        this.stubContentType = stubContentType;
    }

    @Override
    public String getName() {
        return stubOriginalFilename;
    }

    @Override
    public String getOriginalFilename() {
        return stubOriginalFilename;
    }

    @Override
    public String getContentType() {
        return stubContentType;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {

    }
}
