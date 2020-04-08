package evacuation;

import java.util.List;

public interface FileOfPeople {

	// adds a person to the file
	public void addPerson(Person p);

	// gets the first n people who were added to the file
	public List<Person> getPeople(int n) throws Exception;

	// returns the number of Persons in the FileOfPeople
	public int size();

	// returns the first Person added to the FileOfPeople
	public Person getNextPerson();

	// removes the first Person added to the FileOfPeople
	public void removeNextPerson() throws Exception;

	// searches for everyone with name s. s has format firstName (if no lastName),
	// lastName (if no firstName), or firstName + " " + LastName
	public List<Person> search(String s);

	// creates a FileOfPeople by reading from a text file
	public void readFile(String fileName) throws Exception;

	// creates/writes to a text file of all Persons in the FileOfPeople,
	// alphabetically ordered according to the name
	public void getFile(String fileName) throws Exception;
	
	// exactly what you'd expect from a clearAll method
	public void clearAll();
}
