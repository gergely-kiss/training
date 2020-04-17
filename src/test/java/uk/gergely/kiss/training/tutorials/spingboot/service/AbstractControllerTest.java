package uk.gergely.kiss.training.tutorials.spingboot.service;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gergely.kiss.training.tutorials.spingboot.AbstractTest;
import uk.gergely.kiss.training.tutorials.springboot.web.restcontroller.AbstractController;

@AutoConfigureMockMvc
public abstract class AbstractControllerTest extends AbstractTest {

    protected MockMvc mockMvc;

    protected void setUp(AbstractController abstractController){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(abstractController).build();
    }

}
