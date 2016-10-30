/*
 A site contains a listing of doctors. Users can browse for doctors given a specific specialty, area, review score etc.


You need to help write the logic for returning similar doctors.  Specifically, write a class(es) which when given a doctor, provides a list of similar doctors, in a prioritized order. You define what similar means and the result ordering but clearly document any assumptions in your code.  Please include unit tests. You can assume the entire directory of doctors fits into memory.  Write in whatever language you're most comfortable with. 


Aim to spend 30 minutes on this coding challenge. We are not expecting you to create an entire hosted site, just the class for the algorithm for finding similar doctors and associated unit tests. If applicable, note down any remaining thoughts or things you would want to improve on with more time. 

 */
package api;

import java.util.*;

import model.Doctor;

public class Finder {
	// assume list of doctors in the memory
	ArrayList<Doctor> doctorList;
	// sort doctors by specialty, ordered by score
	Map<String, PriorityQueue<Doctor>> map = new HashMap<String, PriorityQueue<Doctor>>();
	
	for(Doctor doct : doctorList) {
		String speciality = doct.getDoctorSpecialty();
		if (!map.containsKey(speciality)) {
			PriorityQueue<Doctor> q = new PriorityQueue<Doctor>(11, new Comparator<Doctor>() {
				@Override
				public int compare(Doctor d1, Doctor d2) {
					if (d1.getScore() == d2.getScore()) {
						return 0;
					}
					return d1.getScore() > d2.getScore() ? -1 : 1;
				}
			});
			q.add(doct);
			map.put(speciality, q);
		} else {
			map.get(speciality).add(doct);
		}
	}

	// default search return top 20 results.
	public List<Doctor> findBySpeciality(Doctor doctor) {
		findBySpeciality(doctor, 20);
	}

	// users can define how many resuts they want.
	public List<Doctor> findBySpeciality(Doctor doctor, int num) {
		List<Doctor> result = new ArrayList<Doctor>();
        if (doctor == null) {
            return result;
        }
        String speciality = doctor.getDoctorSpecialty();
        int count = 0;
        PriorityQueue<Doctor> q = new PriorityQueue<Doctor>(map.get(speciality));
        while (q != null && !q.isEmpty() && count <= num) {
             result.add(q.poll());
             count++;
        }
        return result;
	}

	public List<Doctor> findByNearby(Doctor doctor) {
	}
}
