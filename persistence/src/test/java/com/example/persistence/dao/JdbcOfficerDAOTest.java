package com.example.persistence.dao;

import com.example.persistence.entities.Officer;
import com.example.persistence.entities.Rank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
@Transactional
class JdbcOfficerDAOTest {
    @Autowired
//    @Qualifier("jdbcOfficerDao")
    private OfficerDAO dao;

    private final static String FIRST_NAME = "Chinat";
    private final static String LAST_NAME = "Yu";

    @Test
    public void save(){
        Officer officer = new Officer(Rank.LIEUTENANT, FIRST_NAME, LAST_NAME);
        officer = dao.save(officer);
        assertNotNull(officer.getId());
    }

    @Test
    public void findByIdThatExists(){
        Optional<Officer> officer = dao.findById(1);
        assertTrue(officer.isPresent());
        assertEquals(1, officer.get().getId().intValue());
    }

    @Test
    public void findByIdThatDoesNotExist(){
        Optional<Officer> officer = dao.findById(69);
        assertFalse(officer.isPresent());
    }

    @Test
    public void count(){
        assertEquals(5, dao.count());
    }

    @Test
    public void findAll(){
        List<Officer> officers = dao.findAll();
        assertEquals(5, officers.size());
        List<String> names = officers.stream()
                .map(Officer::getLast)
                .collect(Collectors.toList());
        assertThat(names, containsInAnyOrder("Kirk", "Picard", "Sisko", "Janeway", "Archer"));
    }

    @Test
    public void delete(){
        for (int i = 1; i <=5; i++) {
            Optional<Officer> officer = dao.findById(i);
            dao.delete(officer.get());
        }
        assertEquals(0, dao.count());
//  Alt way to delete using int stream?? -- https://stackoverflow.com/questions/44180101/in-java-what-are-the-advantages-of-streams-over-loops
//        IntStream.rangeClosed(1, 5)
//                .forEach(id -> {
//                    Optional<Officer> officer = dao.findById(id);
//                    assertTrue(officer.isPresent());
//                    dao.delete(officer.get());
//                });

    }

    @Test
    public void existsById(){
        assertTrue(dao.existsById(1));
        assertFalse(dao.existsById(69));
    }




}