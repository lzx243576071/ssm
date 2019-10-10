package com.soecode.web.entity;

import java.util.Date;

public class AppointmentInfo {
    private Integer id;

    private Date appointmentDate;

    private String appointmentTimeFrame;

    private Integer orderNumSum;

    private Integer orderNumNow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTimeFrame() {
        return appointmentTimeFrame;
    }

    public void setAppointmentTimeFrame(String appointmentTimeFrame) {
        this.appointmentTimeFrame = appointmentTimeFrame == null ? null : appointmentTimeFrame.trim();
    }

    public Integer getOrderNumSum() {
        return orderNumSum;
    }

    public void setOrderNumSum(Integer orderNumSum) {
        this.orderNumSum = orderNumSum;
    }

    public Integer getOrderNumNow() {
        return orderNumNow;
    }

    public void setOrderNumNow(Integer orderNumNow) {
        this.orderNumNow = orderNumNow;
    }
}