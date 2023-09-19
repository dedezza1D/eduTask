package com.edutask.edutaskservice.taskmanagement;

import com.edutask.edutaskservice.usermanagment.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private Date dueDate;

    @Column
    private Integer priority;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
