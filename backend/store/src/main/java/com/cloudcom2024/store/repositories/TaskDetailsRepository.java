package com.cloudcom2024.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloudcom2024.store.models.TaskDetails;

@Repository
public interface TaskDetailsRepository extends CrudRepository<TaskDetails, Long> {
    List<TaskDetails> findAll();

    @Query(
        value = "SELECT * FROM tasks_details WHERE is_done = false AND user_id = ?1",
        nativeQuery = true
    )
    Optional<TaskDetails> findActiveTaskDetailsByCurrentUserID(long currentUserID);

    @Query(
        value = "SELECT * FROM tasks_details WHERE is_done = false AND (user_id = ?1 AND friend_id = ?2)",
        nativeQuery = true
    )
    Optional<TaskDetails> findActiveTaskDetailsByCurrentUserIDAndFriendID(long currentUserID, long frindID);

    @Modifying
    @Transactional
    @Query(
        value = "UPDATE tasks_details SET is_done = true WHERE user_id = ?1 AND friend_id = ?2",
        nativeQuery = true
    )
    void setTaskIsDoneByUserIDAndFriendID(long currentUserID, long friendID);

    @Modifying
    @Transactional
    @Query(
        value = "UPDATE tasks_details SET is_done = true WHERE friend_id = ?1 AND task_details_id =?2",
        nativeQuery = true
    )
    void setTaskDetailIsDoneByUserIDAndTaskID(
        Long friendID,
        Long taskID
    );  
}