package evacuation;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.*;

public class Evacuation implements FileOfPeople {
	private List<Person> people;
	private Map<String, List<Person>> map;

	public Evacuation() {
		people = new LinkedList<Person>();
		map = new TreeMap<String, List<Person>>();
	}

	public void addPerson(Person p) {
		if (p.getDate().equals("N/A"))
			p.setDate(LocalDateTime.now().toString());
		people.add(p);
		if (!map.containsKey(p.getName()))
			map.put(p.getName(), new LinkedList<Person>());
		map.get(p.getName()).add(p);
	}

	public List<Person> getPeople(int n) throws Exception {
		return people.subList(0, n);
	}

	public int size() {
		return people.size();
	}

	public Person getNextPerson() {
		return people.get(0);
	}

	public void removeNextPerson() throws Exception {
		Person p = people.remove(0);
		List<Person> list = map.get(p.getName());
		list.remove(p);
		if (list.size() == 0)
			map.remove(p.getName());
	}

	// arr[0]=firstName [1]=lastName [2]=streetNum [3]=city [4]=state [5]=country
	// [6]=zipCode [7]=additionalInfo
	public void changeInfo(Person p, String[] arr) {
		boolean nameNotChanged = p.getFirstName().contentEquals(arr[0]) && p.getLastName().contentEquals(arr[1]);
		if (!nameNotChanged) {
			List<Person> list = map.get(p.getName());
			list.remove(p);
			if (list.size() == 0)
				map.remove(p.getName());
			p.setAll(arr);
			if (!map.containsKey(p.getName()))
				map.put(p.getName(), new LinkedList<Person>());
			map.get(p.getName()).add(p);
		} else {
			p.setAll(arr);
		}
	}

	public List<Person> search(String s) {
		return map.get(s);
	}

	public void readFile(String fileName) throws Exception {
		people = new LinkedList<Person>();
		map = new TreeMap<String, List<Person>>();
		File myObj = new File(fileName + ".txt");
		Scanner scan = new Scanner(myObj);
		String s;
		Map<LocalDateTime, Person> map = new TreeMap<LocalDateTime, Person>();
		while (scan.hasNext()) {
			Person p = new Person();
			s = scan.nextLine();
			p.setFirstName(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			p.setLastName(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			p.setStreetNum(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			p.setCity(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			p.setState(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			p.setCountry(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			p.setZipCode(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			p.setAdditionalInfo(s.substring(s.indexOf(":") + 1).trim());
			s = scan.nextLine();
			scan.nextLine();
			p.setDate(s.substring(s.indexOf(":") + 1).trim());
			LocalDateTime time = LocalDateTime.parse(p.getDate());
			map.put(time, p);
		}
		for (Person p1 : map.values()) {
			addPerson(p1);
		}
		scan.close();
	}

	public void getFile(String fileName) throws Exception {

		File myObj = new File(fileName + ".txt");
		FileWriter myWriter = new FileWriter(fileName + ".txt");
		myObj.createNewFile();
		for (List<Person> list : map.values()) {
			for (Person p : list) {
				myWriter.write(p.toString());
			}
		}
		myWriter.close();
	}
	
	public void clearAll() {
		people = new LinkedList<Person>();
		map = new TreeMap<String, List<Person>>();
	}
}
