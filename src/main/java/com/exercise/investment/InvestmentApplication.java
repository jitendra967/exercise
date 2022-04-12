package com.exercise.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercise.investment.entity.Edge;
import com.exercise.investment.entity.InvestmentNode;
import com.exercise.investment.repository.EdgeRepository;
import com.exercise.investment.repository.InvestmentNodeRepository;

@SpringBootApplication
public class InvestmentApplication implements ApplicationRunner {

	@Autowired
	private InvestmentNodeRepository investmentNodeRepository;

	@Autowired
	private EdgeRepository edgeRepository;

	public static void main(String[] args) {
		SpringApplication.run(InvestmentApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		InvestmentNode investorNode1 = new InvestmentNode();
		investorNode1.setName("Inv1");
		investorNode1.setType("Investor");

		investmentNodeRepository.save(investorNode1);

		InvestmentNode investorNode2 = new InvestmentNode();
		investorNode2.setName("Inv2");
		investorNode2.setType("Investor");
		investmentNodeRepository.save(investorNode2);

		InvestmentNode FundNode1 = new InvestmentNode();
		FundNode1.setName("F1");
		FundNode1.setType("Fund");

		InvestmentNode FundNode2 = new InvestmentNode();
		FundNode2.setName("F2");
		FundNode2.setType("Fund");

		InvestmentNode FundNode3 = new InvestmentNode();
		FundNode3.setName("F3");
		FundNode3.setType("Fund");

		InvestmentNode holdingNode1 = new InvestmentNode();
		holdingNode1.setName("H1");
		holdingNode1.setType("Holding");
		holdingNode1.setValue(10L);

		investmentNodeRepository.save(holdingNode1);

		InvestmentNode holdingNode2 = new InvestmentNode();
		holdingNode2.setName("H2");
		holdingNode2.setType("Holding");
		holdingNode2.setValue(20L);

		investmentNodeRepository.save(holdingNode2);

		InvestmentNode holdingNode3 = new InvestmentNode();
		holdingNode3.setName("H3");
		holdingNode3.setType("Holding");
		holdingNode3.setValue(15L);

		 investmentNodeRepository.save(holdingNode3);

		InvestmentNode holdingNode4 = new InvestmentNode();
		holdingNode4.setName("H4");
		holdingNode4.setType("Holding");
		holdingNode4.setValue(10L);

		investmentNodeRepository.save(holdingNode4);

		investmentNodeRepository.save(FundNode1);

		investmentNodeRepository.save(FundNode2);

		investmentNodeRepository.save(FundNode3);
	
		Edge edge1 = new Edge();
		edge1.setSource(investorNode1);
		edge1.setDestination(FundNode1);

		edgeRepository.save(edge1);

		Edge edge2 = new Edge();
		edge2.setSource(investorNode1);
		edge2.setDestination(FundNode2);

		edgeRepository.save(edge2);

		Edge edge3 = new Edge();
		edge3.setSource(investorNode2);
		edge3.setDestination(FundNode2);

		edgeRepository.save(edge3);

		Edge edge4 = new Edge();
		edge4.setSource(investorNode2);
		edge4.setDestination(FundNode3);

		edgeRepository.save(edge4);

		Edge edge5 = new Edge();
		edge5.setSource(FundNode1);
		edge5.setDestination(holdingNode1);
		edge5.setQuantity(100L);

		edgeRepository.save(edge5);
		
		Edge edge6 = new Edge();
		edge6.setSource(FundNode1);
		edge6.setDestination(holdingNode2);
		edge6.setQuantity(100L);

		edgeRepository.save(edge6);
		
		Edge edge7 = new Edge();
		edge7.setSource(FundNode1);
		edge7.setDestination(holdingNode4);
		edge7.setQuantity(100L);
		edgeRepository.save(edge7);
		
		Edge edge8 = new Edge();
		edge8.setSource(FundNode2);
		edge8.setDestination(holdingNode1);
		edge8.setQuantity(100L);
		edgeRepository.save(edge8);
		
		
		Edge edge9 = new Edge();
		edge9.setSource(FundNode2);
		edge9.setDestination(holdingNode3);
		edge9.setQuantity(100L);
		
		edgeRepository.save(edge9);
		
		Edge edge10 = new Edge();
		edge10.setSource(FundNode3);
		edge10.setDestination(holdingNode1);
		edge10.setQuantity(100L);
		edgeRepository.save(edge10);

		Edge edge11 = new Edge();
		edge11.setSource(FundNode3);
		edge11.setDestination(holdingNode4);
		edge11.setQuantity(100L);
		edgeRepository.save(edge11);
	}

}
