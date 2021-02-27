package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

}
