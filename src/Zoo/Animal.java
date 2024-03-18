package Zoo;

public class Animal
{
    String name;
    int age;
    String species;

    //Constructor
    public Animal(String name)
    {
        this.name = name;
    }
    //Constructor
    public Animal(String name, int age, String species)
    {
        this.name = name;
        this.age = age;
        this.species = species;
    }
    //Primary Constructor
    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    //Getters
    public String getName()
    {
        return this.name;
    }
    public String getSpecies()
    {
        return this.species;
    }
    public int getAge(){
        return this.age;
    }
    //Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setSpecies(String species)
    {
        this.species = species;
    }
}
