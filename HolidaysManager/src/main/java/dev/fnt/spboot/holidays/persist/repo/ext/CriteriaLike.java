package dev.fnt.spboot.holidays.persist.repo.ext;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CriteriaLike<T, ID extends Serializable> extends Repository<T, ID> {
	public Iterable<T> like(T object);
}
