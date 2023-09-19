package com.edutask.edutaskservice.submissionmanagement;

import com.edutask.edutaskservice.taskmanagement.Task;
import com.edutask.edutaskservice.usermanagment.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "submissions")
@Getter
@Setter
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    @Column
    private Date submissionDate;

    @Column
    private String submittedFile;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task; // Assuming Task class exists in the package

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Assuming User class exists in the package
}
