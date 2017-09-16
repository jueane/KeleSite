package kele.dao;


import kele.entity.SysUser;
import kele.util.Pager;

public interface SysUserDao {
	
	int insert(SysUser user);

	boolean update(SysUser sysUser);
	
	boolean delete(int id);

	SysUser getById(int id);
	
	Pager getPagedList(Pager pager);
	
	SysUser validate(SysUser user);
}
