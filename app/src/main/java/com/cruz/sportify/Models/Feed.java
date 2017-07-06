package com.cruz.sportify.Models;

/**
 * Created by Acer on 03/07/2017.
 */

public class Feed {
    private int picHolder;
    private String nameHolder;
    private String timeHolder;
    private int buttonType;
    private String textContent;
    private int imageContent;

    public Feed() {
    }

    public Feed(int picHolder, String nameHolder, String timeHolder, int buttonType, String textContent, int imageContent) {
        this.picHolder = picHolder;
        this.nameHolder = nameHolder;
        this.timeHolder = timeHolder;
        this.buttonType = buttonType;
        this.textContent = textContent;
        this.imageContent = imageContent;
    }

    public int getPicHolder() {
        return picHolder;
    }

    public void setPicHolder(int picHolder) {
        this.picHolder = picHolder;
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public void setNameHolder(String nameHolder) {
        this.nameHolder = nameHolder;
    }

    public String getTimeHolder() {
        return timeHolder;
    }

    public void setTimeHolder(String timeHolder) {
        this.timeHolder = timeHolder;
    }

    public int getButtonType() {
        return buttonType;
    }

    public void setButtonType(int buttonType) {
        this.buttonType = buttonType;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public int getImageContent() {
        return imageContent;
    }

    public void setImageContent(int imageContent) {
        this.imageContent = imageContent;
    }
}
