<<<<<<< HEAD:backend/store/src/main/java/com/cloudcom2024/store/models/TaskDetails.java
package com.cloudcom2024.store.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tasks_details")
@Data
public class TaskDetails {
    @Id
    @GeneratedValue
    @Column(name = "task_details_id")
    private long taskDetailsId;

    @Column(name = "task_deadline")
    private LocalDateTime taskDeadline;

    @Column(name = "time_completed")
    private LocalDateTime timeCompletion;

    @Column(name = "is_done")
    @JsonProperty("is_done")
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private User fiendName;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonManagedReference
    private Task task;
}
=======
package com.cloudcom2024.store.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "tasks_details")
@Data
public class TaskDetail {
    @Id
    @GeneratedValue
    @Column(name = "task_detail_id")
    private long taskDetailId;

    @Column(name = "task_deadline")
    private LocalDateTime taskDeadline;

    @NotNull
    @Column(name = "time_completed")
    private LocalDateTime timeCompletion;

    @NotNull
    @Column(name = "is_done")
    private boolean isDone;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonBackReference
    private Task task;
}
>>>>>>> styles:backend/store/src/main/java/com/cloudcom2024/store/models/TaskDetail.java