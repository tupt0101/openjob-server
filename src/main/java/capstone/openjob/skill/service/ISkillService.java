package capstone.openjob.skill.service;

import capstone.openjob.entity.CategoryEntity;
import capstone.openjob.entity.SkillEntity;

import java.util.List;

public interface ISkillService {
    SkillEntity createSkill(SkillEntity skillEntity);
    SkillEntity updateSkill(SkillEntity skillEntity);
    List<SkillEntity> getAllSkill();
    SkillEntity getSkillById(int id);
}
