import java.util.*;

public class Contact {
    int id;
    String name;
    String firstName;
    String phoneNumber;
    String email;
    Scanner scanner = new Scanner(System.in);
    Map<Integer, ArrayList<String>> contacts = new HashMap<>();

    public Contact() {
    }
    public void addContact() {
        id = checkId();

        ArrayList<String> contactDetail = new ArrayList<>();

        System.out.println("ADD NAME: ");
        name = scanner.next();
        contactDetail.add(name);

        System.out.println("ADD FIRST NAME: ");
        firstName = scanner.next();
        contactDetail.add(firstName);

        phoneNumber = checkPhoneNumber();

        email = checkEmail();

        contactDetail.add(phoneNumber);
        contactDetail.add(email);

        contacts.put(id, contactDetail);
    }

    public int checkId() {
        int id;
        while (true) {
            try {
                System.out.println("ADD ID: ");
                id = scanner.nextInt();
                if (contacts.containsKey(id)) {
                    System.out.println("ID ALREADY ADDED!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred");
                scanner.next();
            }
        }
        return id;
    }

    public String checkPhoneNumber() {
        while (true) {
            try {
                System.out.println("ADD PHONE NUMBER \n 10 characters needed");
                phoneNumber = scanner.next();
                if (phoneNumber.length() == 10) {
                    return phoneNumber;
                } else {
                    System.out.println("Wrong length");
                }
            } catch (Exception e) {
                System.out.println("An error occurred!");
                scanner.next();
            }
        }
    }

    public String checkEmail() {
        while (true) {
            try {
                System.out.println("ADD EMAIL: ");
                String email = scanner.next();
                if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com")) {
                    return email;
                } else {
                    System.out.println("Invalid email format!");
                }
            } catch (Exception e) {
                System.out.println("An error occurred:");
                scanner.next();
            }
        }
    }
    public void displayContacts() {
        for (Map.Entry<Integer, ArrayList<String>> entry : contacts.entrySet()) {
            System.out.print(entry.getKey() + " ");
            ArrayList<String> contactDetails = entry.getValue();
            System.out.println(contactDetails.get(0) + " " + contactDetails.get(1) + " " + contactDetails.get(2)
                    + " " + contactDetails.get(3));
        }
    }
    public void search() {
        System.out.println("TYPE NAME: ");
        String nameToSearch = scanner.next();
        boolean found = false;
        for (Map.Entry<Integer, ArrayList<String>> entry : contacts.entrySet()) {
            ArrayList<String> contactDetails = entry.getValue();
            String name = contactDetails.get(0);
            if (name.equalsIgnoreCase(nameToSearch)) {
                System.out.println("Contact Found:");
                System.out.println("ID: " + entry.getKey());
                System.out.println(contactDetails.get(0) + " " + contactDetails.get(1) + " " + contactDetails.get(2)
                        + " " + contactDetails.get(3));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found with name: " + nameToSearch);
        }
    }

    public void menu() {
        int option;
        do {
            System.out.println("1. ADD CONTACT.");
            System.out.println("2. DISPLAY CONTACT.");
            System.out.println("3. SEARCH CONTACT.");
            System.out.println("0. EXIT.");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayContacts();
                    break;
                case 3:
                    search();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 0);
    }
}
