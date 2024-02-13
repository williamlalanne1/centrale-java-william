package org.centrale.api.repository;

import org.centrale.api.entity.GameEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, Integer> {
    @Query("SELECT COALESCE(MAX(g.id), 0) FROM GameEntity g")
    int findMaxGameEntityId();
}
