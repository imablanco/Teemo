package com.ablanco.teemo.service.base;

import com.ablanco.teemo.model.staticdata.LanguageStringsDto;
import com.ablanco.teemo.persistence.languages.LanguageStringDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class ResourcesHandler {

    public static List<String> getIds(){
        //ni matter what locale its saved, keys always remain the same
        LanguageStringDAO dao = new LanguageStringDAO();
        LanguageStringsDto languageStringsDto = dao.findFirst();
        List<String> ids = new ArrayList<>();
        if(languageStringsDto != null){
            ids.addAll(languageStringsDto.getData().keySet());
        }

        return ids;
    }

    public static String getResourceByName(String key){
        LanguageStringDAO dao = new LanguageStringDAO();
        LanguageStringsDto languageStringsDto = dao.findFirst();
        String resource = null;
        if(languageStringsDto != null){
            resource = languageStringsDto.getData().get(key);
        }

        return resource == null ? "" : resource;
    }
}
