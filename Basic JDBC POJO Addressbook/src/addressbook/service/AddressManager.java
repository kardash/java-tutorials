package addressbook.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import addressbook.database.Database;
import addressbook.domain.Address;
import addressbook.domain.Contact;
import addressbook.domain.Person;

public class AddressManager {
	private Connection conn;

	public AddressManager() {
		try {
			this.conn = new Database(
					"jdbc:mysql://127.0.0.1:3306/address_book", "root", "")
					.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Contact> getContacts() throws SQLException {
		List<Contact> contacts = new ArrayList<Contact>();
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		String sql = "SELECT C.*, P.* FROM contact AS C INNER JOIN person AS P ON "
				+ "C.person_id = P.id "
				+ "ORDER BY P.lastname ASC, P.firstname ASC, P.middlename ASC";
		
		stmt = this.conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        //Loop in each record 
        while(rs.next()){
        	Contact contact = new Contact();
        	Person p = new Person();
        	
        	//Get the details
        	contact.setId(rs.getString("id"));
        	contact.setMobile_no(rs.getString("mobile_no"));
        	contact.setPhone_no(rs.getString("phone_no"));
        	contact.setPrimary(rs.getString("primary"));
        	contact.setType(rs.getString("type"));
        	        	
        	//Set the person
        	p.setId(rs.getString("person_id"));
        	p.setLastname(rs.getString("lastname"));
        	p.setFirstname(rs.getString("firstname"));
        	p.setMiddlename(rs.getString("middlename"));
        	p.setPrefix(rs.getString("prefix"));
        	p.setSuffix(rs.getString("suffix"));
        	p.setAge(rs.getInt("age"));
        	p.setGender(rs.getString("gender"));
        	p.setBirthdate(rs.getString("birthdate"));
        	
        	contact.setPerson(p);
        	
        	
        	contacts.add(contact);
        }
        
        if(contacts.size() <= 0){
        	return null;
        }
        
        return contacts;
	}

	public List<Person> getPersons() {

		return null;
	}

	public List<Address> getAddresses() {

		return null;
	}
}
