package com.exercise.investment.serviceImp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.dto.EdgeDto;
import com.exercise.investment.entity.Edge;
import com.exercise.investment.entity.InvestmentNode;
import com.exercise.investment.exception.CommonException;
import com.exercise.investment.repository.EdgeRepository;
import com.exercise.investment.repository.InvestmentNodeRepository;
import com.exercise.investment.service.EdgeService;

@Service
public class EdgeServiceImp implements EdgeService {

	@Autowired
	private EdgeRepository edgeRepository;
	
	@Autowired
	private InvestmentNodeRepository investmentNodeRepository;

	@Override
	@Transactional
	public void createEdge(List<EdgeDto> edgeList) {

		for (EdgeDto edgeDto : edgeList) {

			Optional<InvestmentNode> optionalSource = investmentNodeRepository.findById(edgeDto.getSourceId());
			Optional<InvestmentNode> optionalDestination = investmentNodeRepository
					.findById(edgeDto.getDestinationId());
			InvestmentNode sourceNode = null;
			if (optionalSource.isPresent()) {
				sourceNode = optionalSource.get();
			}
			InvestmentNode destinationNode = null;
			if (optionalDestination.isPresent()) {
				destinationNode = optionalDestination.get();
			}

			if (sourceNode != null && destinationNode != null) {
				Edge e = new Edge();
				e.setSource(sourceNode);
				e.setDestination(destinationNode);
				e.setQuantity(edgeDto.getQuantity());
				edgeRepository.save(e);
			} else {
				throw new CommonException("Please add correct IDS");
			}
		}
}

	@Override
	public List<Edge> getEdges() {
		return edgeRepository.findAll();
	}

	@Override
	public void deleteEdge(Long id) {
		edgeRepository.deleteById(id);
		
	}
}
