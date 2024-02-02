package com.dultek.ums.service;

import com.dultek.ums.exception.MyExceptions;
import com.dultek.ums.model.Address;
import com.dultek.ums.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    /**
     * Updates an existing address's information based on the provided address object.
     *
     * @param address The address object containing the updated information.
     * @return The updated address after the changes are applied and saved to the database.
     * @throws IllegalArgumentException If the provided address has a null employeeId.
     * @throws MyExceptions.AddressNotFoundException If no address is found in the database with the provided employeeId.
     * @throws DataAccessException If an exception occurs while accessing the data store.
     */
    @Override
    public Address updateAddress(Address address) {
        try {
            // Check if the address has a valid employeeId
            if (address.getEmployeeId() == null) {
                throw new IllegalArgumentException("Employee ID cannot be null for address update.");
            }

            // Retrieve the existing address from the database
            Optional<Address> existingAddressOptional = addressRepository.findById(address.getEmployeeId());

            if (existingAddressOptional.isPresent()) {
                // Update the existing address with the new values
                Address existingAddress = existingAddressOptional.get();
                existingAddress.setStreet(address.getStreet());
                existingAddress.setCity(address.getCity());
                existingAddress.setState(address.getState());
                existingAddress.setZipCode(address.getZipCode());
                // Update other properties as needed

                // Save the updated address back to the database
                return addressRepository.save(existingAddress);
            } else {
                // Handle the case where the address with the given employeeId is not found
                throw new MyExceptions.AddressNotFoundException("Address not found with employee ID: " + address.getEmployeeId());
            }
        } catch (DataAccessException e) {
            // Handle exceptions related to data access, e.g., database connectivity issues
            throw new DataAccessResourceFailureException("Error occurred while updating address in the database.", e);
        }
    }
}
