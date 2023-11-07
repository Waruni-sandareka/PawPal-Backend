package lk.pawpal.backend.service;

import lk.pawpal.backend.model.LoginCredentials;
import lk.pawpal.backend.model.Owner;
import lk.pawpal.backend.repository.OwnerRepository;
import lk.pawpal.backend.response.OwnerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    OwnerRepository ownerRepository;

    public OwnerResponse register(Owner owner) {

        OwnerResponse response = new OwnerResponse();

        Owner ow = new Owner(owner.getUsername(), owner.getEmail(), owner.getPassword());


        try {
            Owner ond = ownerRepository.save(ow);

            response.setCode("1");
            response.setMessage("Succesfully Registerd");
            response.setOwner(ond);
            return response;
        }
        catch(Exception e){
            response.setCode("-1");
            response.setMessage("something went wrong ");
            return response;
        }

    }

    public OwnerResponse login(LoginCredentials loginCredentials) {

        OwnerResponse response = new OwnerResponse();

        try {

            Owner owner = ownerRepository.getDetails(loginCredentials.getEmail());

            if(owner == null) {
                response.setMessage("Email is incorrect");
                response.setCode("-1");
            }
            else {

                if(loginCredentials.getPassword().equals(owner.getPassword())) {
                    response.setMessage("Login Success!");
                    response.setCode("1");
                    response.setOwner(owner);
                }else {
                    response.setMessage("Password Incorrect!");
                    response.setCode("-1");
                }

            }
        } catch (Exception e) {
            response.setMessage("Error occured!");
            response.setCode("-1");
        }

        return response;

    }




}
