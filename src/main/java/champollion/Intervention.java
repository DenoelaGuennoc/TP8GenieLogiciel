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
    private TypeIntervention typeInter;
    
    
    public Intervention (Salle s, UE ue, Enseignant e, Date deb, int duree){
        this.salleInter = s;
        this.ueInter = ue;
        this.enseignantInter = e;
        this.debut = deb;
        this.duree = duree;
    }
    
    public Date getDebut(){
        return debut;
    }
    
    public int getDuree(){
        return duree;
    }
    
    public boolean getAnnulee(){
        return annulee;
    }
    
    public Salle getSalleInter(){
        return salleInter;
    }
    
    public UE getUEInter(){
        return ueInter;
    }
    
    public Enseignant getEnseignantInter(){
        return enseignantInter;
    }
    
    public TypeIntervention getTypeInter(){
        return typeInter;
    }
    
    public void annulerIntervention() throws Exception{
        if(!annulee){
            throw new Exception("Cette intervention est déjà annulée");
        }
        else {
            annulee = true;
        }
    }
    
    public void setTypeIntervention(TypeIntervention pTypeInter){
        typeInter = pTypeInter;
    }
}
