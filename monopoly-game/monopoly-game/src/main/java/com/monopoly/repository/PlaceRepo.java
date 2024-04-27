package com.monopoly.repository;

import com.monopoly.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<Place,Long> {

    Place findByPlaceDiceValue(int placeDiceValue);
}
