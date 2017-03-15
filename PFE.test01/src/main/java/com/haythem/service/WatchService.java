package com.haythem.service;

import java.util.List;

import com.haythem.persistance.Watch;

public interface WatchService {
	public void save(Watch watchId);
	public Watch findOne(Long watchId);
	public void delete(Long id);
	public List<Watch> findAll();
	public void saveWatch(String watchSerialNumber,String hardVersion,String softVersion,String communicationType);
	public void editWatch(Long id ,String watchSerialNumber,String hardVersion,String softVersion,String communicationType);
    public Watch findBywatchSerialNumberLike(String watchSerialNumber);
	public String existWatch(String watchSerialNumber);

}
