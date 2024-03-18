import Zoo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File animalNames = new File("C:\\Users\\Nolan\\IdeaProjects\\Java Module04\\src\\animalNames.txt");
        File arrivingAnimals = new File("C:\\Users\\Nolan\\IdeaProjects\\Java Module04\\src\\arrivingAnimals.txt");
        File newAnimals = new File("C:\\Users\\Nolan\\IdeaProjects\\Java Module04\\src\\newAnimals.txt");

        //Keep track of amount of each species
        HashMap<String, Integer> Bears = new HashMap<>();
        HashMap<String, Integer> Hyenas = new HashMap<>();
        HashMap<String, Integer> Lions = new HashMap<>();
        HashMap<String, Integer> Tigers = new HashMap<>();
        Bears.put("Bears", 0);
        Hyenas.put("Hyenas", 0);
        Lions.put("Lions", 0);
        Tigers.put("Tigers", 0);
        //ArrayLists Storing animal instances
        ArrayList<Animal> animalList = new ArrayList<>();
        //local variables
        String species;
        int age;

        try (Scanner animalIn = new Scanner(arrivingAnimals)) {
            while (animalIn.hasNextLine()) {
                String line = animalIn.nextLine();

                //Age is in the first element of the array named parts
                String[] parts = line.split(", ");
                //Check if the line has at least 1 part
                if (parts.length >= 1) {
                    String ageAndSpecies = parts[0];
                    //Get age out of 'ageAndSpecies'
                    String[] theParts = ageAndSpecies.split(" ");
                    age = Integer.parseInt(theParts[0]);
                    species = theParts[4];

                    //Create a new animal object.
                    Animal myAnimal = new Animal("name needed", age, species);

                    //Add the new Animal to the ArrayList of Animals
                    animalList.add(myAnimal);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        //Scan names from animalNames.txt
        try (Scanner nameIn = new Scanner(animalNames)) {
            int j = 0;
            //Check to see of nameIn has anything in the nextLine
            while(nameIn.hasNext())
            {
                //Checks if names has "names" in it
                String names = nameIn.nextLine();
                while (names.isEmpty() || names.contains(":"))
                {
                    names = nameIn.nextLine();
                }
                //Creates a String[] array containing the names
                String[] nameParts = names.split(", ");
                //Replaces the names of the objects in the animalList ArrayList
                for (int i = 0; i < nameParts.length; i++)
                {
                    Animal myAnimal = animalList.get(j);
                    myAnimal.setName(nameParts[i]);
                    animalList.set(j,myAnimal);
                    j++;
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
            //==============================================================================
        }

        //changes the Class of an Animal to match its species
        for(int i = 0; i < animalList.size(); i++)
        {
            switch (animalList.get(i).getSpecies()) {
                case "hyena" -> {
                    Hyena animal = new Hyena(animalList.get(i).getName(), animalList.get(i).getAge());
                    animalList.set(i, animal);
                    Hyenas.replace("Hyenas",Hyenas.get("Hyenas") + 1);
                }
                case "bear" -> {
                    Bear animal = new Bear(animalList.get(i).getName(), animalList.get(i).getAge());
                    animalList.set(i, animal);
                    Bears.replace("Bears",Bears.get("Bears") + 1);
                }
                case "lion" -> {
                    Lion animal = new Lion(animalList.get(i).getName(), animalList.get(i).getAge());
                    animalList.set(i, animal);
                    Lions.replace("Lions",Lions.get("Lions") + 1);
                }
                case "tiger" -> {
                    Tiger animal = new Tiger(animalList.get(i).getName(), animalList.get(i).getAge());
                    animalList.set(i, animal);
                    Tigers.replace("Tigers",Tigers.get("Tigers") + 1);
                }
            }
        }
        //Writing to newAnimals.txt
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newAnimals));
            writer.write("Welcome to the zoo! We have some new animals!\n");
            writer.write("We have " + Hyenas.get("Hyenas") + " Hyenas, " + Lions.get("Lions") + " Lions, " + Tigers.get("Tigers") +" Tigers, and " + Bears.get("Bears") + " Bears.\n");
            writer.newLine();
            //Writes about each animal
            for (Animal animal : animalList)
            {
                writer.write("Animal: name " + animal.getName() + ", Age: " + animal.getAge() + " Species: " + animal.getSpecies() + "\n");
            }
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Check the newAnimals.txt file");
    }
}
