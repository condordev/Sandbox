import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args){
        System.out.println("Optional: ");
        Optional<String> hello = Optional.ofNullable("Hello");

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        String orElse = hello.orElse("World");
        System.out.println(orElse);

        orElse = hello
                .map(String::toUpperCase)
                .orElseGet(() -> {
                    String add = "got from DB";
                    return add;
                });
        System.out.println(orElse);

        hello.ifPresent(word -> {
            System.out.println(word);
        });

        Person person = new Person("Tim", "TIM@yahoo.com");
        Person anotherPerson = new Person("Alex",null);

        String mailTim = person.getEmail();
        if(mailTim.isEmpty()){
            System.out.println(person.getName() + " No mail provided");
        }else {
            System.out.println("Tims mail: " + mailTim);
        }

        String mailAlex = anotherPerson
                .getEmailOpt()
                .map(String::toLowerCase)
                .orElse(anotherPerson.getName() + " No mail provided");

        System.out.println(mailAlex);
    }
}

class Person{
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Optional<String> getEmailOpt(){
        return Optional.ofNullable(email) ;
    }
}
