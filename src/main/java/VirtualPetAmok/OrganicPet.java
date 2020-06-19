package VirtualPetAmok;


public class OrganicPet extends VirtualPet {

    private int hunger = 0;
    private int thirst = 0;
    private int boredom = 0;
    private int poop = 0;

    public OrganicPet(int petIdPar, String petNamePar, String petDescriptionPar, int healthPar,	int hungerPar, int thirstPar, int boredomPar, int poopPar) {
        super(petIdPar, petNamePar, petDescriptionPar, healthPar);
        this.hunger = hungerPar;
        this.thirst = thirstPar;
        this.boredom = boredomPar;
        this.poop = poopPar;
    }


    public int getHunger() {
        return hunger;
    }

    public void feed() {
        hunger = 0;
        poop++;
        addHealth();
    }

    public void addHealth() {
    }


    public int getThirst() {
        return thirst;
    }

    public void giveWater() {
        thirst = 0;
        addHealth();

    }


    public int getPoop() {
        return poop;
    }

    public void goPoop() {
        poop = 0;
        addHealth();

    }


    public int getBoredom() {
        return boredom;
    }

    public void play() {
        boredom = 0;
        thirst++;
        addHealth();


    }

    @Override
    public void tick() {
        hunger++;
        thirst++;
        poop++;
        boredom++;
        lowerHealth();
    }

    public void lowerHealth() {

    }

}
