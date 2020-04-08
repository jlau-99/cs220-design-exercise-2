package evacuation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EvacuationTest {
	
	private Evacuation e;
	private Person[] people = new Person[5];
	
	@Before
	public void setUp() {
		e = new Evacuation();
		for (int i = 0; i < people.length; i++) {
			people[i] = new Person();
		}
	}

	@Test
	public void test() throws InterruptedException {
		e.addPerson(people[0]);
		Thread.sleep(100);
		e.addPerson(people[1]);
		assertEquals(people[0],e.getNextPerson());
	}

}
