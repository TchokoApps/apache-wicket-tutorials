package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;

import com.mysema.query.annotations.Config;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Config(listAccessors = true, entityAccessors = true)
public class AppSettings {

    @Id
    private Long id;

    private boolean notifications;

    private Integer notifyBefore;

    private boolean notifyPatient;

    private boolean notifyDoctor;

    public AppSettings(Long id) {
        this.id = id;
    }

    public AppSettings(Long id, boolean notifications, Integer notifyBefore, boolean notifyPatient, boolean notifyDoctor) {
        this.id = id;
        this.notifications = notifications;
        this.notifyBefore = notifyBefore;
        this.notifyPatient = notifyPatient;
        this.notifyDoctor = notifyDoctor;
    }

    public AppSettings(boolean notifications, Integer notifyBefore, boolean notifyPatient, boolean notifyDoctor) {
        this.notifications = notifications;
        this.notifyBefore = notifyBefore;
        this.notifyPatient = notifyPatient;
        this.notifyDoctor = notifyDoctor;
    }
}
