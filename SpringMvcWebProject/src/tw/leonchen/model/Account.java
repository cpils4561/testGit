package tw.leonchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="account")
@Component //getbean要寫
public class Account {
	
  @Id  @Column(name="id")	
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name="username")
  private String username;
  
  @Column(name="userpwd")
  private String userpwd;
  
  
  public Account() {
		
	}
	
public Account(String username,String userpwd) {
		this.username=username;
		this.userpwd=userpwd;
	}
  
  public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


	

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getUserpwd() {
	return userpwd;
}

public void setUserpwd(String userpwd) {
	this.userpwd = userpwd;
}
	

}
