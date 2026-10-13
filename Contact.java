package contacts;

/*
 * File: Contact.java
 * Author: Eric Long
 * Course: CS 320
 * Project One: Contact Service
 * Description:
 *   Implements the Contact object for the mobile application.
 *   Enforces validation rules:
 *     - contactId: non-null, <= 10 chars, immutable
 *     - firstName: non-null, <= 10 chars
 *     - lastName: non-null, <= 10 chars
 *     - phone: non-null, exactly 10 digits
 *     - address: non-null, <= 30 chars
 */

public class Contact {

    private final String contactId; // immutable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // ----- Validators -----
    private void validateContactId(String id) {
        if (id == null) throw new IllegalArgumentException("Contact ID cannot be null");
        if (id.length() > 10) throw new IllegalArgumentException("Contact ID must be <= 10 characters");
    }

    private void validateFirstName(String value) {
        if (value == null) throw new IllegalArgumentException("First name cannot be null");
        if (value.length() > 10) throw new IllegalArgumentException("First name must be <= 10 characters");
    }

    private void validateLastName(String value) {
        if (value == null) throw new IllegalArgumentException("Last name cannot be null");
        if (value.length() > 10) throw new IllegalArgumentException("Last name must be <= 10 characters");
    }

    private void validatePhone(String value) {
        if (value == null) throw new IllegalArgumentException("Phone cannot be null");
        if (!value.matches("\\d{10}")) throw new IllegalArgumentException("Phone must be exactly 10 digits");
    }

    private void validateAddress(String value) {
        if (value == null) throw new IllegalArgumentException("Address cannot be null");
        if (value.length() > 30) throw new IllegalArgumentException("Address must be <= 30 characters");
    }

    // ----- Getters -----
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPhone()     { return phone; }
    public String getAddress()   { return address; }

    // ----- Setters with validation -----
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }
}