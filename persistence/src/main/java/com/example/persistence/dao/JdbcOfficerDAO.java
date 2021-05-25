package com.example.persistence.dao;

import com.example.persistence.entities.Officer;
import com.example.persistence.entities.Rank;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcOfficerDAO implements OfficerDAO {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertOfficer;

    /**
     * @return Row mapper lambda func
     */
    private RowMapper<Officer> getOfficerRowMapper() {
        return (rs, rowNum) -> new Officer(rs.getInt("id"),
                Rank.valueOf(rs.getString("rank")),
                rs.getString("first_name"),
                rs.getString(("last_name"))
        );
    }


    public JdbcOfficerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertOfficer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("officers")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Officer save(Officer officer){
        Map<String, Object> param = new HashMap<>();
        param.put("rank", officer.getRank());
        param.put("first_name", officer.getFirst());
        param.put("last_name", officer.getLast());
        // dave the params to the db of hashmaps/dict
        Integer newId = (Integer) insertOfficer.executeAndReturnKey(param);
        officer.setId(newId);
        return officer;
     }

//    find by ID
    @Override
    public Optional<Officer> findById(Integer id){
//        Check exists
        if (!existsById(id)) return Optional.empty();
//        if it exists, query db
        return Optional.of(jdbcTemplate.queryForObject(
                "SELECT * FROM officers WHERE id=?",
                getOfficerRowMapper(),
                id
        ));
    }
//    find all
    public List<Officer> findAll(){
        return jdbcTemplate.query("SELECT * FROM officers",
                getOfficerRowMapper());
    }

    //    count
    public long count(){
        return jdbcTemplate.queryForObject("SELECT COUNT (*) FROM officers", Long.class);
    }

//    delete
    public void delete(Officer officer){
        jdbcTemplate.update("DELETE FROM officers WHERE id=?", officer.getId());
    }

//    exists by id
    public boolean existsById(Integer id){
        return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT 1 FROM officers WHERE id=?)", Boolean.class, id);
    }

}
