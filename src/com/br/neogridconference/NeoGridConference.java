package com.br.neogridconference;

import java.text.ParseException;

public class NeoGridConference {

    public static void main(String[] args) throws ParseException {

        //Cria Objeto que vai ler e organizar o arquivo input.txt
        ReadActivityFile readeList;
        readeList = new ReadActivityFile();

        //Realiza a leitura do arquivo input.txt
        readeList.startReadActivityFile("src/com/br/neogridconference/input.txt");

        //Cria o objeto que vai devolver o cronograma organizado
        ScheduleOfActivities schrdule;
        schrdule = new ScheduleOfActivities();

        //Passa a lista de atividades para ser organizada.
        schrdule.addActivityInSchedule(readeList);
        schrdule.printSchedule();

    }

}
