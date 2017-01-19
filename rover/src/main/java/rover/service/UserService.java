package rover.service;

import rover.domain.FinalResponse;
import rover.domain.Instructions;
import rover.domain.Rover;

public class UserService {

    
    public FinalResponse drop(Instructions instructions) {

        
        Rover rover = new Rover();
        FinalResponse finalResponse = new FinalResponse();

        String[] plat = instructions.getPlat().trim().split(" ");
        rover.setPlateau(Integer.parseInt(plat[0]), Integer.parseInt(plat[1]));
        
        
        String[] posRover1 = instructions.getPos1().trim().split(" ");
        rover.setPosition(Integer.parseInt(posRover1[0]), Integer.parseInt(posRover1[1]), convertFacing(posRover1[2]));
        if(instructions.getInst1() != null){
            rover.move(instructions.getInst1());
        }
        finalResponse.setFinalPos1(rover.printPosition());
        
        
        String[] posRover2 = instructions.getPos2().trim().split(" ");
        rover.setPosition(Integer.parseInt(posRover2[0]), Integer.parseInt(posRover2[1]), convertFacing(posRover2[2]));
        if(instructions.getInst2() != null){
            rover.move(instructions.getInst2());
        }
        finalResponse.setFinalPos2(rover.printPosition());

        return finalResponse;
    }


    private Integer convertFacing(String sFacing) {

        int iFacing = 1;

        if ("E".equals(sFacing)) {
            iFacing = 2;
        } else if ("S".equals(sFacing)) {
            iFacing = 3;
        } else if ("W".equals(sFacing)) {
            iFacing = 4;
        }

        return iFacing;
    }


}