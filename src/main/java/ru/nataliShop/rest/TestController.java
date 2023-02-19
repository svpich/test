package ru.nataliShop.rest;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nataliShop.DAO.UserRepository;
import ru.nataliShop.model.entity.Client;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final UserRepository userRepository;

    @GetMapping(value = "/test")
    public void addClient(@RequestBody Client client) {
        var user = new Client();
        user.setFirstName("test_first_name");
        userRepository.save(user);
    }

    @PostMapping(value = "/addProduct")
    public void addProduct(@RequestBody Product) {

    }
}
