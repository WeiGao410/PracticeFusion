package api;

import static org.junit.Assert.*;

import java.util.*

import model.Doctor;
import api.Finder;

import org.junit.Test;

public class FinderTest {
	Finder finder = new Finder();
	Doctor doctor = new Doctor("Jay","Hand Surgery");
	List<Doctor> expected = new ArrayList<Doctor>();
	//add expected 30 doctors with the same Specialty(Hand Surgery) in score ranking
	expected.add();

	@Test
	public void test() {
		//null input
		assertEquals(new ArrayList<Doctor>(), finder.findBySpeciality(null));
		//default input
		assertEquals(expected.subList(0, 21), finder.findBySpeciality(doctor));
		//user set 30 results
		assertEquals(expected, finder.findBySpeciality(doctor, 30));
	}

}
