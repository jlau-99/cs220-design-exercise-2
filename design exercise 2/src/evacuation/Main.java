package evacuation;

import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {
		Evacuation e = new Evacuation();
		String[][] array = new String[4][8];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				array[i][j] = j + 8 * i + "";
			}
		}
		for (String[] arr : array) {
			for (String s : arr) {
				System.out.print(s + " ");
			}
			System.out.println();
		}

		Person[] p = new Person[8];
		for (int i = 0; i < 4; i++) {
			p[i] = new Person();
			p[i + 4] = new Person();
			p[i].setAll(array[i]);
			p[i + 4].setAll(array[i]);
		}
		TreeMap<String, String> tree = new TreeMap<String, String>();
		e.addPerson(p[1]);
		for (int i = 0; i < 1000000; i++)
			tree.put(i + "", "a");
		e.addPerson(p[3]);
		for (int i = 0; i < 1000000; i++)
			tree.put(i + "", "a");
		e.addPerson(p[0]);
		for (int i = 0; i < 1000000; i++)
			tree.put(i + "", "a");
		e.addPerson(p[2]);
		for (int i = 0; i < 1000000; i++)
			tree.put(i + "", "a");
		e.addPerson(p[7]);
		for (int i = 0; i < 1000000; i++)
			tree.put(i + "", "a");
		e.addPerson(p[6]);
		for (int i = 0; i < 1000000; i++)
			tree.put(i + "", "a");
		e.addPerson(p[4]);
		for (int i = 0; i < 1000000; i++)
			tree.put(i + "", "a");
		e.addPerson(p[5]);
		e.getFile("ex");
		e.readFile("ex");
		e.removeNextPerson();
		e.removeNextPerson();
		e.getFile("ex2");
		e.removeNextPerson();
		e.removeNextPerson();
		e.removeNextPerson();
		e.getFile("ex3");
	}

}
