package kele.service;

import kele.entity.Message;
import kele.util.Pager;

public interface MessageService {
	
	int insert(Message message);

	boolean update(Message message);
	
	boolean delete(int id);

	Message getById(int id);
	
	Pager getPagedList(Pager pager);


}
