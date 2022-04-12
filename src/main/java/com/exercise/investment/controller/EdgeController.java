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

import com.exercise.dto.EdgeDto;
import com.exercise.investment.entity.Edge;
import com.exercise.investment.service.EdgeService;

@RestController
@RequestMapping("/edge")
public class EdgeController {

	@Autowired
	private EdgeService edgeService;
	
	@PostMapping("/")
	public String createEdge(@RequestBody List<EdgeDto> edgeList) {
		edgeService.createEdge(edgeList);
		return "Success";
	}
	
	@GetMapping("/")
	public List<Edge> getEdges() {
		return edgeService.getEdges();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEdge(@PathVariable Long id) {
		edgeService.deleteEdge(id);
	}
}
