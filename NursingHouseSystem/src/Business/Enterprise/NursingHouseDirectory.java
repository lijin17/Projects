/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class NursingHouseDirectory {
    private ArrayList<NursingHouse> enterpriseList;
   

    public ArrayList<NursingHouse> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<NursingHouse> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public NursingHouseDirectory(){
        enterpriseList=new ArrayList<NursingHouse>();
    }
    
    //Create enterprise
    public NursingHouse createAndAddEnterprise(String name,NursingHouse.EnterpriseType type){
        NursingHouse nursingHouse=null;
        if(type==NursingHouse.EnterpriseType.HighEndNH){
            nursingHouse=new HighEndNursingHouse(name);
            enterpriseList.add(nursingHouse);
        }else if(type==NursingHouse.EnterpriseType.MiddleEndNH){
            nursingHouse=new MiddleEndNursingHouse(name);
            enterpriseList.add(nursingHouse);
        }else{
            nursingHouse=new LowEndNursingHouse(name);
            enterpriseList.add(nursingHouse);
        }
        
        return nursingHouse;
    }
}
