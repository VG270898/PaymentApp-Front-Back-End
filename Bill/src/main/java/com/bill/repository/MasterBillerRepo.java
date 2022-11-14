package com.bill.repository;

import com.bill.model.MasterBillers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterBillerRepo extends JpaRepository<MasterBillers,String> {
}
