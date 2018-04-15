package com.chenqian.entity;

/**
 * 词霸图片接口
 */
public class CiBaInfo {
    private String picture2;
    private String content;
    private String note;
    private String translation; //评论句子

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTranslation() {
        return translation.replaceAll("词霸小编：","");
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "CiBaInfo{" +
                "picture2='" + picture2 + '\'' +
                ", content='" + content + '\'' +
                ", note='" + note + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
