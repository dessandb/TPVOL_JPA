package sopra.vol.test;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import sopra.vol.Application;
import sopra.vol.model.Passager;
import sopra.vol.model.TypeIdentite;
import sopra.vol.repository.IPassagerRepository;

public class TEST_PASSAGER_AUBE extends TestCase {
	
	@Test
	public void passagerCreate() {
		IPassagerRepository passagerRepo = Application.getInstance().getPassagerRepo();
		Passager passager = new Passager("PECQUE", "Aubeline", "123456789FR", TypeIdentite.CARTE_IDENTITE);
		passager = passagerRepo.save(passager);

		passager = passagerRepo.findById(passager.getId());

		Evaluation evalFind = evaluationRepo.findById(eval.getId());
		Assert.assertEquals((Integer) 15, evalFind.getComportemental());
		Assert.assertEquals((Integer) 13, evalFind.getTechnique());
		Assert.assertEquals("super délégué", evalFind.getCommentaires());
	}
	@Test
	public void evaluationUpdate() {
		IEvaluationRepository evaluationRepo = Application.getInstance().getEvaluationRepo();
		Evaluation eval = new Evaluation(15, 13, "super délégué");
		eval = evaluationRepo.save(eval);
		eval = evaluationRepo.findById(eval.getId());
		eval.setComportemental(18);
		eval.setTechnique(12);
		eval.setCommentaires("A demissionné de son mandat");
		eval = evaluationRepo.save(eval);
		eval = evaluationRepo.findById(eval.getId());
		Assert.assertEquals((Integer) 18, eval.getComportemental());
		Assert.assertEquals((Integer) 12, eval.getTechnique());
		Assert.assertEquals("A demissionné de son mandat", eval.getCommentaires());
	}
}