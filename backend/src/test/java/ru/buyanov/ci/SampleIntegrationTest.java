package ru.buyanov.ci;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase
public class SampleIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void test_returnOkFoList() throws Exception {
        mvc.perform(get("/samples")).andExpect(status().isOk());
    }

    @Test
    void test_createSample() throws Exception {
        MockHttpServletRequestBuilder request = post("/samples")
                .contentType("application/json")
                .content("{ \"name\": \"sample name\" }");

        mvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", endsWith("/samples/1")));
    }

}
