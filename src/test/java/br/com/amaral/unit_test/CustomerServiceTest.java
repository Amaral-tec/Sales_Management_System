package br.com.amaral.unit_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.amaral.dao.CustomerDaoMock;
import br.com.amaral.dao.ICustomerDAO;
import br.com.amaral.domain.Customer;
import br.com.amaral.exceptions.DAOException;
import br.com.amaral.services.CustomerService;
import br.com.amaral.services.ICustomerService;

/**
 * @author leandro.amaral
 *
 */
public class CustomerServiceTest {

	private ICustomerService customerService;

	private Customer customer;

	public CustomerServiceTest() {
		ICustomerDAO dao = new CustomerDaoMock();
		customerService = new CustomerService(dao);
	}

	@Before
	public void init() {
		customer = new Customer();
		customer.setName("Customer Test");
		customer.setCpf(12345678912L);
		customer.setMobilePhone(84999992222L);
		customer.setEmail("teste@email.com");
		customer.setAddress("Street test");
		customer.setNumber(1);
		customer.setDistrict("District test");
		customer.setCity("City test");
		customer.setState("State test");
		customer.setCep(50000000L);
		customer.setPassword("123");
		customer.setPhoto("link");
	}

//	@Test
//	public void saveCustomer() throws KeyTypeNotFoundException, DAOException {
//		Boolean result = customerService.save(customer);
//		Assert.assertTrue(result);
//	}

	@Test
	public void searchCustomer() throws DAOException {
		Customer customerConsulted = customerService.searchForCpf(customer.getCpf());
		Assert.assertNotNull(customerConsulted);
	}

//	@Test
//	public void deleteCustomer() throws DAOException {
//		customerService.delete(customer.getCpf());
//	}
//
//	@Test
//	public void updateCustomer() throws KeyTypeNotFoundException, DAOException {
//		customer.setName("Name Update");
//		customer.setCpf(12345678912L);
//		customer.setMobilePhone(84999992222L);
//		customer.setEmail("update@email.com");
//		customer.setAddress("Street Update");
//		customer.setNumber(1);
//		customer.setDistrict("Update");
//		customer.setCity("Update");
//		customer.setState("Update");
//		customer.setCep(50000000L);
//		customer.setPassword("123");
//		customer.setPhoto("link");
//
//		customerService.update(customer);
//		Assert.assertEquals("Name Update", customer.getName());
//		customerService.update(customer);
//	}
}