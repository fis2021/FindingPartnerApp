package FPA.Services;

import FPA.Customer.customer;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.List;
import java.util.Objects;

import static FPA.Services.FyleSystemService.getPathToFile;
import static org.dizitart.no2.objects.filters.ObjectFilters.eq;

public class CustomerServices {
    private static ObjectRepository<customer> CustomerRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Customer.db").toFile())
                .openOrCreate("test","test" );

        CustomerRepository = database.getRepository(customer.class);
    }
    public static void addCustomer(String username, String customer_role, String rank, String partner_role){
        for(customer c:CustomerRepository.find())
        {
            if(Objects.equals(c.getUsername(),username))
            {
               delete_customer(username);
               CustomerRepository.insert(new customer(username,customer_role,rank,partner_role));
            }
            else
            {
                CustomerRepository.insert(new customer(username,customer_role,rank,partner_role));
            }
        }
    }

    public static ObjectRepository<customer> getCustomerRepository() {
        return CustomerRepository;
    }

    public static List<customer> getCustomer() {
        return CustomerRepository.find().toList();
    }

    public static void delete_customer(String legion) {
        CustomerRepository.remove(eq("username",legion));
    }
}
