package org.example.semiproject.gallery.repository;

import java.util.List;

import org.example.semiproject.gallery.entity.GalleryImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {

    @Query(value = "select * from gallery_images where gno = :ggno", nativeQuery = true)
    List<GalleryImage> selectOneGalleryImg(int ggno);

}
