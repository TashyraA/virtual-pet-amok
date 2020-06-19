package VirtualPetAmok;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    Cat underTest = new Cat(1, "Name", "description", 10, 0, 0, 0, 0);
    Cat underTest2 = new Cat(2, "2ndCat", "2nd description", 10, 0, 0, 0, 0);

    LitterBox litterBox = new LitterBox();

    public void shouldBeAbleToUseLitterBox() {
        underTest.setLitterBox(litterBox);
        underTest.tick();
        underTest.tick();

        int catPoop = underTest.getPoop();

        assertTrue(catPoop > 0);

        underTest.useLitterBox();
        int boxPoopLevel = litterBox.getPoopLevel();

        assertEquals(catPoop, boxPoopLevel);
        assertEquals(underTest.getPoop(), 0);
    }


    public void twoCatsShouldBeAbleToUseLitterBox() {
        underTest.setLitterBox(litterBox);
        underTest2.setLitterBox(litterBox);
        underTest.tick();
        underTest2.tick();
        underTest.tick();
        underTest2.tick();

        int catPoop = underTest.getPoop();

        assertTrue(catPoop > 0);

        underTest.useLitterBox();
        int boxPoopLevel = litterBox.getPoopLevel();

        assertEquals(catPoop, boxPoopLevel);
        assertEquals(underTest.getPoop(), 0);

    }

    @Test
    public void boredomShouldBe0AfterPlayWithLaser() {

        underTest.getBoredom();
        underTest.tick();
        assertEquals(true, 0 < underTest.getBoredom());
        underTest.playWithLaser();
        int boredomLevel = underTest.getBoredom();
        assertEquals(boredomLevel, 0);

    }

    @Test
    public void healthShouldIncreaseBy1AfterPlayWithLaser() {

        int beforePlay = underTest.getHealth();
        underTest.tick();
        underTest.playWithLaser();
        int healthLevel = underTest.getHealth();
        assertEquals(healthLevel, beforePlay + 1);

    }
}

