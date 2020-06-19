package VirtualPetAmok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    private LitterBox litterBox = new LitterBox();
    private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

    public void add(VirtualPet petToAdd) {


        int petIdNum = pets.size()+1;

        pets.put(petToAdd.getPetName(), petToAdd);

        if (petToAdd instanceof Cat) {
            ((Cat) petToAdd).setLitterBox(litterBox);
        }

    }

    public VirtualPet findPet(String petName) {
        return pets.get(petName);
    }


    public void remove(VirtualPet petToRemove) {
        pets.remove(petToRemove.getPetName(), petToRemove);
    }


    public int getBoredomForPet(String petToPlayWith) {
        OrganicPet playWithPet = (OrganicPet) pets.get(petToPlayWith);
        return playWithPet.getBoredom();
    }

    public void playWithPet(String petToPlayWith) {
        OrganicPet playWithPet = (OrganicPet) pets.get(petToPlayWith);
        playWithPet.play();
    }

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }


    public Collection<VirtualPet> getAllAdoptablePets() {
        return pets.values();
    }

    public Collection<OrganicPet> getAllOrganicPets() {
        Collection<OrganicPet> orgPets = new ArrayList<OrganicPet>();


        for (VirtualPet pet : pets.values()) {
            if (pet instanceof OrganicPet) {
                orgPets.add((OrganicPet) pet);
            }
        }
        return orgPets;
    }


    public void feedAllOrganicPets() {
        for (OrganicPet hungryPet : getAllOrganicPets()) {
            hungryPet.feed();
        }

    }

    public void waterAllOrganicPets() {
        for (OrganicPet thirstyPet : getAllOrganicPets()) {
            thirstyPet.giveWater();
        }
    }

    public void emptyLitterBox() {
        litterBox.clean();
    }

    public LitterBox getLitterBox() {
        return litterBox;
    }


    public void cleanAllCages() {
        for (VirtualPet pet : pets.values()) {
            if (pet instanceof Dog) {
                ((Dog) pet).cleanCage();
            }
        }
    }

    public Collection<Walkable> getAllWalkablePets() {
        Collection<Walkable> walkablePets = new ArrayList<Walkable>();

        for (VirtualPet pet : pets.values()) {
            if (pet instanceof Walkable) {
                walkablePets.add((Walkable) pet);
            }
        }
        return walkablePets;
    }

    public void walkAllWalkablePets() {
        for (Walkable pet : getAllWalkablePets()) {
            pet.walk();

        }
    }

    public void playWithCats() {
        for (VirtualPet pet : pets.values()) {
            if (pet instanceof Cat) {
                ((Cat) pet).playWithLaser();
            }
        }
    }

    public Collection<RoboticPet> getAllRoboticPets() {

        Collection<RoboticPet> roboticPets = new ArrayList<RoboticPet>();



        for (VirtualPet pet : pets.values()) {
            if (pet instanceof RoboticPet) {
                roboticPets.add((RoboticPet) pet);

            }
        }
        return roboticPets;
    }


    public void oilAllRoboticPets() {
        for (RoboticPet rustyPet : getAllRoboticPets()) {
            rustyPet.giveOil();
        }
    }


    public void tickAllPets() {
        for (VirtualPet shelterPet : getAllPets()) {
            shelterPet.tick();
        }

    }
}

