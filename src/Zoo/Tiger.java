package Zoo;

public class Tiger extends Animal
{
    //Constructor
    public Tiger(String name){
        super(name);
        this.name= name;
        this.species = "tiger";
    }
    public Tiger(String name, int age)
    {
        super(name,age);
        this.name = name;
        this.age = age;
        this.species = "tiger";
    }
    public void growl(){
        System.out.println("grrrrrr");
    }
}
