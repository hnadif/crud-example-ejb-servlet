package com.linkedin;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class CatalogEJB
 */
@Singleton
@LocalBean
public class CatalogEJB implements CatalogEJBLocal {

	/**
	 * Default constructor.
	 */
	public CatalogEJB() {
	}

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public List<CatalogItem> getItems() {
		return this.entityManager.createQuery("select c from CatalogItem c", CatalogItem.class).getResultList();
	}

	@Override
	public void addItem(CatalogItem catalogItem) {
		this.entityManager.persist(catalogItem);
	}

	@Override
	public void removeItem(Long idItem) {
		CatalogItem catalogItem = this.findCatalog(idItem);
		if (catalogItem != null)
			this.entityManager.remove(catalogItem);
	}

	@Override
	public CatalogItem updateItem(CatalogItem catalogItem) {
		return this.entityManager.merge(catalogItem);
	}

	@Override
	public CatalogItem findCatalog(Long idItem) {
		return this.entityManager.find(CatalogItem.class, idItem);
	}

	@Override
	public List<CatalogItem> searchItems(String mc) {
		TypedQuery<CatalogItem> query = this.entityManager
				.createQuery("select c from CatalogItem c where c.name LIKE :searchKeyword", CatalogItem.class);
		query.setParameter("searchKeyword", "%"+mc.toLowerCase()+"%");
		return query.getResultList();
	}

}
