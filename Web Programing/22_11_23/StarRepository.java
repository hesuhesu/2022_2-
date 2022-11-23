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
	@Query("update Star s set s.count_semi=s.count_semi+1 where name=?1")
	int updateCount_semi(String name);
	@Transactional
	@Modifying
	@Query("update Star s set s.count_final=s.count_final+1 where name=?1")
	int updateCount_final(String name);
	@Transactional
	@Modifying
	@Query("update Star s set s.count_semi =s.count_semi - 1 where name=?1")
	int updateCount_semi_delete(String name);
	@Transactional
	@Modifying
	@Query("update Star s set s.count_semi=0")
	int starReset1();
	@Transactional
	@Modifying
	@Query("update Star s set s.count_final=0")
	int starReset2();
}