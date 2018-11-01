package DataLayer.Entities;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class UserEntity {

    private int User_ID;
    private String UserName;
    private String Password;
    private String Email;
    private String Name;
    private String LastName;

    @Id
    @Column(name="User_ID")
    public int getUser_ID() {
        return User_ID;
    }

    @Column(name="UserName")
    public String getUserName() {
        return UserName;
    }

    @Column(name="Password")
    public String getPassword() {
        return Password;
    }

    @Column(name="Email")
    public String getEmail() {
        return Email;
    }

    @Column(name="Name")
    public String getName() {
        return Name;
    }

    @Column(name="LastName")
    public String getLastName() {
        return LastName;
    }
}
