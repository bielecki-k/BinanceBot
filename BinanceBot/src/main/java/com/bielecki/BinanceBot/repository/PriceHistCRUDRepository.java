package com.bielecki.BinanceBot.repository;

import com.bielecki.BinanceBot.entity.PriceHist;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface PriceHistCRUDRepository extends CrudRepository<PriceHist,Long> {
//
//    @Query("select p from PriceHist")
    List<PriceHist> findAll();

    <S extends PriceHist> S save(S entity);

    List<PriceHist> findPriceBycurencyName(String curencyName);

//    List<PriceHist> getAll(String lastName);


}
