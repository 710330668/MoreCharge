package com.example.hdd.morecharge.receive.main.myskills.entity;

public class SkillPosSelect {

    private int parentPos;
    private int childPos;

    public SkillPosSelect(int parentPos, int childPos) {
        this.parentPos = parentPos;
        this.childPos = childPos;
    }

    public int getParentPos() {
        return parentPos;
    }

    public void setParentPos(int parentPos) {
        this.parentPos = parentPos;
    }

    public int getChildPos() {
        return childPos;
    }

    public void setChildPos(int childPos) {
        this.childPos = childPos;
    }
}
