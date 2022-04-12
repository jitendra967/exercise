package com.exercise.investment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercise.investment.entity.Edge;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Long>{

	@Query(value ="select * from edge where source_id=?", nativeQuery =true)
	List<Edge> findBySource(Long id);

}
