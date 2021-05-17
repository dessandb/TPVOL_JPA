package sopra.vol.test;

import junit.framework.TestCase;

public class TEST2 extends TestCase {

}
public class TestJunit4 {
	@Test
	public void evaluationCreate() {
		IEvaluationRepository evaluationRepo = Application.getInstance().getEvaluationRepo();
		Evaluation eval = new Evaluation(15, 13);
		try {
		eval = evaluationRepo.save(eval);
		Assert.fail("Vérification commentaires obligatoire en erreur");
		} catch(PersistenceException e) {
		}
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