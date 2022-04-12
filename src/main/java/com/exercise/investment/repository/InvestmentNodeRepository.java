package com.exercise.investment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.investment.entity.InvestmentNode;

@Repository
public interface InvestmentNodeRepository extends JpaRepository<InvestmentNode,Long> {

	public List<InvestmentNode> findByType(String name);

}
