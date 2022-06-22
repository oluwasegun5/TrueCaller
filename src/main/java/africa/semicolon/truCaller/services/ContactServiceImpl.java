package africa.semicolon.truCaller.services;

import africa.semicolon.truCaller.data.models.Contact;
import africa.semicolon.truCaller.data.repositories.ContactRepository;

public class ContactServiceImpl implements ContactService{
    ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName,lastName,phoneNumber);
        contactRepository.save(contact);

    }

    @Override
    public void updateContactFirstName(int id, String newFirstName) {
        contactRepository.updateFirstName(id,newFirstName);
    }

    @Override
    public void updateContactLastName(int id, String newLastName) {
        contactRepository.updateLastName(id,newLastName);
    }

    @Override
    public void updateContactPhoneNumber(int id, String newPhoneNumber) {
        contactRepository.updatePhoneNumber(id,newPhoneNumber);
    }

    @Override
    public Contact findContactByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    public Contact findContactByLastName(String lastName) {
        return contactRepository.findByLastName(lastName);
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }
}
