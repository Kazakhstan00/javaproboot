package kz.bitlab.javapro.javaproboot.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class SomeBean {

    private String name;
    private int age;

    public SomeBean(){
        System.out.println("Creating new Bean Class");
        this.name="Danik";
        this.age=33;
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
    public String getConnection(){
        return this.name+" "+this.age;
    }
}
