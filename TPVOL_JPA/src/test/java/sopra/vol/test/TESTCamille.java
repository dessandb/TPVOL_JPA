package sopra.vol.test;

import java.util.Date;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.vol.Application;
import sopra.vol.model.CompagnieAerienne;
import sopra.vol.model.StatutVol;
import sopra.vol.model.Vol;
import sopra.vol.repository.ICompagnieAerienneRepository;
import sopra.vol.repository.IVolRepository;

public class TESTCamille{

	@Test
	public void volCreate() {
		IVolRepository volRepo = Application.getInstance().getVolRepo();
		Date date1=new Date();
		Date date2=new Date();
		Vol vol = new Vol(StatutVol.OUVERT, date1, date2,1000);
		try {
			vol = volRepo.save(vol);
		} catch(PersistenceException e) {
		}
		Vol volFind = volRepo.findById(vol.getId());
		Assert.assertEquals(StatutVol.OUVERT, volFind.getStatutVol());
		Assert.assertEquals(date1, volFind.getDtDepart());
		Assert.assertEquals(date2, volFind.getDtArrivee());
		Assert.assertEquals(1000, volFind.getNbPlaceDispo());		
	}

	@Test
	public void evaluationUpdate() {
		IVolRepository volRepo = Application.getInstance().getVolRepo();
		Date date1=new Date();
		Date date2=new Date();
		Date date3=new Date();
		Date date4=new Date();
		Vol vol = new Vol(StatutVol.OUVERT, date1, date2,1000);
		vol = volRepo.save(vol);
		vol = volRepo.findById(vol.getId());
		vol.setStatutVol(StatutVol.FERME);
		vol.setDtDepart(date3);
		vol.setDtArrivee(date4);
		vol.setNbPlaceDispo(900);
		vol = volRepo.save(vol);
		vol = volRepo.findById(vol.getId());
		Vol volFind = volRepo.findById(vol.getId());
		Assert.assertEquals(StatutVol.FERME, volFind.getStatutVol());
		Assert.assertEquals(date3, volFind.getDtDepart());
		Assert.assertEquals(date4, volFind.getDtArrivee());
		Assert.assertEquals(900, volFind.getNbPlaceDispo());		
	}

	@Test
	public void CompagnieAerienneCreate() {
		ICompagnieAerienneRepository compagnieAeroRepo = Application.getInstance().getCompagnieaerienneRepo();
		CompagnieAerienne compagnie = new CompagnieAerienne("123456", "airlines");
		try {
			compagnie = compagnieAeroRepo.save(compagnie);
		} catch(PersistenceException e) {
		}
		CompagnieAerienne compagnieFind = compagnieAeroRepo.findById(compagnie.getCode());
		Assert.assertEquals("airlines", compagnieFind.getNom());
	}
	@Test
	public void CompagnieAerienneUpdate() { 
		ICompagnieAerienneRepository compagnieAeroRepo = Application.getInstance().getCompagnieaerienneRepo();
		CompagnieAerienne compagnie = new CompagnieAerienne("123456", "airlines");
		compagnie = compagnieAeroRepo.save(compagnie);
		compagnie=compagnieAeroRepo.findById(compagnie.getCode());
		compagnie.setNom("blablablaLines");
		compagnie = compagnieAeroRepo.save(compagnie);
		CompagnieAerienne compagnieFind = compagnieAeroRepo.findById(compagnie.getCode());
		Assert.assertEquals("blablablaLines", compagnieFind.getNom());
	} 

}