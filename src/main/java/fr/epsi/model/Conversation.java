package fr.epsi.model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "conversation")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Conversation {
	
	@Id
    @GeneratedValue
    private long id;
	private String name;
	@OneToMany(mappedBy= "conversation", fetch = FetchType.EAGER)
    private List<Message> messages;
	private String type;
	@ManyToMany(mappedBy = "conversations", fetch = FetchType.EAGER)
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	private List<User> users;
	
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
