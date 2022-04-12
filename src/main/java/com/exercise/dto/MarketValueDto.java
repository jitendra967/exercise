package com.exercise.dto;

import java.util.List;

public class MarketValueDto {

	private Long id;
	private List<Long> exclusionIds;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Long> getExclusionIds() {
		return exclusionIds;
	}
	public void setExclusionIds(List<Long> exclusionIds) {
		this.exclusionIds = exclusionIds;
	}
}
