package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final long OWNER_ID = 1L;
    final String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService() , new PetMapService());

        ownerMapService.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
    }

    @Test
    void findAll() {

        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1 , ownerSet.size());
    }

    @Test
    void deleteById() {

        ownerMapService.deleteById(OWNER_ID);

        assertEquals(0 , ownerMapService.findAll().size());
    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findById(OWNER_ID));

        assertEquals(0 , ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {

        long ID = 2L;

        Owner owner2 = Owner.builder().id(ID).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(ID , savedOwner.getId());

    }
    @Test
    void saveNoId() {

        long ID = 2L;

        //Owner owner2 = Owner.builder().build();

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());

    }

    @Test
    void findById() {

        Owner owner = ownerMapService.findById(OWNER_ID);

        assertEquals(OWNER_ID , owner.getId());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerMapService.findByLastName(LAST_NAME);
        assertNotNull(smith);
        assertEquals(OWNER_ID , smith.getId());
    }
}