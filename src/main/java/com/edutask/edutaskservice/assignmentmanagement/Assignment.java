package com.edutask.edutaskservice.assignmentmanagement;

import com.edutask.edutaskservice.taskmanagement.Task;
import com.edutask.edutaskservice.teammanagement.Team;
import com.edutask.edutaskservice.usermanagment.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "assignments")
@Getter
@Setter
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
