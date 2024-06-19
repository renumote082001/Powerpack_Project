/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.daoImpl;

import cc.altius.machineSales.dao.UserDao;
import cc.altius.machineSales.model.RowMapper.UserRowMapper;
import cc.altius.machineSales.model.User;
import cc.altius.machineSales.service.MasterService;
import cc.altius.utils.PassPhrase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author altius
 */
@Repository
public class UserDaoImpl implements UserDao{
    
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;
    private MasterService masterService;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    
    private final String userSql = "SELECT uR.* FROM ( SELECT u.USER_ID, u.NAME, u.USERNAME, u.PASSWORD, u.ACTIVE, r.ROLE_ID, r.ROLE_DESC,  GROUP_CONCAT(rbf.BUSINESS_FUNCTION_ID) AS BUSINESS_FUNCTION_IDS "
            + "FROM us_user u LEFT JOIN us_role r ON u.ROLE_ID = r.ROLE_ID "
            + "LEFT JOIN us_role_business_function rbf ON r.ROLE_ID = rbf.ROLE_ID  "
            + "GROUP BY u.USER_ID ) uR WHERE TRUE";

    @Override
    public List<User> getUserList() {
        return jdbcTemplate.query(userSql, new UserRowMapper());
    }

    @Override
    public int addUser(User user) {
        SimpleJdbcInsert si = new SimpleJdbcInsert(dataSource).withTableName("us_user").usingGeneratedKeyColumns("USER_ID");
        Map<String,Object> params = new HashMap<>();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        params.put("NAME", user.getName());
        params.put("USERNAME", user.getUsername());
        String password = PassPhrase.getPassword(8);
        System.out.println("Password:" + password);
        params.put("PASSWORD", encoder.encode(password));
        params.put("ROLE_ID", user.getRole().getId());
        params.put("ACTIVE", true);
        return si.executeAndReturnKey(params).intValue();
    }

    @Override
    public User loadUserByUsername(String username) {
        String sqlString = this.userSql + " AND uR.USERNAME=:username";
         Map<String, Object> params = new HashMap<>();
         params.put("username", username);
         return this.namedParameterJdbcTemplate.queryForObject(sqlString, params, new UserRowMapper());
    }

    @Override
    public User getUserById(int userId) {
    String sqlString = this.userSql + " AND uR.USER_ID = :userId";
    Map<String, Object> params = new HashMap<>();
    params.put("userId", userId);
    return this.namedParameterJdbcTemplate.queryForObject(sqlString, params, new UserRowMapper());
    }

    @Override
    public int editUser(User user) {
    String sqlString = "UPDATE us_user u SET u.USERNAME = :username, u.NAME = :name, WHERE u.USER_ID = :userId";
    Map<String, Object> params = new HashMap<>();
    params.put("userId", user.getUserId());
    params.put("name", user.getName());
    params.put("username", user.getUsername());
    return this.namedParameterJdbcTemplate.update(sqlString, params);
}
    
    
}
