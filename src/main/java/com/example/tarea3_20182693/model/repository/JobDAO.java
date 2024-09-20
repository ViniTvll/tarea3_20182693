package com.example.tarea3_20182693.model.repository;

import com.example.tarea3_20182693.model.bean.Job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  JobDAO  extends BaseDAO {

    public ArrayList<Job> findAll() {

        ArrayList<Job> listaJob = new ArrayList<>();

        String sql = "select "
                + "j.job_id, j.job_title "
                + "from jobs j ";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {

                Job job = new Job();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));

                listaJob.add(job);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaJob;
    }


}