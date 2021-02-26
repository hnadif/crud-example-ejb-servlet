package com.linkedin;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CatalogEJBLocal {
	
  public List<CatalogItem> getItems();	 
  
  public void addItem(CatalogItem catalogItem);
  
  public void removeItem(Long idItem);
  
  public CatalogItem updateItem(CatalogItem catalogItem);
  
  public CatalogItem findCatalog(Long idItem);
  
  public List<CatalogItem> searchItems(String mc);	
  
}
