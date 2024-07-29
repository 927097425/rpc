package Train.Final.Problem2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<String> chose = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChose() {
        return chose;
    }

    public void AddChose(String chose) {
        this.chose.add(chose);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", chose=" + chose +
                '}';
    }
}
