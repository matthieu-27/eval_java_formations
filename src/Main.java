import Models.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User matt = new User("Matthieu");
        System.out.println(matt.getId() + " : " + matt.getName());
        User tristan = new User("Tristan");
        System.out.println(tristan.getId() + " : " + tristan.getName());
    }
}