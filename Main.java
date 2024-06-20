import java.util.Scanner;
import java.util.Comparator;
class Main
{
    public static void main(String args[])
    {
        AddressBook address= new AddressBook();
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("Address Book Management System");
            System.out.println("1. add person");
            System.out.println("2. Edit person");
            System.out.println("3. Delete person");
            System.out.println("4. Display all persons");
            System.out.println("5. search persons");
            System.out.println("6. sort person");
            System.out.println("7. Exit");
            System.out.println("choose an option: ");
            int option=sc.nextInt();
            sc.nextLine();
            //consume next Line

            switch(option)
            {
                case 1 :
                System.out.println("Enter first name: ");
                String firstName=sc.nextLine();
                System.out.println("Enter last name: ");
                String lastName=sc.nextLine();
                System.out.println("Enter address: ");
                String Address=sc.nextLine();
                System.out.println("Enter city: ");
                String city=sc.nextLine();
                System.out.println("Enter state: ");
                String state=sc.nextLine();
                System.out.println("Enter zip: ");
                String zip=sc.nextLine();
                System.out.println("Enter phone number");
                String phoneNumber=sc.nextLine();
                System.out.println("Enter email");
                String email=sc.nextLine();
                
                Person newPerson= new Person(firstName,lastName,Address,city,state,zip,phoneNumber,email);
                address.addPerson(newPerson);
                break;

                case 2:
                //edit person 
                System.out.println("Enter the phone number of the person ");
                phoneNumber=sc.nextLine();

                //call the edit person method 
                address.editPerson(phoneNumber);
                break;

                case 3: 
                //Deleted person 
                System.out.println("enter the phone number to delete the address");
                phoneNumber=sc.nextLine();
                //call the delete method to delete the details 
                address.deletePerson(phoneNumber);
                break;

                case 4:
                //display all person
                address.displayPersons();
                break;

                case 5 :
                //search persons
                System.out.println("Enter the searchkey(name/city/state/zip): ");
                String searchKey=sc.nextLine();
                System.out.println("enter Search value");
                String searchvalue=sc.next();
                address.searchPerson(searchKey,searchvalue);
                break;

                case 6 :
                //sort person 
                System.out.println("on what bases you want to sort data ");
                System.out.println("1. Name ");
                System.out.println("2. pincode");
                System.out.println("3. phone number");
                int sortoption=sc.nextInt();
                sc.nextLine();//consume new Line
                
                    switch(sortoption)
                    {
                        case 1 :
                        //sort by name
                        address.sortPersons(Comparator.comparing(Person::getFirstName));
                        System.out.println("person sorted successfully by Name ");
                        break;

                        case 2 :
                        //sort by pincode
                        address.sortPersons(Comparator.comparing(Person::getZip));
                       System.out.println("person sorted successfully by zip code ");
                        break;

                        case 3 :
                        //sort by phone number
                        address.sortPersons(Comparator.comparing(Person::getPhoneNumber));
                       System.out.println("person sorted successfully by phone number ");
                        break;

                        default : 
                        System.out.println("invalid option please enter valid option ");
                    }
                    address.displayPersons();
                    break;
                
                

                case 7 :
                //exit 
                System.out.println("Exit thank you.....");
                sc.close();
                return;
                 

            }
        }
    }
}