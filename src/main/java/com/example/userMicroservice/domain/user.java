package com.example.userMicroservice.domain;
import com.example.userMicroservice.enums.centerOfInterest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "users")
@Data @Getter /*@Setter*/ @AllArgsConstructor @NoArgsConstructor
public class user {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String username;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private centerOfInterest centerOfInterest;
    private Boolean activateNotifications;
    @Column(nullable=false)
    String role;

    public void setUserName(String username) {
      if(username != null) {
      this.username = username;
      }
    }
    public void setEmail(String email) {
       if(email != null) {
      this.email = email;
      }
    }
    public void setPassword(String password) {
       if(password != null) {
      this.password = password;
      }
    }
    public void setCenterOfINterest(centerOfInterest CenterOfINterest) {
       if(CenterOfINterest != null) {
          this.centerOfInterest = CenterOfINterest;
       }
    }
    public void setActivateNotifications(Boolean activate) {
       if(activate != null) {
          this.activateNotifications = activate;
       }
    }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id + ", usernname='" + this.username + '\'' + ", email='" + this.email + '\'' + '}';
  }

}
