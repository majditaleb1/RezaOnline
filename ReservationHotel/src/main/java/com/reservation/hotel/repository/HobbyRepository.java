package com.reservation.hotel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.reservation.hotel.domain.Hobby;

public interface HobbyRepository extends PagingAndSortingRepository<Hobby, String>{

}
