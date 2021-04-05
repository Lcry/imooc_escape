package com.imooc.spring.escape.transaction_lost;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdAndNameDao extends JpaRepository<IdAndName, Long> {
}
