package africa.semicolon.truCaller.services;

import africa.semicolon.truCaller.data.models.Contact;
import africa.semicolon.truCaller.data.repositories.ContactRepository;
import africa.semicolon.truCaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    ContactService contactService;
    ContactRepository contactRepository;
    @BeforeEach
    void setup(){
        contactRepository = new ContactRepositoryImpl();
        contactService = new ContactServiceImpl(contactRepository);
    }

    @Test
    void addContact() {
        contactService.addContact("Tola","Femi","1234");
        var contact = contactService.findContactById(1);

        assertEquals("Tola",contact.getFirstName());
        assertEquals("Femi",contact.getLastName());
        assertEquals("1234",contact.getPhoneNumber());
    }

    @Test
    void updateContactFirstName() {
        contactService.addContact("Tola","Femi","1234");
        contactService.updateContactFirstName(1,"Oluwasegun");
        Contact contact = contactService.findContactById(1);

        assertEquals("Oluwasegun",contact.getFirstName());
        assertEquals("Femi",contact.getLastName());
        assertEquals("1234",contact.getPhoneNumber());
    }

    @Test
    void updateContactLastName() {
        contactService.addContact("Tola","Femi","1234");
        contactService.updateContactLastName(1,"Adeayo");
        Contact contact = contactService.findContactById(1);

        assertEquals("Tola",contact.getFirstName());
        assertEquals("Adeayo",contact.getLastName());
        assertEquals("1234",contact.getPhoneNumber());
    }

    @Test
    void updateContactPhoneNumber() {
        contactService.addContact("Tola","Femi","1234");
        contactService.updateContactPhoneNumber(1,"0987");
        Contact contact = contactService.findContactById(1);

        assertEquals("Tola",contact.getFirstName());
        assertEquals("Femi",contact.getLastName());
        assertEquals("0987",contact.getPhoneNumber());
    }

    @Test
    void findContactByFirstName() {
        contactService.addContact("Tola","Femi","1234");
        contactService.addContact("Teju","Baby_face","2222");
        contactService.updateContactPhoneNumber(1,"0987");

        Contact contact = contactService.findContactByFirstName("Tola");

        assertEquals("Femi",contact.getLastName());
        assertEquals("0987",contact.getPhoneNumber());
        assertEquals(1,contact.getId());
    }

    @Test
    void findContactByLastName() {
        contactService.addContact("Tola","Femi","1234");
        contactService.addContact("Teju","Baby_face","2222");

        Contact contact = contactService.findContactByLastName("Baby_face");

        assertEquals("Teju",contact.getFirstName());
        assertEquals("2222",contact.getPhoneNumber());
        assertEquals(2,contact.getId());
    }

    @Test
    void findContactById() {
        contactService.addContact("Tola","Femi","1234");
        contactService.addContact("Teju","Baby_face","2222");

        Contact contact = contactService.findContactById(2);

        assertEquals("Teju",contact.getFirstName());
        assertEquals("2222",contact.getPhoneNumber());
        assertEquals("Baby_face",contact.getLastName());
    }

    @Test
    void deleteContact() {
        contactService.addContact("Tola","Femi","1234");
        contactService.addContact("Teju","Baby_face","2222");

        Contact contact = contactService.findContactById(1);

        assertEquals("Tola",contact.getFirstName());
        assertEquals("1234",contact.getPhoneNumber());
        assertEquals("Femi",contact.getLastName());

        contactService.deleteContact(contactService.findContactById(1));

        Contact contact2 = contactService.findContactById(1);

        assertEquals("Teju",contact2.getFirstName());
        assertEquals("2222",contact2.getPhoneNumber());
        assertEquals("Baby_face",contact2.getLastName());
    }
}