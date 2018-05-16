package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Message> messages;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="USER_CONVERSATION",
    		joinColumns = { @JoinColumn(name="fk_user")},
    		inverseJoinColumns = { @JoinColumn(name="fk_conversation")})
    private List<Conversation> conversations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Conversation> getConversations() {
		return conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}
}
