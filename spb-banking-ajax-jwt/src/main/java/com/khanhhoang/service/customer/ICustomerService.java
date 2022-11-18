package com.khanhhoang.service.customer;

import com.khanhhoang.model.*;
import com.khanhhoang.model.dto.CustomerDTO;
import com.khanhhoang.model.dto.RecipientDTO;
import com.khanhhoang.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    List<CustomerDTO> getAllCustomerDTO();

//    Customer save(Customer customer);

    void softDelete(long customerId);

    List<Customer> findAllByIdNot(long id);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByEmailAndIdIsNot(String email, Long id);

    Optional<CustomerDTO> getByEmailDTO(String email);

    List<RecipientDTO> getAllRecipientDTO(long senderId);

    Customer deposit(Customer customer, Deposit deposit);

    Customer withdraw(Customer customer, Withdraw withdraw);

    Customer transfer(Transfer transfer);

}
