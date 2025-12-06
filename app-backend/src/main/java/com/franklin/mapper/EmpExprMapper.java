package com.franklin.mapper;

import com.franklin.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: franklin
 * @Date: 2025/11/17
 * @Description:
 */
@Mapper
public interface EmpExprMapper {

    /**
     * INTERT emp work experiences
     * @param exprList
     */
    void insertBatch(List<EmpExpr> exprList);

    /**
     * DELETE emp work experiences
     * @param empIds
     * @return
     */
    void delete(List<Integer> empIds);

}
