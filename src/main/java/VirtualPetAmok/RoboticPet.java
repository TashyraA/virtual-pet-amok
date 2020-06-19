package VirtualPetAmok;

public class RoboticPet extends VirtualPet {

    private int rustLevel = 0;

    public RoboticPet(int petIdPar, String petNamePar, String petDescriptionPar, int healthPar, int rustLevelPar) {
        super(petIdPar, petNamePar, petDescriptionPar, healthPar);
        this.rustLevel = rustLevelPar;

    }


    @Override
    public void tick() {
        rustLevel++;
    }

    public int getRustLevel() {
        return rustLevel;
    }

    public void giveOil() {
        rustLevel = 0;
        addHealth();
    }

    public void addHealth() {

    }


}