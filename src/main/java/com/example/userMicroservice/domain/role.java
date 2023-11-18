package com.example.userMicroservice.domain;

import java.util.List;

import com.example.userMicroservice.enums.roleEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity()
//@Table(name = "roles")
@Data @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class role {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    private Long id;
    private roleEnum name;

    
    /*@OneToMany(mappedBy="userRole")
    List<user> users;*/
}
