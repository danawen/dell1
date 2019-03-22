package springapp.domain;
import java.util.Date;

public class Appointment {
	private final Integer id;
	private java.util.Date apptDateTime;
	private final Integer clientId;
	private final Integer petId;
	private Enum apptReason;
	private String comments;
	private Boolean scheduleComplete;
	
	public Appointment(Integer myID, Integer myClient, Integer myPet ){
		
		this.id = myID;
		this.clientId = myClient;
		this.petId = myPet;
		
	}

	public java.util.Date getApptDateTime() {
		return apptDateTime;
	}

	public void setApptDateTime(java.util.Date apptDateTime) {
		this.apptDateTime = apptDateTime;
	}

	public Enum getApptReason() {
		return apptReason;
	}

	public void setApptReason(Enum apptReason) {
		this.apptReason = apptReason;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getScheduleComplete() {
		return scheduleComplete;
	}

	public void setScheduleComplete(Boolean scheduleComplete) {
		this.scheduleComplete = scheduleComplete;
	}

	public Integer getId() {
		return id;
	}

	public Integer getClientId() {
		return clientId;
	}
	public Integer getPetId() {
		return petId;
	}



	
	

	
}
