package Train.Middian.Problem2;

import javax.lang.model.element.Name;
import java.time.LocalDate;


public class User {
    private Long Id;
    private String name;
    private String gender;
    private LocalDate birthday;

    public Long getId() {
        return Id;
    }

    public User(){

    }

    public User(Long id,String name,String gender,LocalDate birthday){
        this.Id = id;
        this.gender = gender;
        this.birthday = birthday;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
