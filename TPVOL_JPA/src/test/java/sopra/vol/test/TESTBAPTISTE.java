package sopra.vol.test;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import sopra.vol.Application;
import sopra.vol.model.Adresse;
import sopra.vol.model.Client;
import sopra.vol.model.Particulier;
import sopra.vol.repository.IAdresseRepository;
import sopra.vol.repository.IClientRepository;

public class TESTBAPTISTE  {
	@Test
	public void adresseClientCreate() {
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		IClientRepository clientRepo = Application.getInstance().getClientRepo();
		Client baptiste= new Particulier();
		baptiste.setNom("Dessandier");
		((Particulier) baptiste).setPrenom("Baptiste");
		Adresse adr = new Adresse();
		adr.setClient(baptiste);
		adr.setCodePostal("86000");
		adr.setRue("45 rue des Carmélites");
		adr.setComplement("appt 15");
		adr.setVille("Poitiers");
		
		try {
		adr = adresseRepo.save(adr);
		Assert.fail("Vérification commentaires obligatoire en erreur");
		baptiste=clientRepo.save(baptiste);
		Assert.fail("Vérification commentaires obligatoire en erreur");
		} catch(PersistenceException e) {
		}
		Adresse adrFind = adresseRepo.findById(adr.getId());
		Assert.assertEquals("86000", adrFind.getCodePostal());
		Assert.assertEquals("45 rue des Carmélites", adrFind.getRue());
		Assert.assertEquals("appt 15", adrFind.getComplement());
		Assert.assertEquals("Poitiers", adrFind.getVille());
		Assert.assertEquals(baptiste, adrFind.getClient());
		
		Client batFind = clientRepo.findById(baptiste.getId());
		Assert.assertEquals("Dessandier", batFind.getNom());
		Assert.assertEquals("Baptiste", ((Particulier) batFind).getPrenom());
		
	}
//	@Test
//	public void adresseClientUpdate() {
//		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
//		IClientRepository clientRepo = Application.getInstance().getClientRepo();
//		Client baptiste= new Particulier();
//		baptiste.setNom("Dessandier");
//		((Particulier) baptiste).setPrenom("Baptiste");
//		Adresse adr = new Adresse();
//		adr.setClient(baptiste);
//		adr.setCodePostal("86000");
//		adr.setRue("45 rue des Carmélites");
//		adr.setComplement("appt 15");
//		adr.setVille("Poitiers");
//		adr = adresseRepo.save(adr);
//		eval = evaluationRepo.findById(eval.getId());
//		eval.setComportemental(18);
//		eval.setTechnique(12);
//		eval.setCommentaires("A demissionné de son mandat");
//		eval = evaluationRepo.save(eval);
//		eval = evaluationRepo.findById(eval.getId());
//		Assert.assertEquals((Integer) 18, eval.getComportemental());
//		Assert.assertEquals((Integer) 12, eval.getTechnique());
//		Assert.assertEquals("A demissionné de son mandat", eval.getCommentaires());
//	}
	
}