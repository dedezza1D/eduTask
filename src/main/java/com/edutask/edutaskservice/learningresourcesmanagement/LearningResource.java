package com.edutask.edutaskservice.learningresourcesmanagement;

import com.edutask.edutaskservice.taskmanagement.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "learningresources")
@Getter
@Setter
public class LearningResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    @Column(nullable = true)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Column(nullable = true)
    private String fileUrl;

    @Column
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task; // Assuming Task class exists in the package
}
