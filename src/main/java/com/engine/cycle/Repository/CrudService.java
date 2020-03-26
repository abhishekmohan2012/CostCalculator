package com.engine.cycle.Repository;

import com.engine.cycle.models.AbstractModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudService<T extends AbstractModel> extends CrudRepository<T, Long> {

}
