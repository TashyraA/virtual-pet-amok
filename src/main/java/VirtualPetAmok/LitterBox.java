package VirtualPetAmok;

public class LitterBox implements PetToilet {

    private static final int DEFAULT_POOP_LEVEL = 0;
    private int poopLevel = DEFAULT_POOP_LEVEL;


    public int getPoopLevel() {
        return poopLevel;
    }

    public void addPoop(int amount) {
        poopLevel += amount;

    }

    @Override
    public boolean isDirty() {
        if(poopLevel >= 20) {
            return true;
        }
        return false;
    }

    @Override
    public void clean() {
        poopLevel = DEFAULT_POOP_LEVEL;
    }
}
