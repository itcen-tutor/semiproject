package org.example.semiproject.gallery.service;

import org.example.semiproject.gallery.dto.GalleryDTO;
import org.example.semiproject.gallery.entity.Gallery;
import org.example.semiproject.gallery.entity.GalleryImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalleryService {
    
    boolean newGalleryImage(Gallery gal, List<MultipartFile> ginames);
    List<GalleryDTO> readGallery();

    Gallery readOneGallery(int ggno);
    List<GalleryImage> readOneGalleryImg(int ggno);

    Gallery readOneGallery2(int ggno);
}
