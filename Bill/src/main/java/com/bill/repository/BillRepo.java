package com.bill.repository;

import com.bill.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BillRepo extends JpaRepository<Bills,Integer> {
    List<Bills> findByConsumerNumber(Long consumerNumber);
    Bills findByBillSequenceId(int billSequenceId);
    @Query("SELECT u FROM Bills u WHERE u.consumerNumber IN :consumerNumber")
    List<Bills> findBillsByConsumerNumber(@Param("consumerNumber") Collection<Long> consumerNumber);

}
