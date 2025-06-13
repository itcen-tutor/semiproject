package org.example.semiproject.gallery.repository;

import org.example.semiproject.gallery.entity.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {

}
