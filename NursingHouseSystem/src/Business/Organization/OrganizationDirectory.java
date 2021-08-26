/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.NursingWorker.getValue())){
            organization = new HealthCareNHOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Elder.getValue())){
            organization = new ElderOrganization();
            organizationList.add(organization);
        }else if(type.getValue().equals(Type.Doctor.getValue())){
            organization = new HealthCareDOrganization();
            organizationList.add(organization);
        }else if(type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}