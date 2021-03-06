package com.soecode.web.mapper;

import com.soecode.web.entity.OrderDetail;
import com.soecode.web.entity.OrderInfo;
import com.soecode.web.entity.entityVO.OrderAppraiseInfoVO;
import com.soecode.web.entity.entityVO.OrderGoodsVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderDetailMapper extends Mapper<OrderDetail> {
//    int deleteByPrimaryKey(Integer id);

//    int insert(OrderDetail record);

//    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByIdSelective(OrderDetail record);

//    int updateByPrimaryKey(OrderDetail record);

    List<OrderAppraiseInfoVO> selectMaxNumType(Integer orderId);

    List<OrderGoodsVO> selectDetailByOrderId(@Param("orderId") Integer orderId);

    int insertOrderDetail(OrderDetail queryOD);

    Integer deleteByOrderId(Integer orderId);
}