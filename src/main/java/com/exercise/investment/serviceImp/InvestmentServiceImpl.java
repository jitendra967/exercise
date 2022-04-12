package com.exercise.investment.serviceImp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.exercise.dto.EdgeDto;
import com.exercise.dto.MarketValueDto;
import com.exercise.dto.NodeDto;
import com.exercise.investment.entity.Edge;
import com.exercise.investment.entity.InvestmentNode;
import com.exercise.investment.exception.CommonException;
import com.exercise.investment.repository.EdgeRepository;
import com.exercise.investment.repository.InvestmentNodeRepository;
import com.exercise.investment.service.InvestmentService;

@Service
public class InvestmentServiceImpl implements InvestmentService {

	@Autowired
	private InvestmentNodeRepository investmentNodeRepository;

	@Autowired
	private EdgeRepository edgeRepository;

	public List<InvestmentNode> getInvestor() {
		return investmentNodeRepository.findByType("Investor");
	}

	public Long getTotalMarketValue(MarketValueDto dto) {

		List<Edge> edgeList = edgeRepository.findBySource(dto.getId());
		
		if(CollectionUtils.isEmpty(edgeList)) {
			throw new CommonException("ID not found");
		}
		
		Long i = 0L;

		for (Edge e : edgeList) {

			InvestmentNode target = e.getDestination();
			if (!dto.getExclusionIds().contains(target.getId()) && target.getType().equals("Holding")) {
				i = i + target.getValue() * e.getQuantity();
			} else {
				MarketValueDto d = new MarketValueDto();
				d.setId(target.getId());
				d.setExclusionIds(dto.getExclusionIds());
				i = i + getTotalMarketValue(d);
			}
		}
		return i;
	}

	public List<InvestmentNode> getFund() {
		return investmentNodeRepository.findByType("Fund");
	}

	public List<InvestmentNode> getInvestment() {
		return investmentNodeRepository.findAll();
	}

	@Transactional
	public void createNode(NodeDto dto) {

		if(dto == null) {
			throw new CommonException("Please send data");
		}
		InvestmentNode node = new InvestmentNode();
		node.setName(dto.getName());
		node.setType(dto.getType());
		node.setValue(dto.getValue());
		investmentNodeRepository.save(node);

	}

	public void deleteNode(Long id) {
		investmentNodeRepository.deleteById(id);
	}

}
