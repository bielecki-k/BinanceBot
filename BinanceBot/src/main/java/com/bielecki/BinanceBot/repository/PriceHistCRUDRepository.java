package com.bielecki.BinanceBot.repository;

import com.bielecki.BinanceBot.entity.PriceHist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceHistCRUDRepository extends CrudRepository<PriceHist,Long> { //todo remove me from DB

    List<PriceHist> findAll();
    <S extends PriceHist> S save(S entity);
    List<PriceHist> findPriceByCurrencyName(String currencyName);


}
