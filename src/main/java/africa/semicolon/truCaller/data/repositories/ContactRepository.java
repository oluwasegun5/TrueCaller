package africa.semicolon.truCaller.data.repositories;

import africa.semicolon.truCaller.data.models.Contact;

public interface ContactRepository {
    Contact save(Contact contact);
    Contact findById(int id);
    Contact findByPhoneNumber(String phoneNumber);
    boolean delete(Contact contact);
    Contact findByFirstName(String firstName);
    Contact findByLastName(String lastName);
    Contact updateFirstName(int id,String newFirstName);
    Contact updateLastName(int id,String newLastName);
    Contact updatePhoneNumber(int id,String newPhoneNumber);
}
