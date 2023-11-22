package com.booking.domain;

public class AdminNotificationSettings {

    private boolean commentReport;
    private boolean userReport;



    public AdminNotificationSettings(){

    }

    public boolean isCommentReport() {
        return commentReport;
    }

    public void setCommentReport(boolean commentReport) {
        this.commentReport = commentReport;
    }

    public boolean isUserReport() {
        return userReport;
    }

    public void setUserReport(boolean userReport) {
        this.userReport = userReport;
    }
}
