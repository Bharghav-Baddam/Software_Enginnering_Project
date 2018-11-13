package com.buddyfinder.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buddyfinder.main.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	Account findByEmail(String email);

//	@Query("selet jpa query where something = :param")
//	Account findbysaomequery(@ParamSomethingLookMeUp(name = "param" String param);
}
