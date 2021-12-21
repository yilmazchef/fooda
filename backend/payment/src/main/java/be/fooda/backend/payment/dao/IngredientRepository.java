package be.fooda.backend.payment.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import be.fooda.backend.payment.model.entity.IngredientEntity;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {


}
