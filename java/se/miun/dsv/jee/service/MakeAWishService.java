package se.miun.dsv.jee.service;

import java.util.List;

import se.miun.dsv.jee.model.LittleKid;

public interface MakeAWishService {

	void makeAWish(LittleKid pKid, List<String> pToy) throws Exception;
	List<LittleKid> loadWishes() throws Exception;
}