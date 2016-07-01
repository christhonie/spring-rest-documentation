package com.pepkor.integration_sample_api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.restdocs.RestDocumentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pepkor.integration_sample_api.Application;

import io.github.robwin.markup.builder.MarkupLanguage;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;
import springfox.documentation.staticdocs.SwaggerResultHandler;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
//@SpringApplicationConfiguration(classes = {Application.class, SwaggerConfig.class})
@SpringApplicationConfiguration(classes = {Application.class})
public class Swagger2MarkupTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Rule
//    public final RestDocumentation restDocumentation = new RestDocumentation(System.getProperty("io.springfox.staticdocs.snippetsOutputDir"));
    public final RestDocumentation restDocumentation = new RestDocumentation("target/docs/asciidoc/snippets");
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void checkAvailabilityTest() throws Exception {
        this.mockMvc.perform(post("/meeting/checkAvailability").param("name", "Bertus"))
        	.andExpect(status().isOk())
        	.andDo(document("checkAvailability", preprocessResponse(prettyPrint())));
        
//    	.andDo(document("checkAvailability", requestFields( 
//    			fieldWithPath("name").description("The user's name"))));

    }

    @Test
    public void createSpringfoxSwaggerJson() throws Exception {
        //String designFirstSwaggerLocation = Swagger2MarkupTest.class.getResource("/swagger.yaml").getPath();

        String outputDir = "target/docs/swagger"; //System.getProperty("io.springfox.staticdocs.outputDir");
        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
                .andExpect(status().isOk())
                .andReturn();

        //String springfoxSwaggerJson = mvcResult.getResponse().getContentAsString();
        //SwaggerAssertions.assertThat(Swagger20Parser.parse(springfoxSwaggerJson)).isEqualTo(designFirstSwaggerLocation);
    }
}