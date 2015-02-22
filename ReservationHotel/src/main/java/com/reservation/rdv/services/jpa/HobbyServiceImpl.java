package com.reservation.rdv.services.jpa;

import java.util.List;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.reservation.rdv.domain.Hobby;
import com.reservation.rdv.repository.HobbyRepository;
import com.reservation.rdv.services.HobbyService;
@Service("hobbyService")
@Repository
@Transactional
public class HobbyServiceImpl implements HobbyService {

	@Autowired
	private HobbyRepository hobbyRepository;
	@Override
	public List<Hobby> findAll() {
		// TODO Auto-generated method stub
		return Lists.newArrayList(hobbyRepository.findAll());
	}

}
