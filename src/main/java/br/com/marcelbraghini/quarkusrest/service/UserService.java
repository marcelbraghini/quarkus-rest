package br.com.marcelbraghini.quarkusrest.service;

import br.com.marcelbraghini.quarkusrest.model.User;
import br.com.marcelbraghini.quarkusrest.repository.UserRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    public UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.listAll();
    }

    public User save(final User user){
        return userRepository.save(user);
    }

    public void update(final User user) {
        userRepository.update(user);
    }

    public User findById(final ObjectId objectId) {
        Optional<User> optional = userRepository.findByIdOptional(objectId);
        return optional.orElseThrow(() -> new NotFoundException());
    }

    public User findByName(final String name) {
        return userRepository.findByName(name);
    }

    public User findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }

    public void remove(final String _id) {
        userRepository.deleteById(new ObjectId(_id));
    }

}
