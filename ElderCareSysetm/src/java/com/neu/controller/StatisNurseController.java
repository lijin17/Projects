/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.AdminDao;
import com.neu.dao.BodyStatusDao;
import com.neu.dao.ElderDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Administrator;
import com.neu.pojo.BodyStatus;
import com.neu.pojo.Elder;
import com.neu.pojo.NursingWorker;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class StatisNurseController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ID = hsr.getParameter("id");
        if (ID != null) {
            int id = Integer.parseInt(ID);

            try {

                BodyStatusDao bsdao = new BodyStatusDao();
                ElderDao elderdao = new ElderDao();
                ArrayList<BodyStatus> bss = new ArrayList<BodyStatus>();
                bss = (ArrayList<BodyStatus>) bsdao.getAllBodyStatus(id);
                ArrayList<Elder> elders = new ArrayList<Elder>();
                elders = (ArrayList<Elder>) elderdao.getElders(id, "id");
                Elder elder = elders.get(0);

                HttpSession session = hsr.getSession();
                session.setAttribute("BodyData", bss);
                session.setAttribute("h12", bss.get(bss.size() - 1).getHR());
                session.setAttribute("h11", bss.get(bss.size() - 2).getHR());
                session.setAttribute("h10", bss.get(bss.size() - 3).getHR());
                session.setAttribute("h9", bss.get(bss.size() - 4).getHR());
                session.setAttribute("h8", bss.get(bss.size() - 5).getHR());
                session.setAttribute("h7", bss.get(bss.size() - 6).getHR());
                session.setAttribute("h6", bss.get(bss.size() - 7).getHR());
                session.setAttribute("h5", bss.get(bss.size() - 8).getHR());
                session.setAttribute("h4", bss.get(bss.size() - 9).getHR());
                session.setAttribute("h3", bss.get(bss.size() - 10).getHR());
                session.setAttribute("h2", bss.get(bss.size() - 11).getHR());
                session.setAttribute("h1", bss.get(bss.size() - 12).getHR());
                session.setAttribute("elder", elder.getName());
                session.setAttribute("spo2", bss.get(bss.size() - 1).getSPO2());
                session.setAttribute("r6", bss.get(bss.size() - 1).getRE());
                session.setAttribute("r5", bss.get(bss.size() - 2).getRE());
                session.setAttribute("r4", bss.get(bss.size() - 3).getRE());
                session.setAttribute("r3", bss.get(bss.size() - 4).getRE());
                session.setAttribute("r2", bss.get(bss.size() - 5).getRE());
                session.setAttribute("r1", bss.get(bss.size() - 6).getRE());

                mv.setViewName("statis_nursing");

            } catch (Exception e) {
                e.printStackTrace();
                mv.addObject("reminder", "No Data for this elder");
                mv.addObject("backName","statis_nursing.jsp");
                mv.setViewName("reminder");
            }
        } else {
            mv.setViewName("statis_nursing");
        }

        return mv;
    }
}
