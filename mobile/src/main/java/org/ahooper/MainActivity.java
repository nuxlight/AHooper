package org.ahooper;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.ahooper.JsoupTasks.GetVideoTask;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends Activity {

    private String[] drawerItemsList;
    private ListView myDrawer;
    private ListView listVideo;
    private DrawerLayout mDrawerobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionbar = getActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        setContentView(R.layout.activity_main);

        //Test des fonctions Jsoup
        GetVideoTask videoTask = new GetVideoTask();

        listVideo = (ListView) findViewById(R.id.home_liste);

        ArrayList<HashMap<String, String>> listItem = videoTask.getLastVideo();

        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.item_video_layout,
                new String[] {"videoTitle", "videoImageURL", "videoPlateform", "videoDate", "videoType"},
                new int[] {R.id.titre_item, R.id.image_item, R.id.console_item, R.id.date_item, R.id.type_item});

        listVideo.setAdapter(mSchedule);

        drawerItemsList = getResources().getStringArray(R.array.items);
        myDrawer = (ListView) findViewById(R.id.my_drawer);
        myDrawer.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_item, drawerItemsList));

    }
}
