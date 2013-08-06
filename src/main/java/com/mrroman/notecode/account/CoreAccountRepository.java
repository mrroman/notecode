package com.mrroman.notecode.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreAccountRepository extends JpaRepository<Account, Long>{

}
