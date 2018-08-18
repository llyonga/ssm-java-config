package com.io.ssm.module.domain.rolemenu;

import com.io.ssm.module.domain.rolemenu.CmRoleMenu;
import com.io.ssm.module.domain.rolemenu.CmRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

public interface CmRoleMenuMapper {
    long countByExample(CmRoleMenuExample example);

    int deleteByExample(CmRoleMenuExample example);

    int insert(CmRoleMenu record);

    int insertSelective(CmRoleMenu record);

    List<CmRoleMenu> selectByExampleWithRowbounds(CmRoleMenuExample example, RowBounds rowBounds);

    List<CmRoleMenu> selectByExample(CmRoleMenuExample example);

    int updateByExampleSelective(@Param("record") CmRoleMenu record, @Param("example") CmRoleMenuExample example);

    int updateByExample(@Param("record") CmRoleMenu record, @Param("example") CmRoleMenuExample example);

    @Select("SELECT m.* FROM cm_role_menu rm,cm_user u,cm_user_role ur,cm_menu m WHERE u.USERNAME = #{username} AND u.USER_ID=ur.USER_ID AND ur.ROLE_ID=rm.ROLE_ID AND rm.MENU_ID=m.MENU_ID")
    List<CmRoleMenu> findAllMenu(String username);
}