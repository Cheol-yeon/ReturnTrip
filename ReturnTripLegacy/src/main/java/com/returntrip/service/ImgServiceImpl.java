package com.returntrip.service;

import java.util.List;

import com.returntrip.dao.ImgDao;
import com.returntrip.entity.Journey;

public class ImgServiceImpl implements ImgService {

	private ImgDao imgDao;
	
	@Override
	public List<Journey> getImgDatas(String parameter) {
		// TODO Auto-generated method stub
		return imgDao.getImgDatas(parameter);
	}

}
