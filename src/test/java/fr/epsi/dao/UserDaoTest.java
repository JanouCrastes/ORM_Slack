package fr.epsi.dao;

import fr.epsi.model.Conversation;
import fr.epsi.model.Message;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.PersistenceException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoTest {

    @Test
    public void insertUser() {
        User user = new User();
        user.setEmail("janou.crastes@gmail.com");
        user.setPassword("password");
        user.setUsername("Janou");

        long id = new UserDao().save(user);

        User u = new UserDao().get(id);
        System.out.println(u.getUsername());
        Assert.assertEquals("Janou", u.getUsername());
    }
    
    @Test
    public void createMessage() {
    	// User
    	User user = new User();
        user.setEmail("janou.crastes@gmail.com");
        user.setPassword("password");
        user.setUsername("Janou");

        long uid = new UserDao().save(user);

        User u = new UserDao().get(uid);
        
        // Conversation
        Conversation conversation = new Conversation();
    	conversation.setType("private");
    	conversation.setUsers(Arrays.asList(u));
    	conversation.setName("Salon 1");
    	
    	u.setConversations(Arrays.asList(conversation));
    	long cid = new ConversationDao().save(conversation);
    	
    	Conversation c = new ConversationDao().get(cid);
        
        // Message
    	Message message = new Message();
    	message.setText("Ceci est un message");
    	message.setNote(0);
    	message.setUser(u);
    	message.setConversation(c);
    	
    	long mid = new MessageDao().save(message);
    	
    	Message m = new MessageDao().get(mid);
    	
    	System.out.println(u.getUsername() + " (" + c.getName() + ")" + " : " + m.getText());
    }
    
    @Test
    public void createConversation() {
    	User user = new User();
        user.setEmail("janou.crastes@gmail.com");
        user.setPassword("password");
        user.setUsername("Janou");

        long uid = new UserDao().save(user);

        User u = new UserDao().get(uid);
        
        
    	
    	Conversation conversation = new Conversation();
    	conversation.setType("private");
    	conversation.setUsers(Arrays.asList(u));
    	conversation.setName("Salon 1");
    	
    	u.setConversations(Arrays.asList(conversation));
    	long cid = new ConversationDao().save(conversation);
    	
    	Conversation c = new ConversationDao().get(cid);
    	
    	System.out.print(c.getUsers().get(0).getUsername());
    }

//    @Test(expected = PersistenceException.class)
//    public void uniqueEmail() {
//        User user1 = new User();
//        user1.setFirstname("Benjamin");
//        user1.setLastname("Tourman");
//        user1.setEmail("tourman.benjamin@gmail.com");
//
//        User user2 = new User();
//        user2.setFirstname("Test");
//        user2.setLastname("Test");
//        user2.setEmail("tourman.benjamin@gmail.com");
//
//        new UserDao().save(user1);
//        new UserDao().save(user2);
//    }
//
//    @Test
//    public void ageAttribute() {
//        int year = 2000;
//
//        User user = new User();
//        user.setFirstname("Benjamin");
//        user.setLastname("Tourman");
//        user.setEmail("test@gmail.com");
//        user.setBirthday(Date.valueOf(LocalDate.now().withYear(year)));
//
//        long id = new UserDao().save(user);
//        User u = new UserDao().get(id);
//
//        Assert.assertEquals(LocalDate.now().getYear() - year, u.getAge());
//    }
//
//    @Test
//    public void insertTweets() {
//        User user = new User();
//        user.setFirstname("Benjamin");
//        user.setLastname("Tourman");
//        user.setEmail("test@gmail.com");
//        user.setBirthday(Date.valueOf(LocalDate.now().withYear(2000)));
//
//        Tweet tweet1 = new Tweet();
//        tweet1.setMessage("Test1");
//        tweet1.setUser(user);
//
//        Tweet tweet2 = new Tweet();
//        tweet2.setMessage("Test2");
//        tweet2.setUser(user);
//
//        user.setTweets(Arrays.asList(tweet1, tweet2));
//
//        long id = new UserDao().save(user);
//        User u = new UserDao().get(id);
//
//        Assert.assertEquals(2, u.getTweets().size());
//    }
//
//    @Test
//    public void deleteTweetByUser() {
//        User user = new User();
//        user.setFirstname("Benjamin");
//        user.setLastname("Tourman");
//        user.setEmail("test@gmail.com");
//        user.setBirthday(Date.valueOf(LocalDate.now().withYear(2000)));
//
//        Tweet tweet1 = new Tweet();
//        tweet1.setMessage("Test1");
//        tweet1.setUser(user);
//
//        user.setTweets(Arrays.asList(tweet1));
//
//        long id = new UserDao().save(user);
//        User u = new UserDao().get(id);
//        long tweetId = u.getTweets().get(0).getId();
//
//        new UserDao().delete(u);
//        Assert.assertNull(new TweetDao().get(tweetId));
//    }
//
//    @Test
//    public void addFollowers() {
//        User user1 = new User();
//        user1.setFirstname("Benjamin");
//        user1.setLastname("Tourman");
//        user1.setEmail("test@gmail.com");
//        user1.setBirthday(Date.valueOf(LocalDate.now().withYear(2000)));
//
//        User user2 = new User();
//        user2.setFirstname("Benjamin");
//        user2.setLastname("Tourman");
//        user2.setEmail("tourman.benjamin@gmail.com");
//        user2.setBirthday(Date.valueOf(LocalDate.now().withYear(2000)));
//        user2.setFollowers(Arrays.asList(user1));
//
//        long id = new UserDao().save(user2);
//        User u = new UserDao().get(id);
//
//        Assert.assertEquals(1, u.getFollowers().size());
//    }
//
//    @Test
//    public void insertAdmin() {
//        Admin admin = new Admin();
//        admin.setFirstname("Benjamin");
//        admin.setLastname("Tourman");
//        admin.setEmail("test@gmail.com");
//        admin.setBirthday(Date.valueOf(LocalDate.now().withYear(2000)));
//        admin.setNickname("Ben");
//
//        long id = new AdminDao().save(admin);
//        Admin a = new AdminDao().get(id);
//
//        Assert.assertEquals("Ben", a.getNickname());
//        Assert.assertEquals(LocalDate.now().getYear() - 2000, a.getAge());
//    }
//
//    @Test
//    public void searchTweet() {
//        User user = new User();
//        user.setFirstname("Benjamin");
//        user.setLastname("Tourman");
//        user.setEmail("test@gmail.com");
//        user.setBirthday(Date.valueOf(LocalDate.now().withYear(2000)));
//
//        Tweet tweet1 = new Tweet();
//        tweet1.setMessage("Premier test #test hashtag #marchebien");
//        tweet1.setUser(user);
//
//        Tweet tweet2 = new Tweet();
//        tweet2.setMessage("Je vais bien #test2");
//        tweet2.setUser(user);
//
//        user.setTweets(Arrays.asList(tweet1, tweet2));
//
//        new UserDao().save(user);
//
//        Assert.assertEquals(1, new TweetDao().searchByHashtag(Arrays.asList("test", "marchebien")).size());
//
//    }
}
