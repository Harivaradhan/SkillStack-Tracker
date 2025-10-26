package com.skillstack.dao;

import java.util.List;

import com.skillstack.model.Skill;

public interface SkillDAO {

	    // Create
	    void addSkills(Skill skill);

	    // Read single
	    Skill getSkillById(int id);

	    // Read all
	    List<Skill> getAllSkills();

	    // Update
	    void updateSkills(Skill skill);

	    // Delete
	    void deleteSkill(int id);
	}

