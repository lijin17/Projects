/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.NursingWorkerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ElderOrganization extends Organization{

    public ElderOrganization() {
        super(Organization.Type.Elder.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NursingWorkerRole());
        return roles;
    }
     
   
    
    
}
