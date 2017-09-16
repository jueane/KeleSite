package kele.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kele.dao.SysUserDao;
import kele.entity.SysUser;
import kele.service.SysUserService;
import kele.util.Pager;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao userDao;
	
	@Override
	public int insert(SysUser user){
		return userDao.insert(user);
	}

	@Override
	public boolean update(SysUser sysUser){
		return userDao.update(sysUser);
	}

	@Override
	public boolean delete(int id){
		return userDao.delete(id);
	}

	@Override
	public SysUser getById(int id)
	{
		return userDao.getById(id);
	}

	@Override
	public Pager getPagedList(Pager pager){
		return userDao.getPagedList(pager);
	}

	@Override
	public SysUser validate(SysUser user) {
		return userDao.validate(user);
	}
	
	
	
}
