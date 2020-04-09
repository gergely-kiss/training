package uk.gergely.kiss.training.tutorials.spingboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
