
//this class will manage the collection of person 
import java.util.*;

class AddressBook {

   
    private Map<String,Person> persons;

    // constructor
    public AddressBook() {
        this.persons = new HashMap<>();
    }

    // method to add a new person
    public void addPerson(Person person) {
        String key=person.getFirstName() + " " + person.getLastName();
        if (!persons.containsKey(key)) {
            persons.put(key,person);
        } else {
            System.out.println("Duplicate entry ");
        }
    }

    // method to edit an existing person's details
    public void editPerson(String PhoneNumber) {

        Scanner sc = new Scanner(System.in);
        for (Map.Entry<String,Person>entry:persons.entrySet() ) {
            Person person = entry.getValue();

            if (person.getPhoneNumber().equals(PhoneNumber)) {
                System.out.println("What do you want to edit ");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Address");
                System.out.println("4. City");
                System.out.println("5. State");
                System.out.println("6. Zip");
                System.out.println("7. Phone Number");
                System.out.println("8. Email");
                System.out.print("Enter your choice (1-8): ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter first name:");
                        String newFirstName = sc.nextLine();
                        person.setFirstName(newFirstName);
                        break;

                    case 2:
                        System.out.println("Enter  new last name ");
                        String newLastName = sc.nextLine();
                        person.setLastName(newLastName);
                        break;

                    case 3:
                        System.out.println("Enter new address : ");
                        String newAddress = sc.nextLine();
                        person.setAddress(newAddress);
                        break;

                    case 4:
                        System.out.println("Enter new City :");
                        String newCity = sc.nextLine();
                        person.SetCity(newCity);
                        break;

                    case 5:
                        System.out.println("Enter new State : ");
                        String newState = sc.nextLine();
                        person.setState(newState);
                        break;

                    case 6:
                        System.out.println("Enter new ZIP ");
                        String newZip = sc.nextLine();
                        person.setZip(newZip);
                        break;

                    case 7:
                        System.out.println("Enter new Phone Number : ");
                        String newPhoneNumber = sc.nextLine();
                        person.setPhoneNumber(newPhoneNumber);
                        break;

                    case 8:
                        System.out.println("Enter new Email : ");
                        String newEmail = sc.nextLine();
                        person.setPhoneNumber(newEmail);
                        break;

                    default:
                        System.out.println("invalid choivce . ");
                        return;

                }

                // update the person in the list
                persons.put(entry.getKey(),person);
                System.out.println("Person details updates successfully.");
                return;
            }

        }
        System.out.println("person not found.");
    }

    // method to delete a person
    public void deletePerson(String PhoneNumber) {
        Iterator<Map.Entry<String,Person>> iterator =persons.entrySet().iterator();
        

        while (iterator.hasNext())// iterator.hasNext(): Checks if there are more elements in the persons
                                  // collection to iterate over.
        {
           
            Map.Entry<String,Person>entry=iterator.next();
            if (entry.getValue().getPhoneNumber().equals(PhoneNumber))
             {
                iterator.remove();
                /*
                 * iterator.remove(): Removes the current element from the persons collection.
                 * Using the iterator's remove method
                 * is the correct way to remove elements during iteration to avoid
                 * ConcurrentModificationException.
                 */
                System.out.println("person deleted successfully");
                return;
            }
        }
        System.out.println("person not found");

    }

    // method to check for duplicate enteries
    private boolean isDuplicate(Person newPerson) {
        String key=newPerson.getFirstName()+ " " + newPerson.getLastName();
        return persons.containsKey(key);
    }

    // method to sort persons by variours criteria
    public void sortPersons(Comparator<Person> comparator) {
       // conver the map entries to a list 
       List<Map.Entry<String,Person>> entryList =new ArrayList<>(persons.entrySet());
       //sort rhe lost using comparator 
       entryList.sort(Map.Entry.comparingByValue(comparator));
       //clear the original map
       persons.clear();

       //populate the map with the sorted entries
       for(Map.Entry<String, Person>entry:entryList )
       {
        persons.put(entry.getKey(),entry.getValue());
       }

       //print the sorted persons 
       for(Person person: persons.values())
       {
        System.out.println(person);
       }

    }

    // method to search person by variour criteria
    public void searchPerson(String searchKey, String searchValue) {
        //Map<String,Person> result = new HashMap<>();
        boolean found=false;
        for (Map.Entry<String,Person> entry : persons.entrySet()) {
            Person person=entry.getValue();
            switch (searchKey.toLowerCase())
            // convert to lower case
            {
                case "name":
                    if (person.getFirstName().equalsIgnoreCase(searchValue)|| person.getLastName().equalsIgnoreCase(searchValue)) {
                        
                        System.out.println(person); 
                        found=true;    
                    }
                    break;
                case "city":
                    if (person.getCity().equalsIgnoreCase(searchValue)) {
                        System.out.println(person); 
                        found=true; 
                       
                    }
                    break;
                case "state":
                    if (person.getState().equalsIgnoreCase(searchValue)) {
                        System.out.println(person); 
                        found=true; 
                        
                    }
                    break;

                case "zip":
                    if (person.getZip().equalsIgnoreCase(searchValue)) {
                        System.out.println(person); 
                        found=true; 
                    }
                    break;

                default:
                    System.out.println("invalid search key");
                    return;
            }
        }
        if(!found)
        {
            System.out.println("data not found");
        }
        
    }

    // method to display all persons
    public void displayPersons() {
        for (Person person : persons.values()) {
            System.out.println(person);
        }
    }

}