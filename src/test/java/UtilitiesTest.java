import models.Address;
import org.junit.jupiter.api.Test;
import services.AddressService;
import services.SalaryService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UtilitiesTest {

    @Test
    void getAddresses() {
        AddressService addressService = mock(AddressService.class);

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("address 1", "city1"));
        addressList.add(new Address("address 2", "city1"));
        addressList.add(new Address("address 3", "city"));
        addressList.add(new Address("address 4", "city"));


        List<Address> resultAddressList = new ArrayList<>();
        resultAddressList.add(new Address("address 1", "city1"));
        resultAddressList.add(new Address("address 2", "city1"));

        when(addressService.getAllAddresses()).thenReturn(addressList);

        Utilities utilities = new Utilities();

        List<Address> filteredAddresses = utilities.getAddressByCity(addressService, "city1");

        assertEquals(resultAddressList.size(), filteredAddresses.size());

    }

    @Test
    void getSalaries() {
        SalaryService salaryService = mock(SalaryService.class);

        List<Integer> salariesList = new ArrayList<>();
        salariesList.add(50000);
        salariesList.add(51000);
        salariesList.add(52000);
        salariesList.add(53000);


        List<Integer> resultSalariesList = new ArrayList<>();

        resultSalariesList.add(51000);
        resultSalariesList.add(52000);
        resultSalariesList.add(53000);

        when(salaryService.getSalaries()).thenReturn(salariesList);

        Utilities utilities = new Utilities();

        List<Integer> filteredSalaries = utilities.getSalariesAbove(salaryService, 50000);

        assertEquals(resultSalariesList.size(), filteredSalaries.size());

    }
}