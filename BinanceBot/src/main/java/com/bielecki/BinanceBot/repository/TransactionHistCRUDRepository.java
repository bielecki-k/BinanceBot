package com.bielecki.BinanceBot.repository;

import com.bielecki.BinanceBot.entity.PriceHist;
import com.bielecki.BinanceBot.entity.TransactionHist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionHistCRUDRepository extends CrudRepository<TransactionHist,Long> {

    List<TransactionHist> findAll();
    <S extends TransactionHist> S save(S entity);
    @Query(value="select * from transaction_hist where is_active = 1",nativeQuery = true)
    List<TransactionHist> getActive();


}
