package VirtualPetAmok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {


    VirtualPet underTest = new VirtualPet(1, "Name", "description", 10, 0, 0, 0, 0);


    @Test
    public void healthShouldStartAt10() {
        int result = underTest.getHealth();
        assertEquals(10, result);
    }

    @Test
    public void shouldReturnPetName() {
        String check = underTest.getPetName();
        assertEquals(check, "Name");

    }

    @Test
    public void shouldReturnPetDescription() {
        String check = underTest.getPetDescription();
        assertEquals(check, "description");

    }
    @Test
    public void shouldReturnPetIdNum() {
        int check = underTest.getPetId();
        assertEquals(check, 1);

    }
}

