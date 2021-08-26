/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.NHSystem;
import Business.Enterprise.NursingHouse;
import Business.Organization.HealthCareNHOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.NursingWorkerRole.NursingWorkerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class NursingWorkerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NursingHouse enterprise, NHSystem business) {
        return new NursingWorkerWorkAreaJPanel(userProcessContainer, account, (HealthCareNHOrganization)organization, business);
    }
    
}
