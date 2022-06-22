package africa.semicolon.truCaller.data.repositories;

import africa.semicolon.truCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {

    ContactRepository contactRepository;
    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void testSaveMethod_countIsOne() {
        var contact = new Contact("John","Johnson","0987654321");

        var savedContact = contactRepository.save(contact);
        assertEquals(1, savedContact.getId());
    }

    @Test
    public void testSavedMethod_countIsTwo() {
        var contact1 = new Contact("John","Johnson","0987654321");
        contact1.setFirstName("John");

        var savedContact = contactRepository.save(contact1);
        assertEquals(1, savedContact.getId());

        var contact2 = new Contact("Jane","Mary","123456789");

        var savedContact2 = contactRepository.save(contact2);
        assertEquals(2, savedContact2.getId());
    }

    @Test
    public void testFindByIdMethod_returnsContact() {
        var contact1 = new Contact("John","Johnson","0987654321");
        contact1.setFirstName("John");
        var contact2 = new Contact("Jane","Mary","123456789");

        var savedContact = contactRepository.save(contact1);
        var savedContact2 = contactRepository.save(contact2);

        assertEquals(1, savedContact.getId());
        assertEquals(2, savedContact2.getId());

        assertEquals("John",contactRepository.findById(1).getFirstName());
    }

    @Test
    public void testFindByFirstName_returnsId() {
        var contact1 = new Contact("John","Johnson","0987654321");
        var contact2 = new Contact("Jane","Mary","123456789");

        var savedContact = contactRepository.save(contact1);
        var savedContact2 = contactRepository.save(contact2);

        assertEquals(1, savedContact.getId());
        assertEquals(2, savedContact2.getId());

        assertEquals(1,contactRepository.findByFirstName("John").getId());
    }

    @Test
    public void testFindByLastName_returnsId() {
        var contact1 = new Contact("John","Kay","0987654321");
        contactRepository.save(contact1);

        var contact2 = new Contact("Mary","Jane","123456789");
        contactRepository.save(contact2);

        assertEquals(2,contactRepository.findByLastName("Jane").getId());
    }

    @Test
    public void testFindByPhoneNumber_returnsId() {
        var contact1 = new Contact("John","Johnson","1234");
        var contact2 = new Contact("Jane","Mary","0987");

        contactRepository.save(contact1);
        contactRepository.save(contact2);

        assertEquals(2,contactRepository.findByPhoneNumber("0987").getId());
    }

    @Test
    public void testForDelete() {
        var contact1 = new Contact("John","Johnson","1234");
        var contact2 = new Contact("Jane","Mary","0987");

        contactRepository.save(contact1);
        contactRepository.save(contact2);

        contactRepository.delete(contact1);

        assertEquals(1,contactRepository.findByPhoneNumber("0987").getId());
        assertEquals("Jane",contactRepository.findById(1).getFirstName());
    }

    @Test
    public void testForUpdateFirstName() {
        var contact1 = new Contact("John","Johnson","1234");

        var contact2 = new Contact("Jane","Mary","0987");


        contactRepository.save(contact1);
        contactRepository.save(contact2);
        assertEquals("John",contactRepository.findById(1).getFirstName());

        contactRepository.updateFirstName(1,"Oluwasegun");

        assertEquals("Oluwasegun",contactRepository.findById(1).getFirstName());

    }

    @Test
    public void testForUpdateLastName() {
        var contact1 = new Contact("John","Johnson","1234");
        var contact2 = new Contact("Jane","Mary","0987");

        contactRepository.save(contact1);
        contactRepository.save(contact2);
        assertEquals("Mary",contactRepository.findById(2).getLastName());

        contactRepository.updateLastName(2,"Oluwasegun");

        assertEquals("Oluwasegun",contactRepository.findById(2).getLastName());

    }

    @Test
    public void testForUpdatePhoneNumber() {
        var contact1 = new Contact("John","Johnson","1234");

        var contact2 = new Contact("Jane","Mary","0987");


        contactRepository.save(contact1);
        contactRepository.save(contact2);
        assertEquals("1234",contactRepository.findById(1).getPhoneNumber());

        contactRepository.updatePhoneNumber(1,"1234567890");

        assertEquals("1234567890",contactRepository.findById(1).getPhoneNumber());

    }
}
