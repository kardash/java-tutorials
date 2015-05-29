/**
 * 
 */
package addressbook.main;

import java.sql.SQLException;
import java.util.List;

import addressbook.domain.Contact;
import addressbook.domain.Person;
import addressbook.service.AddressManager;

public class AddressBook {

	public static void main(String[] args) {
		AddressManager manager = new AddressManager();

		try {
			List<Contact> list = manager.getContacts();
			
			for(Contact c : list){
				Person p = c.getPerson();
				
				System.out.println("ID : " + p.getId());
				System.out.println("Name : " + p.getLastname() + ", " + p.getFirstname() + " " + p.getMiddlename());
				
				System.out.println("Mobile : " + c.getMobile_no());
				System.out.println("Phone : " + c.getPhone_no());
				System.out.println("Primary Contact? : " + c.getPrimary());
				System.out.println("Type : " + c.getType());
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
