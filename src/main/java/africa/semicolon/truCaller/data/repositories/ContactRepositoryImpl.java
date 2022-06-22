package africa.semicolon.truCaller.data.repositories;

import africa.semicolon.truCaller.data.models.Contact;

import java.util.ArrayList;

public class ContactRepositoryImpl implements ContactRepository {
    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {
        contacts.add(contact);
        contact.setId(contacts.size());
        return contact;
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id-1);
    }

    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        for (var contact:contacts){
            if (contact.getPhoneNumber().equals(phoneNumber))return contact;
        }
        return null;
    }

    @Override
    public boolean delete(Contact contact) {
        contacts.removeIf(aContact -> aContact.getPhoneNumber().equals(contact.getPhoneNumber()));
        for (int i = 0; i < contacts.size(); i++) {
            contacts.get(i).setId(i+1);
        }
        return false;
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for (var contact:contacts){
            if (contact.getFirstName().equals(firstName))return contact;
        }
        return null;
    }

    @Override
    public Contact findByLastName(String lastName) {
        for (var contact:contacts){
            if (contact.getLastName().equals(lastName))return contact;
        }
        return null;
    }

    @Override
    public Contact updateFirstName(int id, String newFirstName) {
        for (var contact:contacts){
            if (contact.getId() == id)contact.setFirstName(newFirstName);
        }
        return null;
    }

    @Override
    public Contact updateLastName(int id, String newLastName) {
        for (var contact:contacts){
            if (contact.getId() == id)contact.setLastName(newLastName);
        }
        return null;
    }

    @Override
    public Contact updatePhoneNumber(int id, String newPhoneNumber) {
        for (var contact:contacts){
            if (contact.getId() == id)contact.setPhoneNumber(newPhoneNumber);
        }
        return null;
    }


}
