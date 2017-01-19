package rover.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rover.domain.FinalResponse;
import rover.domain.Instructions;
import rover.service.UserService;


@Path("/rover")
public class UserRestService {


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public FinalResponse salvaOuAtualiza(Instructions instructions) {

        UserService userService = new UserService();
        return userService.drop(instructions);
    }

}
