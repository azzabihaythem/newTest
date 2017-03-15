package com.haythem.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haythem.dao.TypeDao;
import com.haythem.persistance.Type;
import com.haythem.service.TypeService;
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDao repository;
	
	
	@Override
	public void save(Type type) {
		repository.saveAndFlush(type);
		
	}

	@Override
	public Type findOne(Long type) {
		return repository.findOne(type);
	}

	@Override
	public void delete(Long long1) {
		repository.delete((long) long1);
		
	}

	@Override
	public List<Type> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(Long idType,String eXONERE,String mSP,String mTHTAXE,String mTTVA,String typeName) {
		Type type = findOne(idType);
		type.setEXONERE(eXONERE);
		type.setMSP(mSP);
		type.setMTHTAXE(mTHTAXE);
		type.setMTTVA(mTTVA);
		type.setTypeName(typeName);
		save(type);
		
		
	}

	@Override
	public void create(String eXONERE, String mSP, String mTHTAXE,
			String mTTVA, String typeName) {
		Type type = new Type();
		type.setEXONERE(eXONERE);
		type.setMSP(mSP);
		type.setMTHTAXE(mTHTAXE);
		type.setMTTVA(mTTVA);
		type.setTypeName(typeName);
		save(type);
		
	}

	@Override
	public  List<String> findAllName() {
		 List<String> typeNameAv = new ArrayList<String>();
		   System.out.println("patient");
			for(com.haythem.persistance.Type u : repository.findAll()){
             
            	
				typeNameAv.add(u.getTypeName());
            
					}
		return typeNameAv;
	}

	@Override
	public Type findByTypeNameLike(String typeName) {
	
		return repository.findByTypeNameLike(typeName);
	}

}
