package com.webp.p7;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{
	
	@Query("select b from Bank b where id=?1 order by tdate desc")
	List<Bank> findByIdOrderByTdateDesc(String id);
	
}