package BusinessLayer.Entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
        @NamedQuery(name = "UserEntity.findById", query = "SELECT u FROM UserEntity u WHERE u.id = ?1"),
        @NamedQuery(name = "UserEntity.findByName", query = "SELECT u FROM UserEntity u WHERE u.Name LIKE ?1"),
        @NamedQuery(name = "UserEntity.findByEmail", query = "SELECT u FROM UserEntity u WHERE u.Email = ?1")})
@Table(name="Users")
public class UserEntity {


    @Column(unique=true, nullable = false)
    private String UserName;

    @Column(nullable=false)
    private String Password;

    @Id
    @Column(unique=true, nullable = false)
    private String Email;

    @Column(nullable=false)
    private String Name;

    @Column(nullable=false)
    private String LastName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
