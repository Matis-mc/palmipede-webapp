package com.polytech.palmipedewebapp.service;

import com.polytech.palmipedewebapp.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.time.LocalDate.now;

@Service
public class ChartService {

    @Autowired
    private ApplicationRepository repository;

    private int DEFAULT_PERIOD = 30;


    //TODO : par défaut, sur les 30 derniers jours, mais par la suite, faire pour date de départ et intervals de temps variables

    /**
     * Si date est à null, on prend par défault la date du jour. Il s'agit de la dernière date qui sera donné, la plus récente.
     * Si interval est égal à -1, on prend la période par défault
     * @param idEspece
     * @param date
     * @param interval
     * @return
     */
    public Map<Date,Integer> getNbPontesByDayByEspece(Long idEspece, LocalDate date, int interval){
        //on travaille en LocalDate pour la fonction minusDays
        Map<Date,Integer> mapPontes = new TreeMap<Date, Integer>();
        LocalDate currentDate;

        if(date != null){
            currentDate = date;
        }else{
            currentDate = now();
        }

        int imax;

        if(interval != -1){
            imax = interval;
        }else{
            imax = DEFAULT_PERIOD;
        }

        int i = 0;
        while(i <= imax){
            //on transforme en date sql .... c'est moche mais je n'ai pas trouvé de solution plus rapide
            Date dateToRequest = Date.valueOf(currentDate);
            int nbPonte = repository.getCountPonteByEspece(idEspece, dateToRequest);
            mapPontes.put(dateToRequest, nbPonte);
            currentDate = currentDate.minusDays(1l);
            i++;
        }

        //TreeMap<Date, Integer> sorted = new TreeMap<>(mapPontes);

        return mapPontes;
    }

    public Map<Date, Integer> getNbPontesByDayByBatiment(Long idBatiment, LocalDate date, int interval){
        Map<Date,Integer> mapPontes = new TreeMap<Date, Integer>();
        LocalDate currentDate;

        if(date != null){
            currentDate = date;
        }else{
            currentDate = now();
        }

        int imax;

        if(interval != -1){
            imax = interval;
        }else{
            imax = DEFAULT_PERIOD;
        }

        int i = 0;
        while(i <= imax){
            //on transforme en date sql .... c'est moche mais je n'ai pas trouvé de solution plus rapide
            Date dateToRequest = Date.valueOf(currentDate);
            int nbPonte = repository.getCountPonteByEspece(idBatiment, dateToRequest);
            mapPontes.put(dateToRequest, nbPonte);
            currentDate = currentDate.minusDays(1l);
            i++;
        }

        //TreeMap<Date, Integer> sorted = new TreeMap<>(mapPontes);

        return mapPontes;
    }


}
