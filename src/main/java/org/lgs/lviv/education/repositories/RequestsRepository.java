package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Request, Integer> {
    List<Request> findByUserId(int userId);

    List<Request> findAllByStatus(String status);

    @Modifying
    @Transactional
    @Query("UPDATE Request r SET r.status = :status WHERE r.id = :id")
    void setStatusById(@Param("id") int id, @Param("status") String status);
}
