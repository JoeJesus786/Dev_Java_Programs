package com.touristdestinations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.touristdestinations.model.TouristDestinationModel;

@Repository
public interface TouristDestinationRepository extends JpaRepository<TouristDestinationModel, Long>{

}
