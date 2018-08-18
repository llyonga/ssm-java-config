package com.io.ssm.module.service.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.io.ssm.module.domain.user.CmUser;
import com.io.ssm.module.domain.user.CmUserExample;
import com.io.ssm.module.domain.user.CmUserMapper;
import com.io.ssm.module.service.common.BaseService;
import com.io.ssm.module.service.common.PageListDto;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.io.ssm.framework.utils.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/9
 * @time: 14:46
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CmUserService implements BaseService<CmUser> {

    @Autowired
    private CmUserMapper cmUserMapper;

    @Override
    public long countByExample(CmUser cmUser) {
        return 0;
    }

    @Override
    public int deleteByExample(CmUser cmUser) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return 0;
    }

    @Override
    public int insert(CmUser cmUser) {
        return 0;
    }

    @Override
    public int insertSelective(CmUser cmUser) {
        return 0;
    }

    private CmUserExample getExampleDto(CmUser cmUser) {
        CmUserExample example = new CmUserExample();
        CmUserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(cmUser.getUsername())) {
            criteria.andUsernameLike("%"+cmUser.getUsername()+"%");
        }
        return example;
    }

    @Override
    public PageListDto<CmUser> selectByExampleWithRowbounds(CmUser cmUser, RowBounds rowBounds,String orderBy) {
        CmUserExample example = getExampleDto(cmUser);
        if (!StringUtils.isEmpty(orderBy)) {
            example.setOrderByClause(orderBy);
        }
        long count = cmUserMapper.countByExample(example);
        List<CmUser> list = new ArrayList<CmUser>();
        if (count > 0) {
            list = cmUserMapper.selectByExampleWithRowbounds(example, rowBounds);
        }
        PageListDto<CmUser> pageListDto = new PageListDto<>();
        pageListDto.setRows(list);
        pageListDto.setTotal(count);
        return pageListDto;
    }

    @Override
    public PageListDto<CmUser> selectByExampleWithRowbounds(CmUser cmUser, RowBounds rowBounds) {
        CmUserExample example = new CmUserExample();
        long count = cmUserMapper.countByExample(example);
        List<CmUser> list = new ArrayList<CmUser>();
        if (count > 0) {
            list = cmUserMapper.selectByExampleWithRowbounds(example, rowBounds);
        }
        PageListDto<CmUser> pageListDto = new PageListDto<>();
        pageListDto.setRows(list);
        pageListDto.setTotal(count);
        return pageListDto;
    }

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public CmUser selectByUserName(String username) {
        CmUser cmUser = new CmUser();
        cmUser.setUsername(username);
        List<CmUser> cmUsers = cmUserMapper.selectByExample(getExampleDto(cmUser));
        if (CollectionUtils.isEmpty(cmUsers)) {
            return null;
        }
        return cmUsers.get(0);
    }

    @Override
    public List<CmUser> selectByExample(CmUser cmUser) {
        return null;
    }

    @Override
    public CmUser selectByPrimaryKey(Long var) {
        return cmUserMapper.selectByPrimaryKey(var);
    }

    @Override
    public int updateByExampleSelective(CmUser cmUser) {
        return 0;
    }

    @Override
    public int updateByExample(CmUser cmUser) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(CmUser cmUser) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CmUser cmUser) {
        return 0;
    }
}
