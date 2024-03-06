package com.example.Bagdar.repositories;
import com.example.Bagdar.entities.Item;
import com.example.Bagdar.entities.QuantityCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QuantityCountRepository extends JpaRepository<QuantityCount, Long> {


}
