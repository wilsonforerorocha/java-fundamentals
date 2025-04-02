package fundamentals;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Optional best practices
 */
public class OptionalsBestPractice {

    public String testOptionals() throws Exception {
        //https://dev.to/ivangavlik/how-to-use-the-optional-class-java-3pf5

        //Don't assign null to an optional variable
        Optional<Person> person = null;/**/

        //Solution: use empty()
        Optional<Person> person2 = Optional.empty();

        //2. Never call get() directly to get the value
        Optional<Person> person3 = PersonService.getPerson();
        Person myPerson = person3.get();

        //Solution: check value with isPresent() before calling get()
        Optional<Person> person4 = PersonService.getPerson();
        if (person4.isPresent()) {
            Person myPerson2 = person4.get();
        }
        Person myPerson2 = person4.get();

        //What to return when there is no value present

        //1. Don't use isPresent()-get() to return default value
        final Optional<String> status = Optional.empty();
        if (status.isPresent()) {
            return status.get();
        } else {
            return "UNKNOWN";
        }

        //Solution: use orElse()
        //  return status.orElse("UNKNOWN");

        //2. Don't use orElse() to return computed value

        // it is called even if "status" is not empty
        //   return status.orElse(computeStatus());

        //Solution: use orElseGet()
        // computeStatus() is called only if "status" is empty
        // return status.orElseGet(this::computeStatus2);


        //3. Use orElseThrow() to throw a exception
        //  return status.orElseThrow(Exception::new);


        //How to consume optional values

        //1. Use ifPresent() to consume value or isPresentOrElse() to handle empty case
     /*   status.ifPresent(System.out::println);
        status.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Status not found")
        );*/

        //2. Use or() to return other Optional
        //   return status.or(() -> Optional.of("PENDING")).get();

        //3. orElse()/orElseThrow() goes nicely with streams and lamdbas (don't break a chain)
        //   final var products = List.of(new Product(200));

     /*   return products.stream()
                .filter(e -> e.getPrice() > 200)
                .findFirst()
                .map(Product::getName)
                .orElse("Not found");*/

        //  Optional<Cart> cart = Optional.of(new Cart());
    /*    Product product = new Product(100);
        return cart
                .filter(e -> e.getItems().contains(product))
                .map(a -> "test")
                .orElseThrow();*/

        //Anti-patterns
        // 1. Don't overuse Optional by chaining its methods for purpose of getting value

        //  final String status4 = "Test";
        //   return Optional.ofNullable(status4).orElse("Pending");

        //Solution
        //  return status4 != null ? status4 : "Pending";

        // 3. Don't use Optional as element in Collections or Maps

        //4. Avoid boxing and unboxing use non-generic Optional

        //   OptionalInt priceInt = OptionalInt.of(50);
        //   OptionalLong priceLong = OptionalLong.of(50L);

        //5. When designing APIs don't declare filed of type Optional it is not value itself
        // doesn't implement Serializable. It is not intended for use as a property of Java Bean

        //6. Do not use Optional as constructor or method argument.
        //Solution: make get method return Optional


        //Best practices
        //1. There is no need to Unwrap OptionalsBestPractice for asserting or testing equality

        /*
        Optional<String> actual = ...;
        Optional<String> expected = ...;
        assertEquals(expected, actual);
        */


        //2. Reject wrapped values using .filter()

        /*return password
                .filter(p -> p.length() > 5)
                .isPresent();*/

        //3.Use map() or flatMap() to transform value - no need to use isPresent()


        // transform name to uper case if null return Optional.empty()
        /*return lowerName
                .map(String::toUpperCase);
        */

        //3.Use stream() to treat the Optional instance as Stream

        /*List<Prodcut> products = productsId.stream()
                .map(this::fetchProductById)
                .flatMap(Optional::stream)
                .collect(toList());

        Optional<Product> fetchProductById(String id) {*/
    }


    private List<String> getSomethingList() {
        //2. Don't use Optional to return empty Collections or Arrays

        //Solution: Rely on Collections.emptyList()
        final var itemsList = List.of("");
        return itemsList == null ? Collections.emptyList() : itemsList;
    }

    class Person {
        private final String name;

        Person(String name) {
            this.name = name;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }
    }

    class PersonService {
        public static Optional<Person> getPerson() {
            return java.util.Optional.empty();
        }
    }

    class Product {
        int price;
        String name;

        public Product(int price) {
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return "test";
        }
    }

    class Status {

    }

    class Cart {
        public Cart() {

        }

        public List<Product> getItems() {
            return List.of(new Product(100));
        }
    }


    private static String computeStatus() {
        return "";
    }

    private String computeStatus2() {
        return "";
    }
}

