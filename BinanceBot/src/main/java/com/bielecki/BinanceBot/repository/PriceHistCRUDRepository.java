package com.bielecki.BinanceBot.repository;

import com.bielecki.BinanceBot.model.PriceHist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceHistCRUDRepository extends CrudRepository<PriceHist,Long> {
//
//    @Query("select p from PriceHist")
//    List<PriceHist> findAll();

    <S extends PriceHist> S save(S entity);


//    List<PriceHist> getAll(String lastName);


}