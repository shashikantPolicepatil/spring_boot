/**
 * 
 */
package com.example.demo.runner;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.StudentCollectionMapping;
import com.example.demo.repository.StudentColMappingReposiroty;

/**
 * @author hp
 *
 */
@Component
public class CollectionMappingRunner implements CommandLineRunner {

	@Autowired
	StudentColMappingReposiroty repo;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		StudentCollectionMapping save = repo.save(new StudentCollectionMapping("Abc", Set.of("ENG","MAT","SCI"), List.of(76,98,34,55,56,58), Map.of("JAVA","A+",".Net","A")));
		Optional<StudentCollectionMapping> byId = repo.findById(save.getSId());
		StudentCollectionMapping mapping = byId.get();
		System.out.println(mapping);
		
	}

}
