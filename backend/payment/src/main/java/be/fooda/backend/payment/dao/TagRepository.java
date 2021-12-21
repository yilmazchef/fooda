package be.fooda.backend.payment.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import be.fooda.backend.payment.model.entity.TagEntity;

public interface TagRepository extends JpaRepository<TagEntity, Long> {


}
