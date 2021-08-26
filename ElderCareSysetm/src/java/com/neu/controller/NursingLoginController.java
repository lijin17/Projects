/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.AdminDao;
import com.neu.dao.ElderDao;
import com.neu.dao.NotificationDao;
import com.neu.dao.NursingWorkerDao;
import com.neu.pojo.Administrator;
import com.neu.pojo.Elder;
import com.neu.pojo.Notification;
import com.neu.pojo.NursingWorker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author lijin
 */
public class NursingLoginController extends SimpleFormController {

    public NursingLoginController() {
        setCommandClass(NursingWorker.class);
        setCommandName("nursingworker");
        setSuccessView("index_nursingworker");
        setFormView("login_nursingworker");

    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(this.getSuccessView());
        HttpSession sessionTemp = request.getSession();
        sessionTemp.invalidate();//refresh session
        HttpSession session = request.getSession();

        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        String password = request.getParameter("password");
        NursingWorkerDao nsdao = (NursingWorkerDao) getApplicationContext().getBean("NursingWorkerDao");
        if (s.equals("") || password.equals("")) {
            mv.addObject("reminder", "Login failed!You should fill all the blank. Please try again.");
            mv.addObject("bancName", "login_nursingworker.jsp");
            mv.setViewName("reminder");
        } else {
            //new arraylist for nursing worker login
            ArrayList<NursingWorker> n = new ArrayList<>();

            //to pass the elder data
            ArrayList<Elder> elders = new ArrayList<Elder>();
            ElderDao elderdao = new ElderDao();
            elders = (ArrayList<Elder>) elderdao.getAllElders();
            int bedNum = 100 - elders.size();

            //get all admin data
            ArrayList<Administrator> admins = new ArrayList<Administrator>();
            AdminDao admindao = new AdminDao();
            admins = (ArrayList<Administrator>) admindao.getAllAdmin();

            //get all nursingworker data
            ArrayList<NursingWorker> nss = new ArrayList<NursingWorker>();
            NursingWorkerDao nsingdao = new NursingWorkerDao();
            nss = (ArrayList<NursingWorker>) nsingdao.getAllNursingWorkers();

            //get all notifications
            ArrayList<Notification> notifications = new ArrayList<Notification>();
            NotificationDao ndao = new NotificationDao();

            //calculate the bed price
            double d = 20 + (1 - (bedNum / 100)) * 100;
            String bedPrice = "$" + String.valueOf(d);
            n = (ArrayList<NursingWorker>) nsdao.getNursing(id, "id");
            NursingWorker ns = n.get(0);
            String workerName = ns.getName();

            notifications = (ArrayList<Notification>) ndao.getNotificationsBy(workerName, "receiver");
            Notification notification = new Notification();
            
            ArrayList<Notification> temp1= new ArrayList<>();
            ArrayList<Notification> temp2= new ArrayList<>();
            temp1=(ArrayList<Notification>) ndao.getNotificationsBy("annElder", "receiver");
            temp2=(ArrayList<Notification>) ndao.getNotificationsBy("annNurse", "receiver");
            String anno_elder = temp1.get(temp1.size()-1).getContent();
            String anno_nurse = temp2.get(temp2.size()-1).getContent();

            //get the date
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String date = dateFormat.format(now);

            try {

                if (ns.getPassword().equals(password)) {

                    mv.setViewName(this.getSuccessView());
                    session.setAttribute("elderInfo", elders);
                    session.setAttribute("adminInfo", admins);
                    session.setAttribute("nursingworkerInfo", nss);
                    session.setAttribute("notificationInfo", notifications);
                    session.setAttribute("bedNum", bedNum);
                    session.setAttribute("bedPrice", bedPrice);
                    session.setAttribute("date", date);
                    session.setAttribute("type", "nursingworker");
                    session.setAttribute("workerName", workerName);
                    session.setAttribute("elderNoti", anno_elder);
                    session.setAttribute("nurseNoti", anno_nurse);

                } else {
                    mv.addObject("reminder", "Login failed! Please try again.");
                    mv.addObject("backName", "login_nursingworker.jsp");
                    mv.setViewName("reminder");
                }
            } catch (Exception e) {
                mv.addObject("reminder", "No such user.");
                mv.addObject("backName", "login_nursingworker.jsp");
                mv.setViewName("reminder");
            }
        }

        return mv;
    }
}
