package com.viadee.sonarquest.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.viadee.sonarquest.rules.SonarQuestTaskStatus;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("SPECIAL")
public class SpecialTask extends Task {

    @Column(name = "message")
    private String message;

    public SpecialTask() {
    }

    public SpecialTask(final String title, final SonarQuestTaskStatus status, final Long gold, final Long xp,
                       final Quest quest,
                       final String message, final World world) {
        this.setTitle(title);
        this.setStatus(status);
        this.setGold(gold);
        this.setXp(xp);
        this.setQuest(quest);
        this.message = message;
        this.setWorld(world);
    }
}
