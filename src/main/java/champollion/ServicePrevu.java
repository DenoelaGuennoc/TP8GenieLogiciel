package champollion;

public class ServicePrevu {
    // TODO : implémenter cette classe
    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    
    public ServicePrevu (int vCM, int vTD, int vTP){
        this.volumeCM = vCM;
        this.volumeTD = vTD;
        this.volumeTP = vTP;
    }
    
    public int getVolumeCM(){
        return volumeCM;
    }
    
    public int getVolumeTD(){
        return volumeTD;
    }
    
    public int getVolumeTP(){
        return volumeTP;
    }
}
