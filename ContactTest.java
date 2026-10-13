package contacts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * File: ContactTest.java
 * Author: Eric Long
 * Course: CS 320
 * Project One: Contact Service
 * Description:
 *   JUnit tests for Contact class: constructor & setter validations,
 *   boundary-allowed values, and immutability of contactId.
 */

public class ContactTest {

    private Contact valid() {
        return new Contact("ID12345678", "John", "Doe", "1234567890", "123 Main Street");
    }

    // ----- Valid construction -----
    @Test
    void testValidContact() {
        Contact c = valid();
        assertEquals("ID12345678", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main Street", c.getAddress());
    }

    // ----- Required validation failures -----
    @Test
    void testIdNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "John", "Doe", "1234567890", "Address"));
    }

    @Test
    void testIdTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ABCDEFGHIJKL", "John", "Doe", "1234567890", "Address"));
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", null, "Doe", "1234567890", "Address"));
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "ABCDEFGHIJK", "Doe", "1234567890", "Address")); // 11
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", null, "1234567890", "Address"));
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", "ABCDEFGHIJK", "1234567890", "Address"));
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", "Doe", null, "Address"));
    }

    @Test
    void testPhoneWrongLength() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", "Doe", "123456789", "Address")); // 9 digits
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", "Doe", "12345678901", "Address")); // 11 digits
    }

    @Test
    void testPhoneNonDigits() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", "Doe", "abcdefghij", "Address"));
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", "Doe", "1234567890", null));
    }

    @Test
    void testAddressTooLong() {
        String addr31 = "1234567890123456789012345678901"; // 31
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID12", "John", "Doe", "1234567890", addr31));
    }

    // ----- Boundary-allowed (coverage boosters) -----
    @Test
    void testFirstLastBoundary10() {
        String name10 = "ABCDEFGHIJ";
        Contact c = new Contact("ID12345678", name10, name10, "1234567890", "Addr");
        assertEquals(name10, c.getFirstName());
        assertEquals(name10, c.getLastName());
    }

    @Test
    void testAddressBoundary30() {
        String addr30 = "123456789012345678901234567890"; // 30
        Contact c = new Contact("ID12345678", "John", "Doe", "1234567890", addr30);
        assertEquals(addr30, c.getAddress());
    }

    // ----- Setter success (coverage boosters) -----
    @Test
    void testSettersValid() {
        Contact c = valid();
        c.setFirstName("Jim");
        c.setLastName("Beam");
        c.setPhone("0987654321");
        c.setAddress("456 Elm Street");
        assertEquals("Jim", c.getFirstName());
        assertEquals("Beam", c.getLastName());
        assertEquals("0987654321", c.getPhone());
        assertEquals("456 Elm Street", c.getAddress());
    }

    // ----- Immutability check -----
    @Test
    void testContactIdImmutability() {
        Contact c = valid();
        String id = c.getContactId();
        c.setAddress("Changed");
        c.setFirstName("X");
        c.setLastName("Y");
        c.setPhone("1111111111");
        assertEquals(id, c.getContactId());
    }
}