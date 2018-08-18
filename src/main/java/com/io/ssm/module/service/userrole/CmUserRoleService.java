package com.io.ssm.module.service.userrole;

import com.io.ssm.module.domain.userrole.CmUserRole;
import com.io.ssm.module.service.common.BaseService;
import com.io.ssm.module.service.common.PageListDto;
import org.apache.ibatis.session.RowBounds;
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
public class CmUserRoleService implements BaseService<CmUserRole> {
    @Override
    public long countByExample(CmUserRole cmUserRole) {
        return 0;
    }

    @Override
    public int deleteByExample(CmUserRole cmUserRole) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return 0;
    }

    @Override
    public int insert(CmUserRole cmUserRole) {
        return 0;
    }

    @Override
    public int insertSelective(CmUserRole cmUserRole) {
        return 0;
    }

    @Override
    public PageListDto<CmUserRole> selectByExampleWithRowbounds(CmUserRole cmUserRole, RowBounds rowBounds, String orderBy) {
        return null;
    }

    @Override
    public PageListDto<CmUserRole> selectByExampleWithRowbounds(CmUserRole cmUserRole, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<CmUserRole> selectByExample(CmUserRole cmUserRole) {
        return null;
    }

    @Override
    public CmUserRole selectByPrimaryKey(Long var) {
        return null;
    }

    @Override
    public int updateByExampleSelective(CmUserRole cmUserRole) {
        return 0;
    }

    @Override
    public int updateByExample(CmUserRole cmUserRole) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(CmUserRole cmUserRole) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CmUserRole cmUserRole) {
        return 0;
    }
}
