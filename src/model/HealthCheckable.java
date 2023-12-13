package model;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
This is the interface that defines the methods of performCheckup and scheduleCheckup.
 */
public interface HealthCheckable {
    void performCheckup();
    void scheduleCheckup();
}
