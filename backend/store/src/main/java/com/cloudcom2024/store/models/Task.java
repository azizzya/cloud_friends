package com.cloudcom2024.store.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cloudcom2024.store.dtos.TaskResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private long taskID;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_AI")
    private boolean isAI;

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "task",
        fetch = FetchType.EAGER
    )
    private List<TaskDetails> taskDetails = new ArrayList<>();

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "personality_type_id")
    private PersonalityType personalityType;

    public Task(long taskID) {
        this.taskID = taskID;
    }

    public void setTaskDetail(TaskDetails taskDetail) {
        taskDetails.add(taskDetail);
    }

    public TaskResponse convertToTaskResponse() {
        return TaskResponse.builder()
            .taskId(taskID)
            .title(title)
            .description(title)
            .personalityTypeResponse(personalityType.convertToPersonalityTypeResponse())
            .build();
    }
}