package com.eazybytes.eazyschool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eazybytes.eazyschool.model.Holiday;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String> {

}
