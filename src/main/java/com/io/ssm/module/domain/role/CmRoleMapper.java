package com.io.ssm.module.domain.role;

import com.io.ssm.module.domain.role.CmRole;
import com.io.ssm.module.domain.role.CmRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CmRoleMapper {
    long countByExample(CmRoleExample example);

    int deleteByExample(CmRoleExample example);

    int deleteByPrimaryKey(Long roleId);

    int insert(CmRole record);

    int insertSelective(CmRole record);

    List<CmRole> selectByExampleWithRowbounds(CmRoleExample example, RowBounds rowBounds);

    List<CmRole> selectByExample(CmRoleExample example);

    CmRole selectByPrimaryKey(Long roleId);

    int updateByExampleSelective(@Param("record") CmRole record, @Param("example") CmRoleExample example);

    int updateByExample(@Param("record") CmRole record, @Param("example") CmRoleExample example);

    int updateByPrimaryKeySelective(CmRole record);

    int updateByPrimaryKey(CmRole record);
}