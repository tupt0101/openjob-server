package capstone.openjob.dao;

import capstone.openjob.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<SkillEntity, Integer> {
}
