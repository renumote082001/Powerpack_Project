/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.machineSales.model.RowMapper;

import cc.altius.machineSales.model.IdAndLabel;
import cc.altius.machineSales.model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author altius
 */
public class OrderRowMapper implements RowMapper<Order>{

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return new Order(
                
        rs.getInt("ORDER_ID"),
                
        new IdAndLabel(rs.getString("USER_ID"),rs.getString("USERNAME")),
                
        rs.getString("CODE"),
                
        new IdAndLabel(rs.getString("ORDER_STATUS_ID"),rs.getString("ORDER_STATUS_DESC")),
                
        rs.getDate("ORDER_DATE")
                
        );
        
    }
    
    
    
}
