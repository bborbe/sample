package example.jpa;

import example.domain.Department;
import example.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaTest {

	private final EntityManager manager;

	public JpaTest(final EntityManager manager) {
		this.manager = manager;
	}

	public static void main(final String[] args) {
		final EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		final EntityManager manager = factory.createEntityManager();
		final JpaTest test = new JpaTest(manager);

		final EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEmployees();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listEmployees();

		System.out.println(".. done");
	}

	private void createEmployees() {
		final int numOfEmployees = manager.createQuery("SELECT a FROM Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			final Department department = new Department("java");
			manager.persist(department);

			manager.persist(new Employee("Jakab Gipsz", department));
			manager.persist(new Employee("Captain Nemo", department));

		}
	}

	private void listEmployees() {
		final List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (final Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}

}
