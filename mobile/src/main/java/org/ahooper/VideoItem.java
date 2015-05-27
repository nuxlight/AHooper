package org.ahooper;

/**
 * Created by Thibaud on 27/05/15.
 * Class de test pour les vignettes video appelé ici item
 * @author Thibaud Pellissier (thibaudpellissier@gmail.com)
 * @version 0.1
 */
public class VideoItem {
    private String videoTitle;
    private String videoURL;
    private String videoImageURL;
    private String videoPlateform;
    private String videoDate;   //Voir pour l'utilisation des dates de la classe Java
    private String videoType;

    /**
     * COnstructeur principal des items video
     * @param vt    Titre de la video
     * @param vu    Url de la video
     * @param viu   Url de l'image de l'item
     * @param vp    Plateform de la video
     * @param vd    Date de la video
     * @param vty   Type de la video (Epopee, Defi, etc...)
     */
    public VideoItem(String vt, String vu, String viu, String vp, String vd, String vty){
        videoTitle = vt;
        videoURL = vu;
        videoImageURL = viu;
        videoPlateform = vp;
        videoDate = vd;
        videoType = vty;
    }

    /**
     * Afficher le contenue d'un item
     */
    public void displayItem(){
        System.out.println("Titre : "+videoTitle);
        System.out.println("Image : "+videoImageURL);
        System.out.println("Url : "+videoURL);
        System.out.println("Plateform : "+videoPlateform);
        System.out.println("date : "+videoDate);
        System.out.println("type : "+videoType);
    }
}
