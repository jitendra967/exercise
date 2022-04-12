package com.exercise.investment.service;

import java.util.List;

import com.exercise.dto.MarketValueDto;
import com.exercise.dto.NodeDto;
import com.exercise.investment.entity.InvestmentNode;

public interface InvestmentService {

	List<InvestmentNode> getInvestment();

	void deleteNode(Long id);

	void createNode(NodeDto dto);

	Long getTotalMarketValue(MarketValueDto dto);

	List<InvestmentNode> getInvestor();

	List<InvestmentNode> getFund();

}
