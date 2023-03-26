package com.bielecki.BinanceBot.repository;

import com.bielecki.BinanceBot.entity.PriceHist;
import com.bielecki.BinanceBot.entity.SellBuyChance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellBuyChanceCRUDRepository extends CrudRepository<SellBuyChance,Long> {

    List<SellBuyChance> findAll();
    <S extends PriceHist> S save(S entity);


}
