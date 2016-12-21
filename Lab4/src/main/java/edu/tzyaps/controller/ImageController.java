package edu.tzyaps.controller;

import edu.tzyaps.service.interfaces.FileService;
import edu.tzyaps.util.generator.file.FilenameGeneratorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("/api/images")
public class ImageController implements ServletContextAware {

    private ServletContext servletContext;

    private final FileService imageFileService;

    @Autowired
    public ImageController(@Qualifier("imageFileService") FileService imageFileService) {
        this.imageFileService = imageFileService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity getAllImage() {
        return ResponseEntity.ok(imageFileService.getFileList(new String[]{"jpg", "jpeg", "png"},
                servletContext.getRealPath("/")));
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity saveImage(@RequestParam("image") MultipartFile image) {
        try {
            imageFileService.saveFile(image, new String[]{"jpg", "jpeg", "png"},
                    servletContext.getRealPath("/"), new FilenameGeneratorImpl());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{imageName:.+}", method = RequestMethod.DELETE)
    public ResponseEntity deleteImage(@PathVariable("imageName") String imageName) {
        try {
            imageFileService.deleteFile(imageName, servletContext.getRealPath("/"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        return ResponseEntity.ok().build();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
