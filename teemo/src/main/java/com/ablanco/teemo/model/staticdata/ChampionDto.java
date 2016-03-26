package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class ChampionDto extends BaseObject {

    private List<String> allytips;
    private String blurb;
    private List<String> enemytips;
    private Integer id;
    private ImageDto image;
    private InfoDto info;
    private String key;
    private String lore;
    private String name;
    private String partype;
    private PassiveDto passive;
    private List<RecommendedDto> recommended;
    private List<SkinDto> skins;
    private List<ChampionSpellDto> spells;
    private StatsDto stats;
    private List<String> tags;
    private String title;

    public List<String> getAllytips() {
        return allytips;
    }

    public void setAllytips(List<String> allytips) {
        this.allytips = allytips;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public List<String> getEnemytips() {
        return enemytips;
    }

    public void setEnemytips(List<String> enemytips) {
        this.enemytips = enemytips;
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

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartype() {
        return partype;
    }

    public void setPartype(String partype) {
        this.partype = partype;
    }

    public PassiveDto getPassive() {
        return passive;
    }

    public void setPassive(PassiveDto passive) {
        this.passive = passive;
    }

    public List<RecommendedDto> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<RecommendedDto> recommended) {
        this.recommended = recommended;
    }

    public List<SkinDto> getSkins() {
        return skins;
    }

    public void setSkins(List<SkinDto> skins) {
        this.skins = skins;
    }

    public List<ChampionSpellDto> getSpells() {
        return spells;
    }

    public void setSpells(List<ChampionSpellDto> spells) {
        this.spells = spells;
    }

    public StatsDto getStats() {
        return stats;
    }

    public void setStats(StatsDto stats) {
        this.stats = stats;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
