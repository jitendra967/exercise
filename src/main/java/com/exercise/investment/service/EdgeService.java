package com.exercise.investment.service;

import java.util.List;

import com.exercise.dto.EdgeDto;
import com.exercise.investment.entity.Edge;

public interface EdgeService {

	void createEdge(List<EdgeDto> edgeList);

	List<Edge> getEdges();

	void deleteEdge(Long id);

}
