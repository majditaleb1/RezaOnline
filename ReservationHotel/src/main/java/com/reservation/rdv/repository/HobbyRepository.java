package com.reservation.rdv.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.reservation.rdv.domain.Hobby;

public interface HobbyRepository extends PagingAndSortingRepository<Hobby, String>{

}
