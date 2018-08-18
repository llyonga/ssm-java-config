package com.io.ssm.module.service.role;

import com.io.ssm.module.domain.role.CmRole;
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
 * @time: 10:23
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CmRoleService implements BaseService<CmRole> {
    @Override
    public long countByExample(CmRole cmRole) {
        return 0;
    }

    @Override
    public int deleteByExample(CmRole cmRole) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return 0;
    }

    @Override
    public int insert(CmRole cmRole) {
        return 0;
    }

    @Override
    public int insertSelective(CmRole cmRole) {
        return 0;
    }

    @Override
    public PageListDto<CmRole> selectByExampleWithRowbounds(CmRole cmRole, RowBounds rowBounds, String orderBy) {
        return null;
    }

    @Override
    public PageListDto<CmRole> selectByExampleWithRowbounds(CmRole cmRole, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<CmRole> selectByExample(CmRole cmRole) {
        return null;
    }

    @Override
    public CmRole selectByPrimaryKey(Long var) {
        return null;
    }

    @Override
    public int updateByExampleSelective(CmRole cmRole) {
        return 0;
    }

    @Override
    public int updateByExample(CmRole cmRole) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(CmRole cmRole) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CmRole cmRole) {
        return 0;
    }
}
