package VirtualPetAmok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CageTest {

    Dog underTest = new Dog(3, "Name", "description", 10, 0, 0, 0, 0);

    @Test
    void healthShouldDecreaseBy1IfCageIsDirty() {

        int before = underTest.getHealth();
        underTest.feed();
        underTest.tick();

        int healthLevel = underTest.getHealth();
        assertEquals(healthLevel, before--);

    }

}

