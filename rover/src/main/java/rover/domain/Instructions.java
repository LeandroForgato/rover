package rover.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Instructions {

    private String plat;
    private String pos1;
    private String inst1;
    private String pos2;
    private String inst2;
    
    
    public String getPlat() {
        return plat;
    }
    public void setPlat(String plat) {
        this.plat = plat;
    }
    public String getPos1() {
        return pos1;
    }
    public void setPos1(String pos1) {
        this.pos1 = pos1;
    }
    public String getInst1() {
        return inst1;
    }
    public void setInst1(String inst1) {
        this.inst1 = inst1;
    }
    public String getPos2() {
        return pos2;
    }
    public void setPos2(String pos2) {
        this.pos2 = pos2;
    }
    public String getInst2() {
        return inst2;
    }
    public void setInst2(String inst2) {
        this.inst2 = inst2;
    }

   
}
