package com.example.demo.userRepository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@Getter
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ig;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "user_id")
    private String userIdNumber;

    @Column(name = "number_room")
    private int numberRoom;

    @Column(name = "user_age")
    private int userAge;

    @Column(name = "user_number")
    private int userNumber;
}
