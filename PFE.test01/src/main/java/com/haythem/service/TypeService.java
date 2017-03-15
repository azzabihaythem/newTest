package com.haythem.service;

import java.util.List;


import com.haythem.persistance.Type;

public interface TypeService {
	public void save(Type type);
	public Type findOne(Long type);
	public void delete(Long long1);
	public List<Type> findAll();
	public void update(Long idType,String eXONERE,String mSP,String mTHTAXE,String mTTVA,String typeName);
	public void create(String eXONERE,String mSP,String mTHTAXE,String mTTVA,String typeName);
	public  List<String> findAllName();
	public Type findByTypeNameLike(String typeName);
}
