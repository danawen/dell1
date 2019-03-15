package springapp.command;

import springapp.domain.Client;

/**
 * This command class is used to pass information back and force between the client and the server
 * 
 */
public class AppointmentCommand {
	
	private final Integer id;
	private java.util.Date apptDateTime;
	private final Integer clientId;
	private final Integer petId;
	private Enum apptReason;
	private String comments;
	private Boolean scheduleComplete; 

	/**
	 * Creates a command object that has the initial values the same as the appointment passed in
	 * @param client the client to initialize the command object with
	 */
	public AppointmentCommand(Appointment appointment) {
		if(appointment != null) {
			this.id = appointment.id;
			this.apptDateTime = appointment.getApptDateTime;
			this.clientID = appointment.clientId;
			this.petID = appointment.petID;
			this.apptReason = appointment.getApptReason();
			this.comments = appointment.getComments();
			this.scheduleComplete = appointment.getScheduleComplete();
		}
	}

	/**
	 * Set the id of the appt
	 * @param id the appt id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Set the appt date time of the client
	 * @param apptDateTime is the date and time of the appt
	 */
	public void setApptDateTime(java.util.Date apptDateTime) {
		this.apptDateTime= apptDateTime;
	}

	/**
	 * Set the client id
	 * @param client id is the id of the client
	 */
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
	
	/**
	 * Set the pet id
	 * @param pet id is the id of the pet
	 */
	public void setPetID(Integer petID) {
		this.petID = petID;
	}
	
	/**
	 * Set the reason for the appt
	 * @param appt reason is 
	 */
	public void setApptReason(Enum apptReason) {
		this.apptReason = apptReason;
	}
	
	/**
	 * Set the reason for the appt
	 * @param appt reason is 
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * Set the reason for the appt
	 * @param appt reason is 
	 */
	public void setScheduleComplete(boolean scheduleComplete) {
		this.scheduleComplete = scheduleComplete;
	}
	
	

	/**
	 * @return the client id, returns null if this client is new and not persisted to the database yet
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name of the client
	 */
	public java.util.Date getApptDateTime() {
		return apptDateTime;
	}

	/**
	 * @return the client address
	 */
	public integer getClientID() {
		return ClientID;
	}

	/**
	 * @return the ID for the pet
	 */
	public integer getPetID() {
		return PetID;
	}
	/**
	 * @return the reason for appt
	 */
	public enum getApptReason() {
		return apptReason;
	}
  
	/**
	 * @return the appt's comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @return true/false if schedule is compplete
	 */
	public String getScheduleComplete() {
		return scheduleComplete;
	}
	
	
}
