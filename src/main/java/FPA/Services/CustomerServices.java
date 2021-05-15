package FPA.Services;

import FPA.Customer.customer;
import FPA.annoucements.annoucements;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static FPA.Services.FyleSystemService.getPathToFile;

public class CustomerServices {
    private static ObjectRepository<customer> CustomerRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Customer.db").toFile())
                .openOrCreate("test","test" );

        CustomerRepository = database.getRepository(customer.class);
    }
    public static void addCustomer(String username, String customer_role, String rank, String partner_role){
        CustomerRepository.insert(new customer(username,customer_role,rank,partner_role));
    }

    public static ObjectRepository<customer> getCustomerRepository() {
        return CustomerRepository;
    }
}
