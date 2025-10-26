package com.skillstack.model;

public class Skill {
    private int id;
    private String skillName;
    private String resourceType;
    private String platform;
    private String status;
    private int hoursSpent;
    private String difficulty;
    private String notes;
    private String startDate; 

    //Constructors
    public Skill() {}

    public Skill(int id, String skillName, String resourceType, String platform, String startDate, String status,
                 int hoursSpent, String difficulty, String notes) {
        this.id = id;
        this.skillName = skillName;
        this.resourceType = resourceType;
        this.platform = platform;
        this.startDate = startDate;
        this.status = status;
        this.hoursSpent = hoursSpent;
        this.difficulty = difficulty;
        this.notes = notes;
        
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getHoursSpent() {
        return hoursSpent;
    }
    public void setHoursSpent(int hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

   
}

