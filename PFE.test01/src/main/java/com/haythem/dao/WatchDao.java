package com.haythem.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.haythem.persistance.Watch;

public interface WatchDao extends JpaRepository<Watch, Long>{

	Watch findBywatchSerialNumberLike(String watchSerialNumber);
}
