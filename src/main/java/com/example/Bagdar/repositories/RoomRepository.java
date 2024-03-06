package com.example.Bagdar.repositories;
import com.example.Bagdar.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room,Long>{

}
