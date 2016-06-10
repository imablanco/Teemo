package com.ablanco.teemo.persistence.championmastery;

import com.ablanco.teemo.model.championmastery.ChampionMasteryDto;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

/**
 * Created by Álvaro Blanco Cabrero on 9/6/16
 * TonsOfDamage
 */
public class ChampionMasteryDtoDAO extends BaseDAO<ChampionMasteryDto> {

    public ChampionMasteryDtoDAO() {
        super(ChampionMasteryDto.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_HALF_HOUR;

    }

    public ChampionMasteryDto findByChampionIdAndPlayerId(Long championId, Long playerId){
        return findFirst("championId LIKE ? AND playerId = ?", new String[]{String.valueOf(championId), String.valueOf(playerId)}, null, null);
    }
}
