package br.com.occurrence.api;

import br.com.occurrence.api.app.api.dto.organization.UnitFormDto;
import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.service.UnitService;
import br.com.occurrence.api.domain.service.UserReadService;
import br.com.occurrence.api.domain.util.filter.UnitFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Slf4j
//@SpringBootTest
//@AutoConfigureMockMvc
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiApplicationTests {
/*
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserReadService userReadService;

	@Autowired
	private UnitService unitService;

	@Test
	@Order(1)
	void testCreateUnit() throws Exception {
		User admin = userReadService.findByLogin("admin");

		UnitFormDto unitForm = new UnitFormDto(
			"Unidade A",
			null,
			admin.getId(),
			null,
			null
		);

		mockMvc.perform(
					post("/api/v1/units")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(unitForm))
				)
				.andExpect(status().isCreated());
	}

	@Test
	@Order(2)
	void testFindAllUnit() throws Exception {
		mockMvc.perform(
						get("/api/v1/units/list")
							.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	void testFindByIdUnit() throws Exception {
		List<Unit> units = unitService.findAll(new UnitFilter(null, null, null));
		Unit unit = units.get(0);

		mockMvc.perform(
						get("/api/v1/units/" + unit.getId())
							.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(unit.getName())));
	}

	@Test
	@Order(4)
	void testUpdateUnit() throws Exception {
		User admin = userReadService.findByLogin("admin");
		List<Unit> units = unitService.findAll(new UnitFilter(null, null, null));
		Unit unit = units.get(0);

		UnitFormDto unitFormEdit = new UnitFormDto(
				"Unidade A edit",
				null,
				admin.getId(),
				null,
				null
		);

		mockMvc.perform(
					put("/api/v1/units/" + unit.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(unitFormEdit))
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(unitFormEdit.name())));
	}

	@Test
	@Order(5)
	void testDeleteUnit() throws Exception {
		List<Unit> units = unitService.findAll(new UnitFilter(null, null, null));
		Unit unit = units.get(0);

		//DELETE
		mockMvc.perform(
					delete("/api/v1/units/" + unit.getId())
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isNoContent());
	}
 */

}
