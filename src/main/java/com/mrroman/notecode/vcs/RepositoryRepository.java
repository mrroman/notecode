package com.mrroman.notecode.vcs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface RepositoryRepository extends JpaRepository<Repository, Integer> {

	List<Repository> findByCareEmail(String careEmail);
}
