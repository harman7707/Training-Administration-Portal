package project.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.demo.entities.Trainer;

public class TrainerRowMapperImpl implements RowMapper<Trainer> {
	public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trainer trainer = new Trainer();
		trainer.setTrainerId(rs.getInt("trainerId"));
		trainer.setTrainerName(rs.getString("trainerName"));
		trainer.setQualification(rs.getString("qualification"));
		trainer.setTrainerDescription(rs.getString("trainerDescription"));
		trainer.setYear_of_exp(rs.getInt("year_of_exp"));
		trainer.setPhone(rs.getString("phone"));

		return trainer;
	}

}
