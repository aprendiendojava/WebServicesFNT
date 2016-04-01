package dev.fnt.spboot.holidays.persist.repo.ext;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute.PersistentAttributeType;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CriteriaLikeImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CriteriaLike<T, ID> {
	private final JpaEntityInformation<T,ID> entityInformation;
	private final EntityManager entityManager;

	public CriteriaLikeImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
	}

	@Override
	public Iterable<T> like(T object) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(entityInformation.getJavaType());
		Root<T> c = q.from(entityInformation.getJavaType());

		q=q.select(c).where(
			entityManager.getMetamodel()
			.entity(entityInformation.getJavaType())
			.getDeclaredSingularAttributes().stream()
			.filter(att->att.getPersistentAttributeType()==PersistentAttributeType.BASIC)
			.map(sa->
			{
				try {
					Field f = null;
					f = entityInformation.getJavaType().getDeclaredField(sa.getName());
					f.setAccessible(true);
					return cb.like(
							c.get(sa.getName()).as(String.class)
						,	f.get(object)==null?"%":f.get(object).toString()
					);	
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			})
			.reduce((pre,acum) -> acum = cb.and(acum,pre)).orElse(null)
		);
		return entityManager.createQuery(q).getResultList();
	}
}
