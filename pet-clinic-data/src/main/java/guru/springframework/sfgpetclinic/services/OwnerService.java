package guru.springframework.sfgpetclinic.services;
import guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface OwnerService extends CrudService<Owner , Long>{
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
