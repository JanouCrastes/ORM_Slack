package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Message {
	
	@Id
    @GeneratedValue
    private long id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Conversation conversation;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	private int note;
	private String text;
	
	
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

}
