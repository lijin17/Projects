/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

/**
 *
 * @author Rushabh
 */
public class Airliner {
    
    private String airlinerName;
    private int airlinerStarRating;
    private String codeName;
    private AirlinerDirectory AirlinerDirectory;
    
    public Airliner() {
        AirlinerDirectory = new AirlinerDirectory();
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public AirlinerDirectory getAirlinerDirectory() {
        return AirlinerDirectory;
    }

    public int getAirlinerStarRating() {
        return airlinerStarRating;
    }

    public void setAirlinerStarRating(int airlinerStarRating) {
        this.airlinerStarRating = airlinerStarRating;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    
    
    @Override
    public String toString() {
        return airlinerName;
    }
    
}
