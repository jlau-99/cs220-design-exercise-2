package evacuation;

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
		e.addPerson(p[1]);
		Thread.sleep(10);
		e.addPerson(p[3]);
		Thread.sleep(10);
		e.addPerson(p[0]);
		Thread.sleep(10);
		e.addPerson(p[2]);
		Thread.sleep(10);
		e.addPerson(p[7]);
		Thread.sleep(10);
		e.addPerson(p[6]);
		Thread.sleep(10);
		e.addPerson(p[4]);
		Thread.sleep(10);
		e.addPerson(p[5]);
		String[] s = {"N/A","3","q","q","q","q","q","q"};
		e.changeInfo(p[0], s);
		e.getFile("ex");
		e.clearAll();
		System.out.print(e.size());
		e.readFile("ex");
		e.removeNextPerson();
		e.getFile("ex2");
		e.changeInfo(e.search("16 17").get(0),s);
		e.getFile("ex3");
		e.removeNextPerson();
		e.getFile("ex4");
		e.removeNextPerson();
		e.removeNextPerson();
		e.removeNextPerson();
		e.getFile("ex5");
	}
}
