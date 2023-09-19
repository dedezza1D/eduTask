package com.edutask.edutaskservice.gradesfeedbackmanagement;

import com.edutask.edutaskservice.taskmanagement.Task;
import com.edutask.edutaskservice.usermanagment.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gradesfeedback")
@Getter
@Setter
public class GradesFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @Column(columnDefinition = "TEXT")
    private String gradeContent;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task; // Assuming Task class exists in the package

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Assuming User class exists in the package
}
