/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.ice4test.Contact;
import com.mycompany.ice4test.ContactManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Yue Hou
 */
public class ContactManagerTest {
    
    private ContactManager contactManager;
    
    public ContactManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        Contact theContact = new Contact("w", "w", "a@gmail.com"); 
        
        List<Contact> contactList = new ArrayList<>();
        contactList.add(theContact);
        
        contactManager = new ContactManager(contactList);
 
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testFindContactThrowsExceptionWhenListIsEmpty() {
        System.out.println("Find contact expects throw exceptions when if contact list is empty");
        try {
            ContactManager emptyContactManager = new ContactManager();
            emptyContactManager.findContact("nonexistent@example.com");
            fail("Expected RuntimeException was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Cannot find contact. The contact list is empty.", e.getMessage());
        }
    }
    
    @Test
    public void testFindContactExists(){
        System.out.println("Find contact with a@gmail.com, expect contact exisits");
        String searchEmailParam = "a@gmail.com";
        Contact result = contactManager.findContact(searchEmailParam);
        assertNotNull(result);
    }
    
    @Test
    public void testFindContactMatchesExpectedContact(){
        System.out.println("Find contact with a@gmail.com, expect contact information matches expected");
        String searchEmailParam = "a@gmail.com";
        String expectedEmailAddress = "a@gmail.com";
        String expectedLastName = "w";
        String expectedFirstName = "w";
        Contact result = contactManager.findContact(searchEmailParam);
        assertEquals(expectedEmailAddress, result.getEmailAddress());
        assertEquals(expectedLastName, result.getLastName());
        assertEquals(expectedFirstName, result.getFirstName());
    }
    
    @Test
    public void testFindContactReturnsNull(){
        System.out.println("Find contact with b@gmail.com, expect no contact found");
        String searchEmailParam = "b@gmail.com";
        Contact result = contactManager.findContact(searchEmailParam);
        assertNull(result);
    }
    
    @Test
    public void testSearchEmailParamWithWhiteSpaceStillFindsContact(){
        System.out.println("Find contact with white space at the end");
        String searchEmailParam = "a@gmail.com ";
        String expectedEmailAddress = "a@gmail.com";
        String expectedLastName = "w";
        String expectedFirstName = "w";
        Contact result = contactManager.findContact(searchEmailParam);
        assertNotNull(result);
        assertEquals(expectedEmailAddress, result.getEmailAddress());
        assertEquals(expectedLastName, result.getLastName());
        assertEquals(expectedFirstName, result.getFirstName());
    }
    
    @Test
    public void testFindContactCannotFindIfPassInParamIsLastName(){
        System.out.println("Find contact with lastname 'w' ,expect no contact found");
        String searchParam = "w";
        Contact result = contactManager.findContact(searchParam);
        assertNull(result);
    }
}


