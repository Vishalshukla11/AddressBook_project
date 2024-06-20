//this class will manage the collection of person 
import java.util.*;
class AddressBook
{
   
private List<Person> persons;

//constructor 
public AddressBook()
{
    this.persons=new ArrayList<>();
}

//method to add a new person 
public void addPerson(Person person)
{
    if(!isDuplicate(person))
    {
        persons.add(person);
    }
    else
    {
        System.out.println("Duplicate entry ");
    }
}

//method to edit  an existing person's details 
public void editPerson(String PhoneNumber)
{
    
    Scanner sc= new Scanner(System.in);
   for(int i=0;i<persons.size();i++)
   {
    Person person=persons.get(i);

    if(person.getPhoneNumber().equals(PhoneNumber) )
    {
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
       int choice=sc.nextInt();
       sc.nextLine();

       switch(choice)
       {
        case 1 : 
        System.out.println("Enter first name:");
        String newFirstName=sc.nextLine();
        person.setFirstName(newFirstName);
        break;

        case 2 :
        System.out.println("Enter  new last name ");
        String newLastName=sc.nextLine();
        person.setLastName(newLastName);
        break;

        case 3 :
        System.out.println("Enter new address : ");
        String newAddress=sc.nextLine();
        person.setAddress(newAddress);
        break;

        case 4 : 
        System.out.println("Enter new City :");
        String newCity =sc.nextLine();
        person.SetCity(newCity);
        break;

        case 5 :
        System.out.println("Enter new State : ");
        String newState =sc.nextLine();
        person.setState(newState);
        break;

        case 6 : 
        System.out.println("Enter new ZIP ");
        String newZip=sc.nextLine();
        person.setZip(newZip);
        break;

        case 7 : 
        System.out.println("Enter new Phone Number : ");
        String newPhoneNumber=sc.nextLine();
        person.setPhoneNumber(newPhoneNumber);
        break;

        case 8 :
        System.out.println("Enter new Email : ");
        String newEmail=sc.nextLine();
        person.setPhoneNumber(newEmail);
        break;

        default : 
        System.out.println("invalid choivce . ");
        return;
        
    }

    //update the person in the list 
    persons.set(i,person);
    System.out.println("Person details updates successfully.");
    }

   }
   System.out.println("person not found.");
}

//method to delete a person 
public void deletePerson(String PhoneNumber)
{
    Iterator<Person> iterator=persons.iterator();
    /*Iterator<Person> iterator: Declares an iterator to traverse the persons collection.
persons.iterator(): Returns an iterator over the elements in the persons collection */

while(iterator.hasNext())//iterator.hasNext(): Checks if there are more elements in the persons collection to iterate over.
{
  Person person=iterator.next();
  //Declares a variable to hold the current Person object in the iteration.
  //iterator.next(): Advances the iterator to the next element and returns it.

  if(person.getPhoneNumber().equals(PhoneNumber))
  {
    iterator.remove();
    /*iterator.remove(): Removes the current element from the persons collection. Using the iterator's remove method 
    is the correct way to remove elements during iteration to avoid ConcurrentModificationException. */
    System.out.println("person deleted successfully");
    return;
  }
}
System.out.println("person not found");

}

//method to check for duplicate enteries 
private boolean isDuplicate(Person newPerson)
{
    for(Person person: persons)
    {
        if(person.getFirstName().equals(newPerson.getFirstName())&& person.getLastName().equals(newPerson.getLastName()))
        {
            return true;
        }
    }
    return false;
}

//method to sort persons by variours criteria
public void sortPersons(Comparator<Person> comparator)
{
    persons.sort(comparator);
}

//method to search person by variour criteria
public List<Person> searchPerson(String searchKey,String searchValue)
{
    List<Person>  result=new ArrayList<>();
    /*List<Person> result: Declares a new ArrayList named result that will
     store Person objects matching the search criteria. */
    for(Person person:persons)
    {
        //. equalIgnorecase() It is used to compare two strings while ignoring their case differences.
        switch(searchKey.toLowerCase())
        //conver to lower case 
        {
       case "name" :
            if(person.getFirstName().equalsIgnoreCase(searchValue) )
        {
            result.add(person);
            System.out.println(result);
        }     
        break;  
        case "city":
        if(person.getCity().equalsIgnoreCase(searchValue))
        {
            result.add(person);
            System.out.println(result);
        }
        break;
        case "state":
        if(person.getState().equalsIgnoreCase(searchValue))
        {
            result.add(person);
            System.out.println(result);
        }
        break;

        case "zip":
        if(person.getZip().equalsIgnoreCase(searchValue))
        {
            result.add(person);
            System.out.println(result);
        }
        break;

        default: 
        System.out.println("invalid search key");
     }
    }
    return result;
}

//method to display all persons
public void displayPersons()
{
    for(Person person:persons)
    {
        System.out.println(person);
    }
}


}