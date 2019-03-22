package springapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import springapp.domain.Appointment;
import springapp.domain.Gender;
import springapp.domain.Pet;
import springapp.domain.Reason;

/**
 * This is the appointment dao that is responsible for managing the clients info in the databsae.
 * The dao acts as the 'gatekeeper' between the rest of the code and the database
 */
@Repository
@Scope("singleton")
public class AppointmentDao {
	private Logger logger = LoggerFactory.getLogger(AppointmentDao.class);

	RowMapper<Appointment> simpleMapper = new RowMapper<Appointment>() {

		@Override
		public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
			String reasonString = rs.getString("reason");
			Reason reason = null;
			if(reasonString!= null) {
				reason = Reason.valueOf(reasonString);
			}
			else {
				reason = Reason.Checkup;
			}
			
			return new Appointment(rs.getInt("id"), rs.getInt("pet_id"), rs.getInt("client_id"), reason, rs.getTimestamp("appt_time"), rs.getInt("duration"), rs.getString("comments"));
		}
	};	
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    	
    //TODO
	//public List<Appointment> list(){

	//}

	//TODO
	public Appointment get(int id) {
		return null;				
	}
	
	public Appointment save(Appointment appointment) {
		Integer id = appointment.getId();
		if(id == null) {
			
			KeyHolder holder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement statement = con.prepareStatement("INSERT INTO appointments(pet_id, client_id, reason, appt_time, duration, comments) VALUES (?, ?, ?, ?, ?, ?)");
					statement.setInt(1, appointment.getPetId());
					statement.setInt(2, appointment.getClientId());
					statement.setString(3, "Boring");
					statement.setTimestamp(4, appointment.getTime());
					statement.setInt(5, appointment.getDuration());
					statement.setString(6, appointment.getComments());
					return statement;
				}
			}, holder);
			
			id = holder.getKey().intValue();
			
		} else {
			//TODO: WRITE CODE FOR APPOINT UPDATE 
			
			// notice that we do not update the client id since we do not want to enable pet transfer from this method
			//jdbcTemplate.update("UPDATE pets SET name = ?, gender = ? , altered = ?  WHERE id = ?",
			//		new Object[] {appointment.getName(), appointment.getGender(), appointment.isAltered(), id});
		}
		
		logger.info("Appointment " + id + " saved to DB");
		return get(id);
	}
	
	//TODO:
	//public void delete(int id) {
				
	//}
}