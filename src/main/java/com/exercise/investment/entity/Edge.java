package com.exercise.investment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Edge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long quantity=1L;

	 @ManyToOne(
	           
	    )
	    @JoinColumn(
	    		 name = "source_id",
		            referencedColumnName = "id"
	    )
	private InvestmentNode source;
	

	 @ManyToOne(
	            
	    )
	    @JoinColumn(
	    		  name = "destination_id",
		            referencedColumnName = "id"
	    )

	private InvestmentNode destination;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InvestmentNode getSource() {
		return source;
	}

	public void setSource(InvestmentNode source) {
		this.source = source;
	}

	public InvestmentNode getDestination() {
		return destination;
	}

	public void setDestination(InvestmentNode destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Edge [id=" + id + ", source=" + source + ", destination=" + destination + "]";
	}
}
