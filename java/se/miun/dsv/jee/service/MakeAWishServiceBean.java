package se.miun.dsv.jee.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import se.miun.dsv.jee.model.LittleKid;
import se.miun.dsv.jee.model.Toy;
import javax.ejb.TransactionManagementType;

/**
 * MakeAWishServiceBean implements MakeAWishService 
 * Purpose is to act as a DAO for JPA persistance
 */

@Stateless
@Local(MakeAWishService.class)
@TransactionManagement(value=TransactionManagementType.BEAN)
public class MakeAWishServiceBean implements MakeAWishService {

	@PersistenceContext(name = "example")
	EntityManager manager;
	
	@Resource
	private UserTransaction userTransaction;
	
	@Override
	public void makeAWish(LittleKid pKid, List<String> pToys) throws Exception {
			
		try
 		{
 			userTransaction.setTransactionTimeout(5);
 			userTransaction.begin();
 			
 			List<Toy> toyList = new ArrayList<Toy>();
 			
 			for(String toyName : pToys) {
 				Toy toy = new Toy(toyName, "JPA");
 				toyList.add(toy);
 			}
 			
 			for(Toy toy: toyList)
 				manager.persist(toy);
 			
 			pKid.setToyList(toyList);
 			
			manager.persist(pKid);
			userTransaction.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			userTransaction.rollback();
		}
		
	}

	
	@Override
	public List<LittleKid> loadWishes() throws Exception {
				
		List<LittleKid> kids = null;
		
		try {
			TypedQuery<LittleKid> query = manager.createQuery("select k from LittleKid k", LittleKid.class);
			kids = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kids;
		
	}
	
}
