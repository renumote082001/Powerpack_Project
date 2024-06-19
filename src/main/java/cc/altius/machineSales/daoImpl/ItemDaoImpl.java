/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.daoImpl;

import cc.altius.machineSales.dao.ItemDao;
import cc.altius.machineSales.model.Item;
import cc.altius.machineSales.model.RowMapper.ItemRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author altius
 */
@Repository
public class ItemDaoImpl implements ItemDao{
    
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
    public List<Item> getItemList() {
    String sql = "SELECT * FROM item";
    return jdbcTemplate.query(sql, new ItemRowMapper());
}

    @Override
    public List<Item> getItemByLevel(int level)
     {
        String sql = "SELECT * from item where LEVEL = :level";
        Map <String,Object> params = new HashMap<>();
        params.put("level",level);
        return this.namedParameterJdbcTemplate.query(sql,params,new ItemRowMapper());
    }
    
    
    
    
}
