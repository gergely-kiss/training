package uk.gergely.kiss.training.tutorials.spingboot.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uk.gergely.kiss.training.tutorials.spingboot.AbstractTest;
import uk.gergely.kiss.training.tutorials.springboot.model.GreetingEntity;
import uk.gergely.kiss.training.tutorials.springboot.service.GreetingService;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
public class GreetingServiceTest extends AbstractTest {

    @Autowired
    private GreetingService service;

    @BeforeEach
    public void setUp() {
        service.evictCache();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testFindAll() {
        Collection<GreetingEntity> greetingServiceAll = service.findAll();
        assertNotNull(greetingServiceAll);
        assertEquals(2, greetingServiceAll.size());
    }


    @Test
    public void testFindOne() {

        GreetingEntity entity = service.findById(1L);
        assertNotNull(entity);
        assertEquals(1L, entity.getId());

    }

    @Test
    public void testFindOneNotFound() {

        Long id = Long.MAX_VALUE;

        GreetingEntity entity = service.findById(id);
        assertEquals(null, entity);

    }

    @Test
    public void testCreate() {

        GreetingEntity entity = new GreetingEntity();
        entity.setText("test");

        GreetingEntity createdEntity = service.create(entity);

        assertNotNull(createdEntity);
        assertNotNull(createdEntity.getId());
        assertEquals("test", createdEntity.getText());

        Collection<GreetingEntity> list = service.findAll();
        assertEquals(3, list.size());
    }

    @Test
    public void testUpdate() {

        GreetingEntity entity = service.findById(1L);
        assertNotNull(entity);
        String updatedText = entity.getText() + " test";
        entity.setText(updatedText);
        GreetingEntity updatedEntity = service.update(entity);
        assertNotNull(updatedEntity);
        assertEquals(1L, updatedEntity.getId());
        assertEquals(updatedText, updatedEntity.getText());

    }

    @Test
    public void testUpdateNotFound() {

        Exception exception = null;
        GreetingEntity entity = new GreetingEntity();
        entity.setId(666l) ;
        entity.setText("test");
        assertNull( service.update(entity));

    }

    @Test
    public void testDelete() {

        Long id = 1L;
        GreetingEntity entity = service.findById(id);
        assertNotNull(entity);
        service.delete(id);
        Collection<GreetingEntity> list = service.findAll();
        assertEquals(1, list.size());
        GreetingEntity deletedEntity = service.findById(id);
        assertNull(deletedEntity);

    }

}
