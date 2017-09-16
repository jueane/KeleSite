package kele.dao;

import kele.entity.Message;
import kele.util.Pager;

public interface MessageDao {
	
	int insert(Message message);

	boolean update(Message message);
	
	boolean delete(int id);

	Message getById(int id);
	
	Pager getPagedList(Pager pager);

}
