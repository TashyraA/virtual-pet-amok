package VirtualPetAmok;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualPetShelterTest {

    private VirtualPetShelter underTest;
    private LitterBox litterBox = new LitterBox();
    private Cage cage = new Cage();
    private Cat pet1;
    private Dog pet2;
    private Cat pet3;
    private RoboticPet pet4;

    @Before
    public void setUp() {
        underTest = new VirtualPetShelter();
        pet1 = new Cat(1, "Bandit", "the big fluffy cat", 10, 0, 0, 0, 2);
        pet2 = new Dog(2, "Poncho", "the sweet pitbull", 10, 3, 0, 0, 0);
        pet3 = new Cat(3 ,"Bella", "the princess of cats", 10, 0, 0, 1, 0);
        pet4 = new RoboticPet(4 ,"Precious", "the roborabbit", 10, 0);
    }


    @Test
    public void shouldBeAbleToAddAPet() {
        underTest.add(pet1);
        underTest.add(pet2);
        VirtualPet retrievedAccount = underTest.findPet("Bandit");
        assertEquals(retrievedAccount, pet1);
    }


    @Test
    public void shouldBeAbleToRemoveAPet() {
        underTest.add(pet1);
        underTest.add(pet2);
        underTest.remove(pet2);
        VirtualPet retrievedAccount = underTest.findPet("Rigby");
        assertEquals(retrievedAccount, null);

    }


    @Test
    public void shouldReturnAPetByName() {
        underTest.add(pet1);
        VirtualPet retrievedAccount = underTest.findPet("Bandit");
        assertEquals(retrievedAccount, (pet1));

    }


    @Test
    public void shouldReturnCollectionOfAllPets() {

        underTest.add(pet1);
        underTest.add(pet2);
        underTest.add(pet3);
        underTest.add(pet4);

        Collection<VirtualPet> allPets = underTest.getAllPets();

        assertEquals(4, allPets.size());

    }

    @Test
    public void shouldReturnCollectionOfAllOrganicPets() {

        underTest.add(pet1);
        underTest.add(pet2);
        underTest.add(pet3);

        underTest.add(pet4);

        Collection<VirtualPet> allPets = underTest.getAllPets();
        Collection<OrganicPet> orgPets = underTest.getAllOrganicPets();

        assertEquals(3, orgPets.size());
        assertEquals(4, allPets.size());

    }


    @Test
    public void shouldBeAbleToPlayWith1Pet() {
        underTest.add(pet2);
        pet2.tick();

        int beforePlay = underTest.getBoredomForPet(pet2.getPetName());
        underTest.playWithPet(pet2.getPetName());

        int afterPlay = underTest.getBoredomForPet(pet2.getPetName());
        assertTrue(afterPlay < beforePlay);
    }

    @Test
    public void shouldFeedAllOrganicPets() {
        underTest.add(pet1);
        underTest.add(pet2);
        underTest.add(pet3);

        int beforeFeed1 = pet1.getHunger();
        int beforeFeed2 = pet2.getHunger();
        int beforeFeed3 = pet3.getHunger();

        underTest.feedAllOrganicPets();

        int afterFeed1 = pet1.getHunger();
        int afterFeed2 = pet2.getHunger();
        int afterFeed3 = pet3.getHunger();

        assertTrue(afterFeed1 <= beforeFeed1);
        assertTrue(afterFeed2 <= beforeFeed2);
        assertTrue(afterFeed3 <= beforeFeed3);
    }


    @Test
    public void shouldWaterAllOrganicPets() {
        underTest.add(pet1);
        underTest.add(pet2);
        underTest.add(pet3);

        int beforeWater1 = pet1.getThirst();
        int beforeWater2 = pet2.getThirst();
        int beforeWater3 = pet3.getThirst();

        underTest.waterAllOrganicPets();

        int afterWater1 = pet1.getThirst();
        int afterWater2 = pet2.getThirst();
        int afterWater3 = pet3.getThirst();

        assertTrue(afterWater1 <= beforeWater1);
        assertTrue(afterWater2 <= beforeWater2);
        assertTrue(afterWater3 <= beforeWater3);
    }


    @Test
    public void shouldCleanLitterBox() {
        underTest.add(pet1);
        underTest.add(pet3);
        pet1.setLitterBox(litterBox);
        pet3.setLitterBox(litterBox);

        int beforeClean1 = pet1.getPoop();
        int beforeClean3 = pet3.getPoop();

        int testRound = 0;
        while (testRound < 10) {
            underTest.tickAllPets();
            testRound++;
        }

        litterBox.clean();

        int afterClean1 = pet1.getPoop();
        int afterClean3 = pet3.getPoop();

        assertTrue(afterClean1 <= beforeClean1);
        assertTrue(afterClean3 <= beforeClean3);
    }


    public void shouldCheckIfLitterBoxIsDirty() {
        underTest.add(pet1);
        underTest.add(pet3);
        pet1.setLitterBox(litterBox);
        pet3.setLitterBox(litterBox);

        int beforeCheck1 = pet1.getPoop();
        int beforeCheck3 = pet3.getPoop();

        int testRound = 0;
        while (testRound < 10) {
            underTest.tickAllPets();
            testRound++;
        }

        litterBox.isDirty();

        int afterCheck1 = pet1.getPoop();
        int afterCheck3 = pet3.getPoop();

        assertTrue(afterCheck1 <= beforeCheck1);
        assertTrue(afterCheck3 <= beforeCheck3);
    }

    public void shouldCheckIfCageIsDirty() {
        underTest.add(pet2);
        int beforeCheck1 = pet1.getPoop();
        int testRound = 0;
        while (testRound < 10) {
            underTest.tickAllPets();
            testRound++;
        }
        cage.isDirty();
        int afterCheck1 = pet1.getPoop();
        assertTrue(afterCheck1 <= beforeCheck1);
    }


    @Test
    public void tickShouldIncreaseStatsOfAllPetsBy1() {
        underTest.add(pet1);
        underTest.add(pet2);
        underTest.add(pet3);

        int beforeTick1 = pet1.getThirst();
        int beforeTick2 = pet2.getThirst();
        int beforeTick3 = pet3.getThirst();

        underTest.tickAllPets();

        int afterTick1 = pet1.getThirst();
        int afterTick2 = pet2.getThirst();
        int afterTick3 = pet3.getThirst();

        assertTrue(afterTick1 >= beforeTick1);
        assertTrue(afterTick2 >= beforeTick2);
        assertTrue(afterTick3 >= beforeTick3);
    }

}

