package VirtualPetAmok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class RoboticPetTest {

    RoboticPet underTest = new RoboticPet(4, "name", "description", 0, 0);


    @Test
    public void rustLevelShouldStartAt0() {
        int result = underTest.getRustLevel();
        assertEquals(0, result);
    }

    @Test
    public void rustLevelShouldIncreaseBy1AfterTick() {

        underTest.tick();
        int rust = underTest.getRustLevel();
        assertEquals(rust > 0, true);
    }


    @Test
    public void rustLevelShouldBe0AfterGiveOil() {

        int beforeOil = underTest.getRustLevel();
        underTest.tick();
        underTest.giveOil(); // void - just eats
        int result = underTest.getRustLevel();
        assertEquals(beforeOil--, result);

    }


    @Test
    public void healthShouldIncreaseBy1AfterGiveOil() {

        int beforeOilb = underTest.getHealth();
        underTest.giveOil(); // void - just eats
        int result = underTest.getHealth();
        assertEquals(beforeOilb + 1, result);

    }
}

