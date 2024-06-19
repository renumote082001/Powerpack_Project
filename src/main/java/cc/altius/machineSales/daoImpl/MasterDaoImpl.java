/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.daoImpl;

import cc.altius.machineSales.dao.MasterDao;
import cc.altius.machineSales.model.IdAndLabel;
import cc.altius.machineSales.model.RowMapper.IdAndLabelRowMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author altius
 */
@Repository
public class MasterDaoImpl implements MasterDao{
      
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public List<IdAndLabel> getRoleList() {
        String sqlQuery= "SELECT r.ROLE_ID AS ID, r.ROLE_DESC AS LABEL FROM us_role r";
        return this.jdbcTemplate.query(sqlQuery,new IdAndLabelRowMapper());
    }
    
    
    
}
