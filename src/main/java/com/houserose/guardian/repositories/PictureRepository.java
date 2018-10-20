package com.houserose.guardian.repositories;

import com.houserose.guardian.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PictureRepository extends JpaRepository<Picture, UUID> {

}
