package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * File: ContactServiceTest.java
 * Author: Eric Long
 * Course: CS 320
 * Project One: Contact Service
 * Description:
 *   JUnit tests for ContactService: add/delete/update, duplicate/ null,
 *   validation propagation, multi-add, and state checks.
 */

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setup() {
        service = new ContactService();
    }

    private Contact valid(String id) {
        return new Contact(id, "Jo", "Do", "1234567890", "Addr");
    }

    // ----- Add success & state -----
    @Test
    void testAddSingleContact() {
        assertTrue(service.addContact(valid("ID1")));
        assertEquals(1, service.size());
        assertNotNull(service.getContact("ID1"));
    }

    // ----- Multi-add -----
    @Test
    void testAddMultipleContacts() {
        assertTrue(service.addContact(valid("ID1")));
        assertTrue(service.addContact(valid("ID2")));
        assertTrue(service.addContact(valid("ID3")));
        assertEquals(3, service.size());
    }

    // ----- Null add -----
    @Test
    void testAddNullContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // ----- Duplicate prevention -----
    @Test
    void testDuplicateIdThrows() {
        service.addContact(valid("ID1"));
        assertThrows(IllegalArgumentException.class, () -> service.addContact(valid("ID1")));
    }

    // ----- Update success paths -----
    @Test
    void testUpdateFirstNameSuccess() {
        service.addContact(valid("ID1"));
        assertTrue(service.updateFirstName("ID1", "Jim"));
        assertEquals("Jim", service.getContact("ID1").getFirstName());
    }

    @Test
    void testUpdateLastNameSuccess() {
        service.addContact(valid("ID1"));
        assertTrue(service.updateLastName("ID1", "Beam"));
        assertEquals("Beam", service.getContact("ID1").getLastName());
    }

    @Test
    void testUpdatePhoneSuccess() {
        service.addContact(valid("ID1"));
        assertTrue(service.updatePhone("ID1", "0987654321"));
        assertEquals("0987654321", service.getContact("ID1").getPhone());
    }

    @Test
    void testUpdateAddressSuccess() {
        service.addContact(valid("ID1"));
        assertTrue(service.updateAddress("ID1", "456 Oak Ave"));
        assertEquals("456 Oak Ave", service.getContact("ID1").getAddress());
    }

    // ----- Update twice (coverage booster) -----
    @Test
    void testUpdateTwice() {
        service.addContact(valid("ID1"));
        assertTrue(service.updateFirstName("ID1", "A"));
        assertTrue(service.updateFirstName("ID1", "B"));
        assertEquals("B", service.getContact("ID1").getFirstName());
    }

    // ----- Not-found updates return false -----
    @Test
    void testUpdateFailsWhenIdNotFound() {
        assertFalse(service.updateFirstName("NOPE", "X"));
        assertFalse(service.updateLastName("NOPE", "Y"));
        assertFalse(service.updatePhone("NOPE", "1111111111"));
        assertFalse(service.updateAddress("NOPE", "Z"));
    }

    // ----- Validation propagation (coverage boosters) -----
    @Test
    void testValidationPropagation() {
        service.addContact(valid("ID1"));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("ID1", "ABCDEFGHIJK")); // >10
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("ID1", "ABCDEFGHIJK"));  // >10
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("ID1", "123"));             // invalid
        String addr31 = "1234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("ID1", addr31));          // >30
    }

    // ----- Delete success & state -----
    @Test
    void testDeleteContactSuccess() {
        service.addContact(valid("ID1"));
        assertTrue(service.deleteContact("ID1"));
        assertEquals(0, service.size());
        assertNull(service.getContact("ID1"));
    }

    @Test
    void testDeleteContactNotFoundReturnsFalse() {
        assertFalse(service.deleteContact("NOPE"));
    }
}