package evacuation;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.*;

public class Evacuation {
	private Queue<Person> queue;
	private Map<String, List<Person>> map;

	public Evacuation() {
		queue = new LinkedList<Person>();
		map = new TreeMap<String, List<Person>>();
	}

	public void addPerson(Person p) throws InterruptedException {
		if (p.getDate().equals("N/A"))
			p.setDate(LocalDateTime.now().toString());
		queue.add(p);
		if (!map.containsKey(p.getName()))
			map.put(p.getName(), new LinkedList<Person>());
		map.get(p.getName()).add(p);
	}

	public String getNextPerson() {
		return queue.peek().toString();
	}

	public void removeNextPerson() {
		Person p = queue.remove();
		List<Person> list = map.get(p.getName());
		list.remove(p);
		if (list.size() == 0)
			map.remove(p.getName());
	}

	public void readFile(String fileName) throws Exception {
		queue = new LinkedList<Person>();
		map = new TreeMap<String, List<Person>>();
		File myObj = new File(fileName + ".txt");
		Scanner scan = new Scanner(myObj);
		Map<LocalDateTime, Person> map = new TreeMap<LocalDateTime, Person>();
		String s;
		while (scan.hasNext()) {
			Person p = new Person();
			scan.next();
			scan.next();
			p.setFirstName(scan.nextLine().substring(1));
			scan.next();
			scan.next();
			p.setLastName(scan.nextLine().substring(1));
			scan.next();
			scan.next();
			p.setStreetNum(scan.nextLine().substring(1));
			scan.next();
			p.setCity(scan.nextLine().substring(1));
			scan.next();
			p.setState(scan.nextLine().substring(1));
			scan.next();
			p.setCountry(scan.nextLine().substring(1));
			scan.next();
			scan.next();
			p.setZipCode(scan.nextLine().substring(1));
			scan.next();
			scan.next();
			p.setAdditionalInfo(scan.nextLine().substring(1));
			scan.next();
			scan.next();
			p.setDate(scan.nextLine().substring(1));
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
}
