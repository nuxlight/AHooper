package org.ahooper.JsoupTasks;

import android.os.AsyncTask;

import org.ahooper.VideoItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thibaud on 27/05/15.
 */
public class GetVideoTask {

    public static List<String> getNewersVideo(){
        List<String> result=new ArrayList<>();
        String url = "http://www.hooper.fr";
        try {
            Document doc = Jsoup.connect(url).get();
            Element content = doc.getElementById("block-views-frontpage-block_1");
            Elements links = content.getElementsByAttributeValueMatching("class","views-field-field-video-embed");
            int index=0;
            for(Element link : links){
                result.add((index++), "Titre : " + link.select("a[href]").text());
                result.add((index++), "Image : " + link.select("a").select("img").attr("src"));
                result.add((index++), "url : " + url + link.select("a[href]").attr("href"));
            }
            return result;
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
        }
        return null;
    }

    /**
     * Récupère les nouvelles video de la page principal d'Hooper.fr
     * @return Retourne une liste d'item (fiche video)
     */
    public static List<VideoItem> getLastVideo(){
        List<VideoItem> result=new ArrayList<>();
        //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        String url = "http://www.hooper.fr";
        try{
            Document doc = Jsoup.connect(url).get();
            //page d'acceuil
            Element content = doc.getElementById("block-views-frontpage-block_3");
            //une page (ici epopee)
            //Element content = doc.getElementById("main");
            //Cette ligne tue sa maman de malade :D
            Elements links = content.getElementsByAttributeValueMatching("class","views-row");
            int index = 0;
            for(Element link : links){
                VideoItem item = new VideoItem(link.select("a[href]").text(),
                        link.select("a").select("img").attr("src"),
                        url + link.select("a[href]").attr("href"),
                        link.select("span").eq(4).text(),
                        link.select("span").eq(6).text(),
                        link.select("span").eq(0).text());
                result.add((index), item);
            }
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
        }
        for(int a=0;a<result.size();a++){
            return result;
        }
        return null;
    }

    public static List<VideoItem> getLastLive(){
        List<VideoItem> result=new ArrayList<>();
        //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        String url = "http://www.hooper.fr";
        try{
            Document doc = Jsoup.connect(url).get();
            //page d'acceuil
            Element content = doc.getElementById("block-views-frontpage-block_2");
            //une page (ici epopee)
            //Element content = doc.getElementById("main");
            //Cette ligne tue sa maman de malade :D
            Elements links = content.getElementsByAttributeValueMatching("class","views-row");
            int index = 0;
            for(Element link : links){
                VideoItem item = new VideoItem(link.select("a[href]").text(),
                        link.select("a").select("img").attr("src"),
                        url + link.select("a[href]").attr("href"),
                        link.select("span").eq(4).text(),
                        link.select("span").eq(6).text(),
                        link.select("span").eq(0).text());
                result.add((index), item);
            }
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
        }
        for(int a=0;a<result.size();a++){
            return result;
        }
        return null;
    }

    public static List<VideoItem> getVideoBySection(String section, int pages){
        List<VideoItem> result=new ArrayList<>();
        //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        String url = "http://www.hooper.fr/"+section+"?page="+pages;
        try{
            Document doc = Jsoup.connect(url).get();
            //page d'acceuil
            Element content = doc.getElementById("main");
            //une page (ici epopee)
            //Element content = doc.getElementById("main");
            //Cette ligne tue sa maman de malade :D
            Elements links = content.getElementsByAttributeValueMatching("class","views-row");
            int index = 0;
            for(Element link : links){
                VideoItem item = new VideoItem(link.select("a[href]").text(),
                        link.select("a").select("img").attr("src"),
                        url + link.select("a[href]").attr("href"),
                        link.select("span").eq(4).text(),
                        link.select("span").eq(6).text(),
                        link.select("span").eq(0).text());
                result.add((index), item);
            }
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
        }
        for(int a=0;a<result.size();a++){
            return result;
        }
        return null;
    }

    public static int getNumPage(String section){
        String url = "http://www.hooper.fr/"+section;
        try{
            Document doc = Jsoup.connect(url).get();
            Elements context = doc.getElementsByAttributeValueContaining("class","pager");
            Elements links = context.select("li").select("a[href]");
            int page = 0;
            for(Element link : links){
                page++;
            }
            page = page-2;
            return page;
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
        }
        return 0;
    }
}
