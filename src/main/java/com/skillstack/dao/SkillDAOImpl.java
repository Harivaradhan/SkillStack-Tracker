package com.skillstack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skillstack.model.Skill;
import com.skillstack.util.DBConnection;

public class SkillDAOImpl implements SkillDAO {

    @Override
    public  void addSkills(Skill skill) {
        String sql = "INSERT INTO skills (skill_name,resource_type,platform,start_date, status, hours_spent, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, skill.getSkillName());
            ps.setString(2, skill.getResourceType());
            ps.setString(3, skill.getPlatform());
            ps.setString(4, skill.getStartDate());
            ps.setString(5, skill.getStatus());
            ps.setInt(6, skill.getHoursSpent());
            ps.setString(7, skill.getNotes());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill getSkillById(int id) {
        Skill skill = null;
        String sql = "SELECT * FROM skills WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setSkillName(rs.getString("skill_name"));
                skill.setResourceType(rs.getString("resource_type"));
                skill.setPlatform(rs.getString("platform"));
                skill.setStartDate(rs.getString("start_date"));
                skill.setStatus(rs.getString("status"));
                skill.setHoursSpent(rs.getInt("hours_spent"));
                skill.setNotes(rs.getString("notes"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public List<Skill> getAllSkills() {
        List<Skill> list = new ArrayList<>();
        String sql = "SELECT * FROM skills";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Skill skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setSkillName(rs.getString("skill_name"));
                skill.setResourceType(rs.getString("resource_type"));
                skill.setPlatform(rs.getString("platform"));
                skill.setStartDate(rs.getString("start_date"));
                skill.setStatus(rs.getString("status"));
                skill.setHoursSpent(rs.getInt("hours_spent"));
                skill.setNotes(rs.getString("notes"));

                list.add(skill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateSkills(Skill skill) {
        String sql = "UPDATE skills SET skill_name=?, resource_type=?, platform=?,start_date=?, status=?, hours_spent=?, notes=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, skill.getSkillName());
            ps.setString(2, skill.getResourceType());
            ps.setString(3, skill.getPlatform());
            ps.setString(4, skill.getStartDate());
            ps.setString(5, skill.getStatus());
            ps.setInt(6, skill.getHoursSpent());
            ps.setString(7, skill.getNotes());
            ps.setInt(8, skill.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSkill(int id) {
        String sql = "DELETE FROM skills WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	

	
}
