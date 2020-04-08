package evacuation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person p;
	
	@Before
	public void setUp() {
		p = new Person();
	}

	@Test
	public void testName() {
		p.setFirstName("monkey");
        assertEquals("monkey",p.getFirstName());
        assertEquals("monkey",p.getName());
        p.setLastName("key");
        assertEquals("monkey key",p.getName());
	}

}
