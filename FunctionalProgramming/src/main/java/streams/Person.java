package streams;

public class Person {

    String name;
    int age;
    Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    enum Gender {
        MALE,
        FEMALE
    }

    @Override
    public String toString() {
        return ("name=" + name + ", " + "Age=" + age + ", " + "Gender=" + gender.name());
    }
}
