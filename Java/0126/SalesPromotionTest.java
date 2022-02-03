package function2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SalesPromotionTest {
    final static Customer[] customers = {
            new Customer("John Smith", "9084321212", "football",
                    "Giants", 3.61, null, 0, null),
            new Customer("Indira Patel", "7325551234", "tennis",
                    null, 3.92, "Java", 0, null),
            new Customer("Sarah Johnson", "2123231245", "football",
                    "Eagles", 3.71, null, 1,
                    "Jane Hernadez,2017765765"),
            new Customer("Javier Jones", "8568768765", "golf",
                    null, 3.85, "Physics", 1,
                    "Maria Regina,9086547654")
    };

    private static void matchCustomers(Customer c, List<BiFunction<Customer, Integer, ? extends Record>> f) {
        for (int j = 0; j < f.size(); ++j) {
            Record record;
            int index = 0;
            do {
                record = f.get(j)
                        .apply(c, index);
                if (record != null) {
                    System.out.println(record);
                    index = record.index + 1;
                }
            } while (record != null);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BiFunction<Customer, Integer, SportRecord> fsport = (x, z) -> {

            SportRecord sport = null;
            for (int i = z; i < customers.length && sport == null; ++i) {
                if (customers[i].sport.equals(x.sport))
                    sport = new SportRecord(customers[i].name, customers[i].phoneNum, i, customers[i].team);
            }
            return sport;
        };

        BiFunction<Customer, Integer, SportRecord> fgpa = (x, z) -> {

            SportRecord gpa = null;
            for (int i = z; i < customers.length && gpa == null; ++i) {
                if (customers[i].gpa >= (x.gpa))
                    gpa = new SportRecord(customers[i].name, customers[i].phoneNum, i, customers[i].team);
            }
            return gpa;
        };

        BiFunction<Customer, Integer, SportRecord> ffriends = (x, z) -> {

            SportRecord friends = null;
            for (int i = z; i < customers.length && friends == null; ++i) {
                if (customers[i].numFriends >= (x.numFriends))
                    friends = new SportRecord(customers[i].name, customers[i].phoneNum, i, customers[i].team);
            }
            return friends;
        };

        List<BiFunction<Customer, Integer, ? extends Record>> list = new ArrayList<>();
        list.add(fsport);
        list.add(fgpa);
        list.add(ffriends);

        System.out.println(
                "SUNDAY FOOTBALL PROMOTION - Call the following customers:");
        matchCustomers(new Customer(null, null, "football", null,
                Double.MAX_VALUE, null, Integer.MAX_VALUE, null), list);

        System.out.println(
                "TUESDAY HIGH-TECH PROMOTION - Call the following customers:");
        matchCustomers(new Customer(null, null, null, null, 3.75,
                null, Integer.MAX_VALUE, null), list);

        System.out.println(
                "FRIDAY BRING A FRIEND PROMOTION - Call the following customers:");
        matchCustomers(new Customer(null, null, null, null,
                Double.MAX_VALUE, null, 1, null), list);
    }
    }
}