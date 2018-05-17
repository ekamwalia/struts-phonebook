package model;

public class Person {
    private String name;
    private String email;
    private Long mobile;
    private int age;

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String toString() {
        return "Name: " + getName() + " Mobile:  " + getMobile() +
                " Email:      " + getEmail() + " Age:      " + getAge() ;
    }
}