package contacts;

import java.util.HashMap;
import java.util.Map;

/*
 * File: ContactService.java
 * Author: Eric Long
 * Course: CS 320
 * Project One: Contact Service
 * Description:
 *   In-memory service for Contact objects:
 *     - Add with unique ID
 *     - Delete by contactId
 *     - Update fields (firstName, lastName, phone, address)
 */

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contact == null) throw new IllegalArgumentException("Contact cannot be null");
        String id = contact.getContactId();
        if (contacts.containsKey(id)) throw new IllegalArgumentException("Contact ID already exists: " + id);
        contacts.put(id, contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

    public boolean updateFirstName(String contactId, String firstName) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setFirstName(firstName); // validation in Contact
        return true;
    }

    public boolean updateLastName(String contactId, String lastName) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setLastName(lastName);
        return true;
    }

    public boolean updatePhone(String contactId, String phone) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setPhone(phone);
        return true;
    }

    public boolean updateAddress(String contactId, String address) {
        Contact c = contacts.get(contactId);
        if (c == null) return false;
        c.setAddress(address);
        return true;
    }

    public Contact getContact(String contactId) { return contacts.get(contactId); }
    public int size() { return contacts.size(); }
}