package com.br.neogridconference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe cria um cronograma em formato de lista ordenando todas as atividadades
 * Recebe um objeto do tipo ReadActivityFile Retorna uma lista organizando todas
 * As atividades são alocadas no cronograma conforme as regras de negocio
 * propostas pela tarefa
 */
public class ScheduleOfActivities {

    private int track;
    Date controlTime;
    List<String> listScheduleOfActivities;

    public ScheduleOfActivities() throws ParseException {
        this.track = 0;
        this.controlTime = new SimpleDateFormat("hh:mm:ss").parse("09:00:00");
        this.listScheduleOfActivities = new LinkedList<String>();
    }

    /**
     * Função realiza todo o gerenciamento para inclusão das atividades
     *
     * @param readActivityFile Consiste em uma lista com todas as atividades a
     * serem inclusas no cronogram
     */
    public void addActivityInSchedule(ReadActivityFile readActivityFile) {

        //While percorre todo array readActivityFile
        //Removendo cada Activity que for inclusa no array  listScheduleOfActivities
        while (readActivityFile.getActivitiesList().size() > 0) {

            //Verifica se deve trocar o trackDay
            if (bussinessRulesTrackDay()) {
                addTrackDay(this.track);
            }

            //Busca a Activity com maior tempo no array readActivityFile
            Activity activity;
            activity = readActivityFile.getLongerTimeActivity();

            //Verifica se a Activity de ser Adicionada antes das 12hs
            if (businessRulesTimeLouch(activity.getTime())) {
                addActivity(activity);
                addIncrementInControlTime(activity);

                //Verifica se a Activity de ser Adicionada as 13hs
            } else if (businessRulesactivityNetworks(activity.getTime())) {
                addActivity(activity);
                addIncrementInControlTime(activity);
            }
            
          
            //remove a Activity do array readActivityFile
            readActivityFile.removeActivity(activity);
            
              if(readActivityFile.getActivitiesList().size()<=0){
                addNetworkingEventActivity();
            }
        }

    }

    /**
     * Adiciona TrackDay na listScheduleOfActivities
     *
     * @param day dia que deve ser incluida no cronograma
     */
    public void addTrackDay(int day) {
        String track;
        track = "Track " + day + ":";
        this.listScheduleOfActivities.add(track);
    }

    /**
     * Adiciona Activity no cronograma
     *
     * @param activity refere-se a atividade que será incluida
     */
    public void addActivity(Activity activity) {
        String activityAux;
        activityAux = businessRulesConvertTime(this.controlTime) + " " + activity.getName()
                + " " + activity.getTime() + "min";
        this.listScheduleOfActivities.add(activityAux);
    }

    /**
     * Adicona Activity Louch no cronograma
     */
    public void addLouchTimeActivity() {
        String lunchTime;

        this.controlTime.setHours(12);
        this.controlTime.setMinutes(00);
        this.controlTime.setSeconds(00);

        lunchTime = businessRulesConvertTime(this.controlTime) + " lunch";
        this.listScheduleOfActivities.add(lunchTime);
        this.controlTime.setHours(13);
    }

    /**
     * Adicona Activity de NetworkingEvent no cronograma Redefine a variavel
     * controlTime para 9hs
     */
    public void addNetworkingEventActivity() {
        String networkingEventActivity;
        networkingEventActivity = businessRulesConvertTime(this.controlTime) + " Networking Event";
        this.listScheduleOfActivities.add(networkingEventActivity);

        this.controlTime.setHours(9);
        this.controlTime.setMinutes(00);
        this.controlTime.setSeconds(00);
    }

    /**
     * Realiza o incremento de milissegundos
     *
     * @param activity é a atividade que será calculada
     */
    public void addIncrementInControlTime(Activity activity) {
        long controlTimeMilissec = this.controlTime.getTime();
        long activityTimeMilissec = activity.getTime() * 60000;

        long newcontrlTime = controlTimeMilissec + activityTimeMilissec;
        this.controlTime.setTime(newcontrlTime);
    }

    /**
     * Verifica se activity dese ser inclusa antes do horario de almoço
     *
     * @param timeSec tempo em segundos
     * @return true se controlTimeAux for menor ou igual a 12hs
     */
    public boolean businessRulesTimeLouch(int timeMin) {
        Boolean response = false;

        Date controlTimeAux = (Date) this.controlTime.clone();
        long timeAux = controlTimeAux.getTime() + (timeMin * 60000);
        controlTimeAux.setTime(timeAux);

        //Adicona activity no cronograma antes do almoço
        if (controlTimeAux.getHours() <= 12 && controlTimeAux.getMinutes() <= 0) {
                response = true;

            //Adiciona activity horario de almoço        
        } else if (controlTimeAux.getHours() > 12 && controlTimeAux.getHours() <= 13) {
            addLouchTimeActivity();
        }

        return response;
    }

    /**
     * Verifica quanto tempo ainda resta antes das 16hs
     *
     * @param timeSec tempo em segundos
     * @return true se o tempo tiver ultrapassado as 16hs, caso contrário false
     */
    public boolean businessRulesactivityNetworks(int timeMin) {
        Boolean response = false;
        Date controlTimeAux = (Date) this.controlTime.clone();
        long timeAux = controlTimeAux.getTime() + (timeMin * 60000);
        controlTimeAux.setTime(timeAux);

        if (controlTimeAux.getHours() <= 16) {
            response = true;
        } else if (controlTimeAux.getHours() >= 16) {
            addNetworkingEventActivity();
        } else {
            addNetworkingEventActivity();
        }
        


        return response;
    }

    /**
     * Formata a data para o padrão solicitado
     *
     * @param dateConvert corresponde a uma data no formato SimpleDateFormat
     * @return A data no forma hh:mmaa conforme regra de
     */
    public String businessRulesConvertTime(Date dateConvert) {
        String response;

        SimpleDateFormat activityTime = new SimpleDateFormat("hh:mmaa");
        response = activityTime.format(dateConvert);
        return response;
    }

    /**
     * Verifica se o track deve mudar, ou continuar o mesmo
     */
    public boolean bussinessRulesTrackDay() {
        Boolean response = false;

        if (this.controlTime.getHours() == 9 && this.controlTime.getMinutes() == 0) {
            this.track += 1;
            this.listScheduleOfActivities.add("");
            response = true;
        }
        return response;
    }

    /**
     * Realiza a impressão do cronograma
     */
    public void printSchedule() {
        for (String activity : this.listScheduleOfActivities) {
            System.out.println(activity);
        }

    }
}
