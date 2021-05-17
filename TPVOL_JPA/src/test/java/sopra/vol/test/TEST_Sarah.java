package sopra.vol.test;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.vol.Application;
import sopra.vol.model.Ville;
import sopra.vol.repository.IVilleRepository;

public class TEST_Sarah  {	

	@Test
	public void villeCreate() {
		IVilleRepository villeRepo = Application.getInstance().getVilleRepo();
		Ville ville1 = new Ville("Paris");
		try {
		ville1 = villeRepo.save(ville1);
		Assert.fail("Vérification commentaires obligatoire en erreur");
		} catch(PersistenceException e) {
		}
		Ville villeFind = villeRepo.findById(ville1.getId());
		Assert.assertEquals("paris", villeFind.getNom());				

	}
	
	
//	Assert.assertEquals((Integer) 15, evalFind.getComportemental());
//	Assert.assertEquals((Integer) 13, evalFind.getTechnique());
//	Assert.assertEquals("super délégué", evalFind.getCommentaires());
//}
//	eval = evaluationRepo.save(eval);
//	Assert.fail("Vérification commentaires obligatoire en erreur");
//	} catch(PersistenceException e) {
//	}
//	Evaluation evalFind = evaluationRepo.findById(eval.getId());
//	Assert.assertEquals((Integer) 15, evalFind.getComportemental());
//	Assert.assertEquals((Integer) 13, evalFind.getTechnique());
//	Assert.assertEquals("super délégué", evalFind.getCommentaires());
	
//	@Test
//	public void evaluationUpdate() {
//		IEvaluationRepository evaluationRepo = Application.getInstance().getEvaluationRepo();
//		Evaluation eval = new Evaluation(15, 13, "super délégué");
//		eval = evaluationRepo.save(eval);
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

