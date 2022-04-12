package com.exercise.investment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.dto.MarketValueDto;
import com.exercise.dto.NodeDto;
import com.exercise.investment.entity.InvestmentNode;
import com.exercise.investment.service.InvestmentService;

@RestController
@RequestMapping("/investment")
public class InvestmentController {

	@Autowired
	private InvestmentService investmentService;
	
	@GetMapping("/")
	public List<InvestmentNode> getInvestment() {
		return investmentService.getInvestment();
	}
	
	@PostMapping("/")
	public String createNode(@RequestBody NodeDto dto) {
		investmentService.createNode(dto);
		return "Success";
	}
	
	@DeleteMapping("/{id}")
	public String deleteNode(@PathVariable Long id) {
		investmentService.deleteNode(id);
		return "success";
	}
	
	@GetMapping("/market_value")
	public Long getTotalMarketValue(@RequestBody MarketValueDto dto) {
		return investmentService.getTotalMarketValue(dto);
	}
	
	@GetMapping("/get_investor")
	public List<InvestmentNode> getInvestor() {
		return investmentService.getInvestor();
	}
	@GetMapping("/get_fund")
	public List<InvestmentNode> getFund() {
		return investmentService.getFund();
	}
}
