package br.com.marcelbraghini.quarkusrest.repository;

import br.com.marcelbraghini.quarkusrest.model.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public User findByName(final String name){
        return find("name", name).firstResult();
    }

    public User findByLogin(final String login) {
        return find("login", login).firstResult();
    }

    public User save(final User user) {
        persist(user);
        return user;
    }

}
