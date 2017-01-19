package rover.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FinalResponse {

    private String finalPos1;
    private String finalPos2;
    
    public String getFinalPos1() {
        return finalPos1;
    }
    public void setFinalPos1(String finalPos1) {
        this.finalPos1 = finalPos1;
    }
    public String getFinalPos2() {
        return finalPos2;
    }
    public void setFinalPos2(String finalPos2) {
        this.finalPos2 = finalPos2;
    }
    
    
   
}
