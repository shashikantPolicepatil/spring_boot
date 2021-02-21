/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Product;

/**
 * @author hp
 *
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
