package com.maxwell.androidwarehouse2.models;

/**
 * Created by Maximiliano on 29/07/15.
 */
public class Items {
    Class classItem;
    String nameItem;

    public Items(){}

    public Items(Class classItem, String nameItem){
        this.classItem = classItem;
        this.nameItem = nameItem;
    }

    public void setClassItem(Class classItem) {
        this.classItem = classItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Class getClassItem() {
        return classItem;
    }

    public String getNameItem() {
        return nameItem;
    }
}
