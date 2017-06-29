package com.example.android.moranlee.uofs_important_date;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView orient;

    GridView useful;

    ArrayAdapter<String> dates;

    ImageAdapter links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orient = (ListView)findViewById(R.id.dates);
        useful = (GridView) findViewById(R.id.links);
        dates = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,getImport());
        links = new ImageAdapter(this);
        orient.setAdapter(dates);
        useful.setAdapter(links);
        setOnclickList();
        setOnClickGrid();
    }

    private void setOnclickList(){
        orient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://students.usask.ca/academics/classes.php#Registrationdeadlines")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://students.usask.ca/money/tuition-fees/pay.php#Duedates")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://students.usask.ca/academic-calendar/2017-2018.php")));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void setOnClickGrid(){
        useful.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://paws5.usask.ca/")));
                        break;
                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://campus.usask.ca/")));
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://pawnss.usask.ca/ban/bwckschd.p_disp_dyn_sched")));
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.usask.ca/programs/")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.usask.ca/culinaryservices/marquis-menu.php")));
                        break;
                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.usask.ca/calendar/coursecat/index.php?start_term=201705&end_term=201801")));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private ArrayList<String> getImport(){
        ArrayList dates = new ArrayList();
        String [] temp = getResources().getStringArray(R.array.dates);
        for(int i=0;i<temp.length;i++){
            dates.add(temp[i]);
        }
        return dates;
    }

    public void shareToFriends(View view) {
        Intent shareIntenet = new Intent(Intent.ACTION_SEND);
        shareIntenet.setType("text/plain");
        String sharingObject = "Ask for wehchat:a542549195 for a copy of this useful application";
        shareIntenet.putExtra(Intent.EXTRA_TEXT,sharingObject);
        startActivity(Intent.createChooser(shareIntenet,"Share Via"));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.paws,
                R.drawable.email,
                R.drawable.calander,
                R.drawable.collage,
                R.drawable.marquis,
                R.drawable.classes
        };
    }
}
