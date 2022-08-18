package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }
    //TODO

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
