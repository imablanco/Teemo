package com.ablanco.teemo.model.staticdata;

import android.media.Image;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class SummonerSpellDto extends BaseObject {

    private List<Double> cooldown;
    private String cooldownBurn, costBurn, costType, name, rangeBurn, resource;
    private List<Integer> cost;
    private String description, sanitizedDescription, sanitizedTooltip, tooltip;
    private List<EffectList> effect;
    private List<String> effectBurn;
    private Integer id;
    private Image image;
    private String key;
    private LevelTipDto leveltip;
    private Integer maxrank, summonerLevel;
    private List<String> modes;
    private List<Integer> range;
    private List<SpellVarsDto> vars;

    public List<Double> getCooldown() {
        return cooldown;
    }

    public void setCooldown(List<Double> cooldown) {
        this.cooldown = cooldown;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRangeBurn() {
        return rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSanitizedDescription() {
        return sanitizedDescription;
    }

    public void setSanitizedDescription(String sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public String getSanitizedTooltip() {
        return sanitizedTooltip;
    }

    public void setSanitizedTooltip(String sanitizedTooltip) {
        this.sanitizedTooltip = sanitizedTooltip;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public List<EffectList> getEffect() {
        return effect;
    }

    public void setEffect(List<EffectList> effect) {
        this.effect = effect;
    }

    public List<String> getEffectBurn() {
        return effectBurn;
    }

    public void setEffectBurn(List<String> effectBurn) {
        this.effectBurn = effectBurn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LevelTipDto getLeveltip() {
        return leveltip;
    }

    public void setLeveltip(LevelTipDto leveltip) {
        this.leveltip = leveltip;
    }

    public Integer getMaxrank() {
        return maxrank;
    }

    public void setMaxrank(Integer maxrank) {
        this.maxrank = maxrank;
    }

    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Integer summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public List<String> getModes() {
        return modes;
    }

    public void setModes(List<String> modes) {
        this.modes = modes;
    }

    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }

    public List<SpellVarsDto> getVars() {
        return vars;
    }

    public void setVars(List<SpellVarsDto> vars) {
        this.vars = vars;
    }
}
