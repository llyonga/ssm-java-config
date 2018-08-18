package com.io.ssm.module.domain.menu;

import com.io.ssm.module.domain.menu.CmMenu;
import com.io.ssm.module.domain.menu.CmMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CmMenuMapper {
    long countByExample(CmMenuExample example);

    int deleteByExample(CmMenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(CmMenu record);

    int insertSelective(CmMenu record);

    List<CmMenu> selectByExampleWithBLOBsWithRowbounds(CmMenuExample example, RowBounds rowBounds);

    List<CmMenu> selectByExampleWithBLOBs(CmMenuExample example);

    List<CmMenu> selectByExampleWithRowbounds(CmMenuExample example, RowBounds rowBounds);

    List<CmMenu> selectByExample(CmMenuExample example);

    CmMenu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") CmMenu record, @Param("example") CmMenuExample example);

    int updateByExampleWithBLOBs(@Param("record") CmMenu record, @Param("example") CmMenuExample example);

    int updateByExample(@Param("record") CmMenu record, @Param("example") CmMenuExample example);

    int updateByPrimaryKeySelective(CmMenu record);

    int updateByPrimaryKeyWithBLOBs(CmMenu record);

    int updateByPrimaryKey(CmMenu record);
}