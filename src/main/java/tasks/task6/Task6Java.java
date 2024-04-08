package tasks.task6;

/** Using pattern matching create function that will greet each user type
 * differently
 */

public class Task6Java {
    public static void greet(Customer user) {
        switch (user.getType()) {
            case GUEST:
                System.out.println("Hello guest user");
                break;
            case REGISTERED_USER:
                if (user.getFullName() != null) {
                    System.out.println("Hello " + user.getFullName());
                } else {
                    System.out.println("Hello " + user.getUsername());
                }
                break;
            case ADMIN:
                System.out.println("Hello " + user.getUsername() + ", you are logged in as an admin user");
                break;
            default:
                System.out.println("Hello unknown user");
        }
    }

    public static void main(String[] args) {
        // Example usage:
        Customer guestUser = new Customer(UserType.GUEST, null, null);
        Customer registeredUser1 = new Customer(UserType.REGISTERED_USER, "Alice", null);
        Customer registeredUser2 = new Customer(UserType.REGISTERED_USER, "Bob", "Bob Dylan");
        Customer adminUser = new Customer(UserType.ADMIN, "AdminUser", null);

        greet(guestUser);
        greet(registeredUser1);
        greet(registeredUser2);
        greet(adminUser);
    }
}

class Customer {
    private UserType type;
    private String username;
    private String fullName;

    public Customer(UserType type, String username, String fullName) {
        this.type = type;
        this.username = username;
        this.fullName = fullName;
    }

    public UserType getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }
}

enum UserType {
    GUEST,
    REGISTERED_USER,
    ADMIN
}
