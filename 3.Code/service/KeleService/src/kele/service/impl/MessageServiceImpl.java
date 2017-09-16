package kele.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kele.dao.MessageDao;
import kele.entity.Message;
import kele.service.MessageService;
import kele.util.Pager;

@Service
@Transactional
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDao messageDao;
	
	@Override
	public int insert(Message message) {
		return messageDao.insert(message);
	}

	@Override
	public boolean update(Message message) {
		return messageDao.update(message);
	}

	@Override
	public boolean delete(int id) {
		return messageDao.delete(id);
	}

	@Override
	public Message getById(int id) {
		return messageDao.getById(id);
	}

	@Override
	public Pager getPagedList(Pager pager) {
		return messageDao.getPagedList(pager);
	}

}
