package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MasteryDto extends BaseObject {

    private List<String> description;
    private Integer id;
    private ImageDto image;
    private String masteryTree, name, prereq;
    private Integer ranks;
    private List<String> sanitizedDescription;

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public String getMasteryTree() {
        return masteryTree;
    }

    public void setMasteryTree(String masteryTree) {
        this.masteryTree = masteryTree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

    public Integer getRanks() {
        return ranks;
    }

    public void setRanks(Integer ranks) {
        this.ranks = ranks;
    }

    public List<String> getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription(List<String> sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }
}
