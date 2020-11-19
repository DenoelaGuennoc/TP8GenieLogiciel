package champollion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.LinkedList;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    private HashMap<UE, ServicePrevu> mesServices = new HashMap<>();
    private LinkedList<Intervention> mesInterventions = new LinkedList<>();
    
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        int heuresPrevues = 0;
        Iterator<Map.Entry<UE, ServicePrevu>> iterator = mesServices.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
            heuresPrevues += heuresPrevuesPourUE((UE) entry.getKey());
        }
        return heuresPrevues;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        int vCM = mesServices.get(ue).getVolumeCM();
        int vTD = mesServices.get(ue).getVolumeTD();
        int vTP = mesServices.get(ue).getVolumeTP();
        float equUETD = calculEquivalentTD(vCM, vTD, vTP);
        return (int)equUETD;
    }

    public float calculEquivalentTD(int vCM, int vTD, int vTP){
        float equivalentTD = vCM*(3/2) + vTD + vTP*(3/4);
        return equivalentTD;
    }
    
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        if(mesServices.containsKey(ue)){
            int ancienVolumeCM = mesServices.get(ue).getVolumeCM();
            int ancienVolumeTD = mesServices.get(ue).getVolumeTD();
            int ancienVolumeTP = mesServices.get(ue).getVolumeTP();
            
            int nouveauVolumeCM = volumeCM + ancienVolumeCM;
            int nouveauVolumeTD = volumeTD + ancienVolumeTD;
            int nouveauVolumeTP = volumeTP + ancienVolumeTP;
            
            ServicePrevu nouveauService = new ServicePrevu(nouveauVolumeCM, nouveauVolumeTD, nouveauVolumeTP);
            mesServices.replace(ue, nouveauService);
        }
        else {
            ServicePrevu nouveauService = new ServicePrevu(volumeCM, volumeTD, volumeTP);
            mesServices.put(ue, nouveauService);
        }
    }
    
    public void ajouteIntervention(Intervention nouvelleIntervention){
        mesInterventions.add(nouvelleIntervention);
    }

}
