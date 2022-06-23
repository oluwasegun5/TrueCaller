package africa.semicolon.truCaller.controllers;

import africa.semicolon.truCaller.data.repositories.ContactRepository;
import africa.semicolon.truCaller.data.repositories.ContactRepositoryImpl;
import africa.semicolon.truCaller.services.ContactService;
import africa.semicolon.truCaller.services.ContactServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    private ContactRepository contactRepository = new ContactRepositoryImpl();
    private ContactService contactService = new ContactServiceImpl(contactRepository);

    @PostMapping("/contact")
    public String addContact(@RequestBody RequestDto requestDto){
        contactService.addContact(requestDto.getFirstName(), requestDto.getLastName(), requestDto.getPhoneNumber());
        return requestDto.getFirstName();
    }

    @GetMapping("/contact/{firstName}")
    public String findByFirstName(@PathVariable String firstName){
        return contactService.findContactByFirstName(firstName).toString();
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class RequestDto{

    private String firstName;
    private String lastName;
    private String phoneNumber;
}
