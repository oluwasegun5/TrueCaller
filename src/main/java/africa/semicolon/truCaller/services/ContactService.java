package africa.semicolon.truCaller.services;

import africa.semicolon.truCaller.data.models.Contact;

public interface ContactService {
    void addContact(String firstName, String lastName, String phoneNumber);

    void updateContactFirstName(int id,String newFirstName);
    void updateContactLastName(int id, String newLastName);
    void updateContactPhoneNumber(int id, String newPhoneNumber);

    Contact findContactByFirstName(String firstName);
    Contact findContactByLastName(String lastName);
    Contact findContactById(int id);

    void deleteContact(Contact contact);
}
