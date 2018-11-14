package com.br.neogridconference;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe análisa um arquivo de texto de dados. Objetivo é buscar os atributos:
 * nome, tempo de de duração. Cada linha do arquivo é analisado e adicionado uma
 * Activity na activitiesList Retornar uma lista com todas as atividades.
 */
public class ReadActivityFile {

    private List<Activity> activitiesList;

    /**
     * Constroi a lista, não sendo necessário criá-la no main()
     */
    public ReadActivityFile() {
        activitiesList = new LinkedList<Activity>();
    }

    /**
     * Função abrir o arquivo input.txt de fonte de dados. Deve estar localizado
     * dentro do pacote raiz do projeto. Percorre todas as linhas do arquivo.
     *
     * @param pathFile Caminho do arquivo para anaálise
     */
    public void startReadActivityFile(String pathFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            while (br.ready()) {
                String line = br.readLine();
                dividerNameEndTime(line);
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    /**
     * Função Separa numeros de letras Cria um objeto Activity e adiciona na
     * activitiesList
     *
     * @param string consiste em uma linha que foi lida do arquivo
     */
    public void dividerNameEndTime(String string) {
        String name = "";
        String name1 = "";
        String time = "";

        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                time += c;
            } else {
                name += c;
            }
        }

        name1 = name.replaceAll("min", "").trim();
        if (time == "") {
            time = "0";
        }

        Activity activity = new Activity(name1, Integer.parseInt(time));

        activitiesList.add(activity);

    }

    /**
     * Função adiciona um objeto do tipo Activity, oferecendo dois formatos
     *
     * @param name nome da atividade
     * @param time tempo da atividade 1º - Cria o objetivo, precisando somente
     * do nome e tempo 2º - Adiciona o objeto que já foi criado
     */
    public void addActivity(String name, int time) {
        Activity activity;
        activity = new Activity(name, time);
        this.activitiesList.add(activity);
    }

    public void addActivity(Activity activity) {
        this.activitiesList.add(activity);
    }

    /**
     * Retira o Activity da activitiesList
     *
     * @param activity, consiste no objeto que deve ser retirado
     */
    public void removeActivity(Activity activity) {
        for (int i = 0; i < this.activitiesList.size(); i++) {
            Activity activityAux = (Activity) this.activitiesList.get(i);
            if (activityAux.equals(activity)) {
                this.activitiesList.remove(i);
            }
        }
    }

    /**
     * Função retorna a activitiesList
     */
    public List<Activity> getActivitiesList() {
        return activitiesList;
    }

    /**
     * Função retorna uma Activity da activitiesList conforme o id informado
     *
     * @param Id, indece da activitiesList
     */
    public Activity getByIdInActivitiesList(int Id) {
        return activitiesList.get(Id);
    }

    /**
     * Função busca o Activity com maior tempo na activitiesList
     */
    public Activity getLongerTimeActivity() {
        Activity activity_aux;
        activity_aux = activitiesList.get(0);
        for (Activity short_course : this.activitiesList) {
            if (short_course.getTime() > activity_aux.getTime()) {
                activity_aux = short_course;
            }
        }
        return activity_aux;
    }

    /**
     * Função busca o Activity com menor tempo na activitiesList
     */
    public Activity getShorterTimeActivity() {
        Activity activity_aux;
        activity_aux = activitiesList.get(0);

        for (Activity short_course : activitiesList) {
            if (short_course.getTime() < activity_aux.getTime()) {
                activity_aux = short_course;
            }
        }
        return activity_aux;
    }

    /**
     * Função busca o Activity com menor tempo na activitiesList
     */
    public Activity getTimeActivityWith30Min() {

        for (Activity activity : activitiesList) {
            if (activity.getTime() == 30) {
                return activity;
            }
        }
        return null;
    }

    /**
     * Função imprime a activitiesList
     */
    public void printList() {
        String listString = "";

        for (Activity activity : activitiesList) {
            listString += activity.toString() + "\n";
        }

        System.out.println(listString);
    }
}
