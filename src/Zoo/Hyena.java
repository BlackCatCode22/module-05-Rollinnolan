package Zoo;

    public class Hyena extends Animal
    {
        //Constructor
        public Hyena(String name){
            super(name);
            this.name= name;
            this.species = "hyena";
        }
        public Hyena(String name, int age)
        {
            super(name,age);
            this.name = name;
            this.age = age;
            this.species = "hyena";
        }
        public void laugh(){
            System.out.println("giggle giggle");
        }

    }
