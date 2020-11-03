package capstone.openjob.skill.service;

import capstone.openjob.dao.ISkillRepository;
import capstone.openjob.entity.SkillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkillService{

    @Autowired
    private ISkillRepository ISkillRepository;

    @Override
    public SkillEntity createSkill(SkillEntity skillEntity) {
        return ISkillRepository.save(skillEntity);
    }

    @Override
    public SkillEntity updateSkill(SkillEntity skillEntity) {
        return ISkillRepository.save(skillEntity);
    }

    @Override
    public List<SkillEntity> getAllSkill() {
        return ISkillRepository.findAll();
    }

    @Override
    public SkillEntity getSkillById(int id) {
        if (ISkillRepository.findById(id).isPresent()) {
            return ISkillRepository.findById(id).get();
        } else return null;
    }
}
