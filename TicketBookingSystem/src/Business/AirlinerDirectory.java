/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class AirlinerDirectory {
    
    private ArrayList<Airliner> airlinerDirect;
    
    public AirlinerDirectory() {
        airlinerDirect = new ArrayList<Airliner>();
    }

    public void setAirlinerDirect(ArrayList<Airliner> airlinerDirect) {
        this.airlinerDirect = airlinerDirect;
    }
    

    public ArrayList<Airliner> getAirlinerDirect() {
        return airlinerDirect;
    }
    
    public Airliner addAirliner() {
        Airliner s = new Airliner();
        airlinerDirect.add(s);
        return s;
    }
    
    public void removeAirliner(Airliner s) {
        airlinerDirect.remove(s);
    }
    
    public ArrayList<Airliner> searchAirliner(String keyWord){
        ArrayList<Airliner> reList=new ArrayList<Airliner>();
        for(Airliner s : this.airlinerDirect){
            if(s.getCodeName().equalsIgnoreCase(keyWord)){
                reList.add(s);
            }
        }
        return reList;
    }
    
    public ArrayList<Airliner> searchAirlinerName(String keyWord){
        ArrayList<Airliner> reList=new ArrayList<Airliner>();
        for(Airliner s : this.airlinerDirect){
            if(s.getAirlinerName().equalsIgnoreCase(keyWord)){
                reList.add(s);
            }
        }
        return reList;
    }
    public Airliner WhichAirliner(String keyWord) {
        for(Airliner c : airlinerDirect) {
            if(keyWord.equals(c.getAirlinerName())) {
                return c;
            }
        }
        return null;
    }
}
