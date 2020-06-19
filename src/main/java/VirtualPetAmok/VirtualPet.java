package VirtualPetAmok;

public abstract class VirtualPet {

    private int petId = 0;
    private String petName;
    private String petDescription;
    private int health = 10;

    public VirtualPet(int petIdPar, String petNamePar, String petDescriptionPar, int healthPar) {
        this.petId = petIdPar;
        this.petName = petNamePar;
        this.petDescription = petDescriptionPar;

    }


    public int getPetId() {
        return petId;
    }

    public String getPetName() {
        return this.petName;
    }

    public String getPetDescription() {
        return this.petDescription;
    }

    public int getHealth() {
        return health;
    }

    protected void addHealth() {
        health++;
    }

    protected void lowerHealth() {
        health--;
    }

    public abstract void tick();


}
