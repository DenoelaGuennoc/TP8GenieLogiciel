/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Denoëla
 */
public class Intervention {
    
    private Date debut = new Date();
    private int duree;
    private boolean annulee = false;
    private Salle salleInter;
    private UE ueInter;
    private Enseignant enseignantInter;
    
    
    public Intervention (Salle s, UE ue, Enseignant e, Date deb, int duree){
        this.salleInter = s;
        this.ueInter = ue;
        this.enseignantInter = e;
        this.debut = deb;
        this.duree = duree;
    }
}
