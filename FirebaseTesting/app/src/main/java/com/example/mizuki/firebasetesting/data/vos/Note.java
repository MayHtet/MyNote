
package com.example.mizuki.firebasetesting.data.vos;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Note implements Serializable{

    private Long delete;

    private String createdmili;

    private String date;

    private String description;

    private String emotion;

    private String title;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedmili() {
        return createdmili;
    }

    public void setCreatedmili(String createdmili) {
        this.createdmili = createdmili;
    }

    public Long getDelete() {
        return delete;
    }

    public void setDelete(Long delete) {
        this.delete = delete;
    }
}
