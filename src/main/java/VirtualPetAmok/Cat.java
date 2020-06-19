package VirtualPetAmok;

public class Cat extends OrganicPet {

private static final int POOP_THRESHOLD = 5;
private LitterBox litterBox;

public Cat(int petIdPar, String petNamePar, String petDescriptionPar, int healthPar , int hungerPar, int thirstPar, int boredomPar,
        int poopPar) {
        super(petIdPar, petNamePar, petDescriptionPar, healthPar, hungerPar, thirstPar, boredomPar, poopPar);

        }

public void setLitterBox(LitterBox value) {
        this.litterBox = value;
        }

public void useLitterBox() {

        if(litterBox.isDirty()) {
        lowerHealth();
        }
        litterBox.addPoop(getPoop());
        goPoop();

        }

    public void lowerHealth() {

    }


    @Override
public void tick() {
        super.tick();

        if (this.getPoop() >= POOP_THRESHOLD) {
        useLitterBox();
        }
        }

public void playWithLaser() {
        play();
        }
        }
