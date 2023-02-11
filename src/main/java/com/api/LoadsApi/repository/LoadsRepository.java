package com.api.LoadsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.api.LoadsApi.entity.LoadsEntity;

@Repository
public interface LoadsRepository extends JpaRepository<LoadsEntity, Long> {

}
