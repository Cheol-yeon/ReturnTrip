package com.returntrip.dao;

import java.util.List;

import com.returntrip.entity.Image;

public interface ImgDao {

	List<Image> getImgDatas(String parameter);
	
}
