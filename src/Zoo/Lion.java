package Zoo;

public class Lion extends Animal
{
    //Constructor
    public Lion(String name){
        super(name);
        this.name= name;
        this.species = "lion";
    }
    public Lion(String name, int age)
    {
        super(name,age);
        this.name = name;
        this.age = age;
        this.species = "lion";
    }
    public void sing(){
        System.out.println("It's the circle of life.");
    }
}
