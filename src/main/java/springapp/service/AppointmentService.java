package springapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springapp.command.AppointmentCommand;
import springapp.command.PetCommand;
import springapp.dao.AppointmentDao;
import springapp.dao.ClientDao;
import springapp.dao.PetDao;
import springapp.domain.Appointment;
import springapp.domain.Client;
import springapp.domain.Pet;


@Service
public class AppointmentService {

	@Autowired 
	AppointmentDao appointmentDao;
	
	@Autowired 
	PetDao petDao;
	
	@Autowired 
	ClientDao clientDao;
	


	public Appointment getAppointment(String id) {
		return appointmentDao.get(Integer.parseInt(id));
	}
	
	public Appointment getAppointment(Integer id) {
		return appointmentDao.get(id);
	}

	//TODO: Delete Appointment


	
	public List<Appointment> getAppointments(){
		return appointmentDao.list();
		
	}
	
	public Appointment saveAppointment(AppointmentCommand command) {
		Appointment newAppointment = new Appointment(command.getId(), command.getPetId(), command.getClientId(), command.getReason(), command.getTime(), command.getDuration(), command.getComments());
		return appointmentDao.save(newAppointment);
	}
	
	
	public Pet getPet(int petId) {
		
		return petDao.get(petId);
	}
	
	
	public Client getClient(int clientId) {
		
		return clientDao.get(clientId);
	}
}
