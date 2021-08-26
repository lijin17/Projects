/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class LowEndNursingHouse extends NursingHouse{
    public LowEndNursingHouse(String name){
        super(name,NursingHouse.EnterpriseType.LowEndNH);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
