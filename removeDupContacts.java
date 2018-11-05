// source: https://www.careercup.com/question?id=5630954857562112
// Given a list of Contacts, where each contact consists of a contact ID and a list of email IDs. Output a unique list of contacts by removing duplicates. Two contacts are considered to be the same, if they share at least one email ID.


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Contact {
	int contactID;
	Set<String> emails;

	Contact(int id) {
		this.contactID = id;
		this.emails = new HashSet<String>();
	}

	public void addEmail(String e) {
		this.emails.add(e);
	}

	public void addEmails(Set<String> es) {
		for (String e : es) {
			this.emails.add(e);
		}
	}
	
}

class RemoveDupContact {
	public static List<Contact> removeDup(List<Contact> origin) {
		Map<String, Contact> emails = new HashMap<>();
		List<Contact> contacts = new ArrayList<Contact>();
		for (Contact c : origin) {
			boolean add = true;
			for (String e : c.emails) {
				if (emails.containsKey(e)) {
					add = false;
					Contact master = emails.get(e);
					master.addEmails(c.emails);
					break;
				} else {
					emails.put(e, c);
				}
			}
			if (add)
				contacts.add(c);
		}
		return contacts;
	}

	public static void printContacts(List<Contact> cs) {
		for (Contact c : cs) {
			System.out.println(c.contactID);
			for (String e : c.emails)
				System.out.println("	" + e);
		}	
	}

	public static void main(String[] args) {
		// sample input
		Contact c1 = new Contact(1);
		c1.addEmail("123@hotmail.com");
		c1.addEmail("234@hotmail.com");
		Contact c2 = new Contact(2);
		c2.addEmail("345@hotmail.com");
		Contact c3 = new Contact(3);
		c3.addEmail("123@hotmail.com");
		c3.addEmail("789@hotmail.com");
		Contact[] lst = new Contact[] {c1, c2, c3};
		List<Contact> noDup = removeDup(Arrays.asList(lst));
		// output
		printContacts(noDup);
	}
}
