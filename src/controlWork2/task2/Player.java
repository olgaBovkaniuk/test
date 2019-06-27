package controlWork2.task2;

import java.util.Objects;

public class Player {
    private String name;
    private Integer age;
    private boolean isActive;

    public Player() {};

    public Player(String name, Integer age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return isActive == player.isActive &&
                Objects.equals(name, player.name) &&
                Objects.equals(age, player.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, isActive);
    }

    @Override
    public String toString() {
        return name + " "+ age + " " + isActive;
    }
}
