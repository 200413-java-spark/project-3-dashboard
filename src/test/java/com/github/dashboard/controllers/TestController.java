package com.github.dashboard.controllers;

@RestController
@RequestMapping("api/v1/")

public class TestController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return userRepository.findOne(id);
    }
}