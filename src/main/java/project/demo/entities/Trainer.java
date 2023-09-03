package project.demo.entities;

public class Trainer {
	private int trainerId;
	private String trainerName;
	private String qualification;
	private String trainerDescription;
	private int year_of_exp;
	private String phone;

	public Trainer() {
		super();
	}

	public Trainer(int trainerId, String trainerName, String qualification, String trainerDescription, int year_of_exp,
			String phone) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.qualification = qualification;
		this.trainerDescription = trainerDescription;
		this.year_of_exp = year_of_exp;
		this.phone = phone;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getTrainerDescription() {
		return trainerDescription;
	}

	public void setTrainerDescription(String trainerDescription) {
		this.trainerDescription = trainerDescription;
	}

	public int getYear_of_exp() {
		return year_of_exp;
	}

	public void setYear_of_exp(int year_of_exp) {
		this.year_of_exp = year_of_exp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "\n Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", qualification="
				+ qualification + ", trainerDescription=" + trainerDescription + ", year_of_exp=" + year_of_exp
				+ ", phone=" + phone + "]";
	}

}