package sopra.vol;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.vol.repository.IClientRepository;
import sopra.vol.repository.IPassagerRepository;
import sopra.vol.repository.jpa.ClientRepositoryJpa;
import sopra.vol.repository.jpa.PassagerRepositoryJpa;

public class Application {

	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-jpa");

	private final IClientRepository clientRepo = new ClientRepositoryJpa();

	private final IPassagerRepository passagerRepo = new PassagerRepositoryJpa();

	public static Application getInstance() {
		return instance;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IClientRepository getClientRepo() {
		return clientRepo;
	}

	public IPassagerRepository getPassagerRepo() {
		return passagerRepo;
	}

}
