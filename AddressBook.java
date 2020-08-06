import java.util.*;

public class AddressBook {
    private static List<Data> contact = new ArrayList<Data>();
    private static List<Data> contact1;

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();


        Scanner sc = new Scanner(System.in);
        int menu;
        String choice;

        System.out.println(" 0. Exit. ");
        System.out.println(" 1. Add contact. ");
        System.out.println(" 2. Edit contact. ");
        System.out.println(" 3. Print all contacts. ");
        System.out.println(" 4. Delete contact. ");
        System.out.println("5.Sort list by name in descending order");
        menu = sc.nextInt();

        while (menu != 0) {

            switch (menu) {

                case 1:
                    while (menu != 2) {
                        System.out.println("Enter First Name: ");
                        String firstName = sc.next();
                        System.out.println("Enter Last Name: ");
                        String lastName = sc.next();
                        System.out.println("Enter email: ");
                        String email = sc.next();
                        contact.add(new Data(firstName, lastName, email));// Creating a new object and adding it to list
                        System.out.println("Would you like to add someone else? 1: Yes, 2: No");
                        menu = sc.nextInt();
                    }
                    break;

                case 2:
                    System.out.println("Enter name of contact that you would like to edit: ");
                    int index = sc.nextInt();
                    System.out.println("Enter First Name: ");
                    String fName = sc.next();
                    System.out.println("Enter Last Name: ");
                    String lName = sc.next();
                    System.out.println("Enter email: ");
                    String mail = sc.next();
                    contact.set(index,new Data(fName,lName,mail));
                    break;
                case 3:
                    //System.out.println(addressBook.contact);
                    System.out.println("ArrayList ");
                    for(Data data: contact)
                        System.out.println(data);
                    break;
                case 4:
                    System.out.println("Enter the first name to delete ");
                    choice = sc.next();
                    deleteByFirstName(choice);
                    break;

                case 5:
                    contact.sort(new NameSorter());
                    System.out.println(contact);
            }

            System.out.println(" 0. Exit. ");
            System.out.println(" 1. Add contact. ");
            System.out.println(" 2. Edit contact. ");
            System.out.println(" 3. Print all contacts. ");
            System.out.println(" 4. Delete contact. ");
            System.out.println("5.Sort list by name in descending order");
            menu = sc.nextInt();
        }
        System.out.println("Goodbye!");

    }

    private void addData(String firstName, String lastName, String email) {
        Data person = new Data(firstName, lastName, email);
        contact.add(person);
    }
    private static void deleteByFirstName(String firstName) {
        for (Iterator<Data> iterator = contact.iterator(); iterator.hasNext();) {
            Data temp = iterator.next();
            if (temp.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                return;
            }
        }

        System.out.println("No contact with first name " + firstName + " was found.");
    }


    public static class NameSorter implements Comparator<Data>
    {
        @Override
        public int compare(Data o1, Data o2) {
            return o2.getFirstName().compareToIgnoreCase(o1.getFirstName());
        }
    }
}


