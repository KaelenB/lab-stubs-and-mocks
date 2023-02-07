import models.Address;
import services.AddressService;
import services.SalaryService;

import java.util.List;
import java.util.stream.Collectors;

public class Utilities {
    public List<Address> getAddressByCity(AddressService addressService, String cityName) {
        List<Address> allAddresses = addressService.getAllAddresses();
        return allAddresses.stream().filter(x -> x.getCity().equals(cityName)).collect(Collectors.toList());
    }

    public List<Integer> getSalariesAbove(SalaryService salaryService, int i) {
        return salaryService.getSalaries().stream().filter(x -> x > i).collect(Collectors.toList());
    }
}
