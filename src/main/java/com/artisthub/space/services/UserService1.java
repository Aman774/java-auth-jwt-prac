package com.artisthub.space.services;

import com.artisthub.space.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService1 {

    private List<User> store =new ArrayList<>();

    public UserService1(){
        store.add(new User(UUID.randomUUID().toString(),"aman@gmail.com","Aman Choudhary"));
        store.add(new User(UUID.randomUUID().toString(),"ashish@gmail.com","ashish kumar"));
        store.add(new User(UUID.randomUUID().toString(),"vikas@gmail.com","vikas tanwar"));
        store.add(new User(UUID.randomUUID().toString(),"sahil@gmail.com","sahil pal"));
    }

    public List<User> getUsers(){

        return this.store;
    }

}
