package sopra.vol.test;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.vol.Application;
import sopra.vol.model.Aeroport;
import sopra.vol.model.Ville;
import sopra.vol.repository.IAeroportRepository;
import sopra.vol.repository.IVilleRepository;

public class TEST_Sarah  {	

	@Test
	public void villeCreate() {
		IVilleRepository villeRepo = Application.getInstance().getVilleRepo();
		Ville ville1 = new Ville("Paris");
		try {
		ville1 = villeRepo.save(ville1);
		//Assert.fail("Vérification commentaires obligatoire en erreur");
		} catch(PersistenceException e) {
		}
		Ville villeFind = villeRepo.findById(ville1.getId());
		Assert.assertEquals("Paris", villeFind.getNom());	
	}
	
	@Test
	public void villeUpdate() {
		IVilleRepository villeRepo = Application.getInstance().getVilleRepo();
		Ville ville1 = new Ville("Paris");
		ville1 = villeRepo.save(ville1);
		ville1 = villeRepo.findById(ville1.getId());
		ville1.setNom("Madrid");
		Assert.assertEquals("Madrid", ville1.getNom());	
	}
	
	@Test
	public void aeroportCreate() {
		IAeroportRepository aeroportRepo = Application.getInstance().getAeroportRepo();
		Aeroport aeroport1 = new Aeroport("rcdg","Roissy");
		try {
			aeroport1 = aeroportRepo.save(aeroport1);		
		} catch(PersistenceException e) {
		}
		Aeroport aeroFind = aeroportRepo.findById(aeroport1.getCode());
		Assert.assertEquals("Roissy", aeroFind .getNom());		
	}
	
	
	@Test
	public void aeroportUpdate() {
		IAeroportRepository aeroportRepo = Application.getInstance().getAeroportRepo();
		Aeroport aeroport1 =  new Aeroport("Roissy");
		aeroport1 = aeroportRepo.save(aeroport1);
		Aeroport aeroFind = aeroportRepo.findById(aeroport1.getCode());
		aeroport1.setNom("Madrid");
		Assert.assertEquals("Madrid", aeroport1.getNom());	
	}
	
	
}

