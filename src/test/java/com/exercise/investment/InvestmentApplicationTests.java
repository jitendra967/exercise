package com.exercise.investment;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.exercise.investment.entity.InvestmentNode;
import com.exercise.investment.repository.InvestmentNodeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class InvestmentApplicationTests {

	@Autowired
	private InvestmentNodeRepository investmentNodeRepository;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	void getInvestment() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/investment/").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	void getRecords() {
		InvestmentNode node1 = new InvestmentNode();
		node1.setId(1L);
		node1.setName("Inv1");
		node1.setType("Investor");

		InvestmentNode node2 = new InvestmentNode();
		node1.setId(2L);
		node1.setName("Inv2");
		node1.setType("Investor");

		InvestmentNode node3 = new InvestmentNode();
		node1.setId(3L);
		node1.setName("F1");
		node1.setType("Fund");

		List<InvestmentNode> records = new ArrayList<>(Arrays.asList(node1, node2, node3));

		Mockito.when(investmentNodeRepository.findAll()).thenReturn(records);

	}

}
