package com.mavenproject.dao;

import java.util.List;

import com.mavenproject.model.Supplier;

public interface Supplierdao {
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public Supplier getSupplierById(int Id);
   public List<Supplier>listSupplier();

}
