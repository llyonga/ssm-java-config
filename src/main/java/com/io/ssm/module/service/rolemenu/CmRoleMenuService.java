package com.io.ssm.module.service.rolemenu;

import com.io.ssm.module.domain.rolemenu.CmRoleMenu;
import com.io.ssm.module.domain.rolemenu.CmRoleMenuMapper;
import com.io.ssm.module.service.common.BaseService;
import com.io.ssm.module.service.common.PageListDto;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/18
 * @time: 10:24
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CmRoleMenuService implements BaseService<CmRoleMenu> {

    @Autowired
    private CmRoleMenuMapper cmRoleMenuMapper;

    @Override
    public long countByExample(CmRoleMenu cmRoleMenu) {
        return 0;
    }

    @Override
    public int deleteByExample(CmRoleMenu cmRoleMenu) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return 0;
    }

    @Override
    public int insert(CmRoleMenu cmRoleMenu) {
        return 0;
    }

    @Override
    public int insertSelective(CmRoleMenu cmRoleMenu) {
        return 0;
    }

    @Override
    public PageListDto<CmRoleMenu> selectByExampleWithRowbounds(CmRoleMenu cmRoleMenu, RowBounds rowBounds, String orderBy) {
        return null;
    }

    @Override
    public PageListDto<CmRoleMenu> selectByExampleWithRowbounds(CmRoleMenu cmRoleMenu, RowBounds rowBounds) {
        return null;
    }

    public List<CmRoleMenu> findAllMenu(String username) {
        return cmRoleMenuMapper.findAllMenu(username);
    }

    @Override
    public List<CmRoleMenu> selectByExample(CmRoleMenu cmRoleMenu) {
        return null;
    }

    @Override
    public CmRoleMenu selectByPrimaryKey(Long var) {
        return null;
    }

    @Override
    public int updateByExampleSelective(CmRoleMenu cmRoleMenu) {
        return 0;
    }

    @Override
    public int updateByExample(CmRoleMenu cmRoleMenu) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(CmRoleMenu cmRoleMenu) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CmRoleMenu cmRoleMenu) {
        return 0;
    }
}
