package com.webp.p7;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository extends JpaRepository<Star, Integer>{
	@Transactional
	@Modifying
	@Query("update Star s set s.count=s.count+1 where name=?1")
	int updateCount(String name);
	@Transactional
	@Modifying
	@Query("update Star s set s.count=0")
	int starReset();
}