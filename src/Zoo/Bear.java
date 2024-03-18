package Zoo;

public class Bear extends Animal
{
    //Constructor
    public Bear(String name){
        super(name);
        this.name= name;
        this.species = "bear";
    }
    public Bear(String name, int age)
    {
        super(name,age);
        this.name = name;
        this.age = age;
        this.species = "bear";
    }
    public void hibernate()
    {
        System.out.println("zzzzzzzz");
    }
}
