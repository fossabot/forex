package com.forex.euro.repository;

import com.forex.euro.models.Forex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ForexRepository extends JpaRepository<Forex,String> {
}
