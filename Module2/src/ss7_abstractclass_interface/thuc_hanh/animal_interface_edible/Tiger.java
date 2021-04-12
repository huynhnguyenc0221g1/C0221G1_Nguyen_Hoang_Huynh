package ss7_abstractclass_interface.thuc_hanh.animal_interface_edible;

public class Tiger extends Animal {
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    public void eat() {
        Animal chicken = new Chicken();
        System.out.println(((Chicken) chicken).howToEat());
        Fruit apple = new Apple();
        System.out.println(((Apple) apple).howToEat());
    }
}