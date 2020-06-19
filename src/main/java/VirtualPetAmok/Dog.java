package VirtualPetAmok;

public class Dog extends OrganicPet implements Walkable {

    private static final int POOP_THRESHOLD = 5;
    private static final int HUNGER_THRESHOLD = 7;
    private Cage cage = new Cage();

    public Dog(int petIdPar, String petNamePar, String petDescriptionPar, int healthPar, int hungerPar, int thirstPar, int boredomPar,
               int poopPar) {
        super(petIdPar, petNamePar, petDescriptionPar, healthPar, hungerPar, thirstPar, boredomPar, poopPar);

    }

    @Override
    public void tick() {
        super.tick();

        if (this.getPoop() >= POOP_THRESHOLD) {
            cage.addPoop(getPoop());
            goPoop();
            lowerHealth();
        }
        if (this.getHunger() >= HUNGER_THRESHOLD) {
            lowerHealth();
        }
    }

    public void lowerHealth() {

    }

    public void walk() {

        play();
        goPoop();

    }

    public void cleanCage() {
        cage.clean();
    }

}
