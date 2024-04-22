package com.chandanyadav.pm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandanyadav.pm.entity.ProductEnt;
import com.chandanyadav.pm.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productrepo;
	
	public void addProduct(ProductEnt e)
	{
		productrepo.save(e);
	}
	public List<ProductEnt> displayprod()
	{
		return productrepo.findAll();
	}
	public void delete(long id)
	{
		productrepo.deleteById(id);
	}
	public ProductEnt getProdById(long id)
	{
		Optional<ProductEnt> e = productrepo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
}
