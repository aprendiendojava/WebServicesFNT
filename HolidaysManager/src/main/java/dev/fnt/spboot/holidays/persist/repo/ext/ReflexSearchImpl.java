package dev.fnt.spboot.holidays.persist.repo.ext;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReflexSearchImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements ReflexSearchCustom<T,ID> {
	public ReflexSearchImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager=entityManager;
		this.entityInformation=entityInformation;
	}

	private EntityManager entityManager;
	private JpaEntityInformation<T,ID> entityInformation;

	@Override
	@Transactional
	public Iterable<T> like(T object) {
		StringBuilder sql = new StringBuilder( String.format( "FROM %s t WHERE ", entityInformation.getEntityName()));
		String condition;

		for (Field f : object.getClass().getDeclaredFields())
		{
			if ( f.getAnnotationsByType(ManyToOne.class).length == 0
				&& f.getAnnotationsByType(ManyToMany.class).length==0
				&& f.getAnnotationsByType(OneToMany.class).length == 0
				&& f.getAnnotationsByType(OneToOne.class).length == 0
				&& f.getAnnotationsByType(Embedded.class).length == 0
				&& f.getAnnotationsByType(JsonIgnore.class).length == 0)
			{
				Column c = f.getAnnotation(Column.class);
				if ( c == null || c.insertable() || c.updatable()) {
					condition = String.format( " ( :%1$s IS NULL OR t.%1$s LIKE :%1$s )", f.getName());
					sql.append(condition).append(" AND ");
				}
			}
		}
		sql.delete(sql.length()-5,sql.length()-1);
		Query q = entityManager.createQuery(sql.toString());
		Object param;
		for (Field f : object.getClass().getDeclaredFields())
		{
			if ( f.getAnnotationsByType(ManyToOne.class).length == 0
					&& f.getAnnotationsByType(ManyToMany.class).length==0
					&& f.getAnnotationsByType(OneToMany.class).length == 0
					&& f.getAnnotationsByType(OneToOne.class).length == 0
					&& f.getAnnotationsByType(Embedded.class).length == 0
					&& f.getAnnotationsByType(JsonIgnore.class).length == 0)
			{
				Column c = f.getAnnotation(Column.class);
				if ( c == null || c.insertable() || c.updatable()) {
					try {
						f.setAccessible(true);
						param = f.get(object);
						q.setParameter(f.getName(), (param != null && param instanceof String)?param.toString():param);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		List<T> r = q.getResultList();
		try {
			System.out.println(new ObjectMapper().writer().writeValueAsString(r.toArray()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(sql);
		return r;
	}

}
