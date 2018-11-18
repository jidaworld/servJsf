package BusinessLayer.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
    @NamedQuery(name = "FeedMessageEntity.findByEmail", query = "SELECT m FROM FeedMessageEntity m WHERE m.Users.Email = ?1")
})
@Table(name = "FeedMessage")
public class FeedMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Message_ID;

    @Column(nullable = false)
    private String Message;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date Date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Email", nullable = false)
    private UserEntity Users;

    @PrePersist
    protected void onCreate(){
        Date = new Date();
    }

    public int getMessage_ID() {
        return Message_ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public Date getDate() {
        return Date;
    }

    public UserEntity getAuthor() {
        return Users;
    }

    public void setAuthor(UserEntity user) {
        Users = user;
    }

    @Override
    public String toString() {
        return "FeedMessageEntity{" +
                "Message_ID=" + Message_ID +
                ", Message='" + Message + '\'' +
                ", Date=" + Date +
                ", Users=" + Users.toString() +
                '}';
    }
}
