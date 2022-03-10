package com.quinbay.LibraryManagement.repository;

import com.quinbay.LibraryManagement.entity.UserBookHistoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserBookHistoryRepository extends CrudRepository<UserBookHistoryEntity,Integer> {
}
