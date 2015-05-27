package org.ahooper.JsoupTasks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Thibaud on 27/05/15.
 */
public class GetVideoTask {

    /**
     * Récupère les nouvelles video de la page principal d'Hooper.fr
     * @return Retourne une liste d'item (fiche video)
     */
    public ArrayList<HashMap<String, String>> getLastVideo(){
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        String url = "http://www.hooper.fr";
        try{
            Document doc = Jsoup.connect(url).get();
            Element content = doc.getElementById("block-views-frontpage-block_3");
            Elements links = content.getElementsByAttributeValueMatching("class", "views-row");
            int index = 0;
            for(Element link : links){
                HashMap<String, String> map;
                map = new HashMap<String, String>();
                map.put("videoTitle", link.select("a[href]").text());
                map.put("videoURL", link.select("a").select("img").attr("src"));
                map.put("videoImageURL", url + link.select("a[href]").attr("href"));
                map.put("videoPlateform", link.select("span").eq(4).text());
                map.put("videoDate", link.select("span").eq(6).text());
                map.put("videoType", link.select("span").eq(0).text());
                listItem.add(map);
            }
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
            return null;
        }
        return listItem;
    }

    public static ArrayList<HashMap<String, String>> getLastLive(){
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        String url = "http://www.hooper.fr";
        try{
            Document doc = Jsoup.connect(url).get();
            Element content = doc.getElementById("block-views-frontpage-block_2");
            Elements links = content.getElementsByAttributeValueMatching("class", "views-row");
            int index = 0;
            for(Element link : links){
                HashMap<String, String> map;
                map = new HashMap<String, String>();
                map.put("videoTitle", link.select("a[href]").text());
                map.put("videoURL", link.select("a").select("img").attr("src"));
                map.put("videoImageURL", url + link.select("a[href]").attr("href"));
                map.put("videoPlateform", link.select("span").eq(4).text());
                map.put("videoDate", link.select("span").eq(6).text());
                map.put("videoType", link.select("span").eq(0).text());
                listItem.add(map);
            }
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
            return null;
        }
        return listItem;
    }

    public static ArrayList<HashMap<String, String>> getVideoBySection(String section, int pages){
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
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
                HashMap<String, String> map;
                map = new HashMap<String, String>();
                map.put("videoTitle", link.select("a[href]").text());
                map.put("videoURL", link.select("a").select("img").attr("src"));
                map.put("videoImageURL", url + link.select("a[href]").attr("href"));
                map.put("videoPlateform", link.select("span").eq(4).text());
                map.put("videoDate", link.select("span").eq(6).text());
                map.put("videoType", link.select("span").eq(0).text());
                listItem.add(map);
            }
        }
        catch (Exception e){
            System.out.println("[ERROR] - " + e.toString());
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
