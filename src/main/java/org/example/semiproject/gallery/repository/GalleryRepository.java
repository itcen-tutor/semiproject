package org.example.semiproject.gallery.repository;

import java.util.List;
import java.util.Optional;

import org.example.semiproject.gallery.dto.GalleryDTO;
import org.example.semiproject.gallery.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

	@Query(value = "select ggno, title, userid, regdate, simgname from gallerys order by ggno desc", nativeQuery = true)
    List<GalleryDTO> selectGallery();

    @Query(value = "select * from gallerys where ggno = :ggno",
         nativeQuery = true)
    Gallery selectOneGallery(int ggno);
    //Gallery findByGgno(int ggno);
    
    @Query("SELECT g FROM Gallery g LEFT JOIN FETCH g.images WHERE g.ggno = :ggno")
    public Optional<Gallery> findGalleryWithImagesByGgno(@Param("ggno") Long ggno);

}
