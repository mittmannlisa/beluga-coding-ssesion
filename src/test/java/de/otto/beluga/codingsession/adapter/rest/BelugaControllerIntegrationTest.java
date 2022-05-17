package de.otto.beluga.codingsession.adapter.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BelugaControllerIntegrationTest {

  @Autowired private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @BeforeEach()
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  @Test
  void shouldReturnHelloBelugaWhenEndpointIsCalled() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/beluga"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello Beluga!"))
        .andReturn();
  }

  @Test
  void shouldReturnNotFoundWhenWrongEndpointIsCalled() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/wrong"))
        .andExpect(status().isNotFound())
        .andReturn();
  }
}
