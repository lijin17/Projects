/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.NursingHouse;
import Business.NHSystem;
import Business.Organization.ElderOrganization;
import Business.Organization.HealthCareDOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DoctorRole.DoctorWorkAreaJPanel;
import userinterface.ElderRole.ElderWorkAreaJPanel;

/**
 *
 * @author Liyanjuan
 */
public class ElderRole {
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, NursingHouse enterprise, NHSystem business) {
        return new ElderWorkAreaJPanel(userProcessContainer, account, (ElderOrganization)organization, enterprise);
    }
}
