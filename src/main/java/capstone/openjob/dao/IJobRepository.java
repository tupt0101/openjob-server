package capstone.openjob.dao;

import capstone.openjob.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IJobRepository extends JpaRepository<JobEntity,Integer> {
    Optional<List<JobEntity>> findAllByStatus(String status);

    Optional<List<JobEntity>> findJobEntitiesByAccountIdEquals(int id);

    @Query(value = "select * from job j " +
            "where j.title like %:search% " +
            "or j.category like %:search% " +
            "or j.skill like %:search% " +
            "or j.location like %:search% " +
            "or j.company_id in (select c.id from company c " +
            "where c.name like %:search% or c.location like %:search%)",
            nativeQuery = true)
    List<JobEntity> searchJob(@Param("search") String search);
}
