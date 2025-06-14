package org.example.semiproject.gallery.service;

import org.example.semiproject.gallery.entity.Gallery;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalleryService {
    
    boolean newGalleryImage(Gallery gal, List<MultipartFile> ginames);
}
