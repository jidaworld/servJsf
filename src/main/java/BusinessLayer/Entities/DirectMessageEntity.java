package BusinessLayer.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
    @NamedQuery(name = "DirectMessageEntity.findConversation", query = "SELECT m FROM DirectMessageEntity m WHERE (" +
            " m.Sender.Email = ?1 AND m.Receiver.Email = ?2 ) OR (m.Sender.Email = ?3 AND m.Receiver.Email = ?4) ORDER BY m.Date")
})

@Table(name = "DirectMessage")
public class DirectMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Message_ID;

    @Column(nullable = false)
    private String Message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date Date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SenderEmail", nullable = false)
    private UserEntity Sender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ReceiverEmail", nullable = false)
    private UserEntity Receiver;

    @PrePersist
    public void onCreate(){ Date = new Date(); }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public UserEntity getSender() {
        return Sender;
    }

    public void setSender(UserEntity sender) {
        Sender = sender;
    }

    public UserEntity getReceiver() {
        return Receiver;
    }

    public void setReceiver(UserEntity receiver) {
        Receiver = receiver;
    }
}
