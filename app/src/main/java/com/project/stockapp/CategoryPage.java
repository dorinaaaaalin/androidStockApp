package com.project.stockapp;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ListView;

import org.w3c.dom.Text;

public class CategoryPage extends AppCompatActivity{


    int[] IMAGES = {R.drawable.basicmaterials, R.drawable.industrialgoods
            , R.drawable.financial, R.drawable.conglomerates
            , R.drawable.services, R.drawable.utilities
            , R.drawable.consumergoods, R.drawable.technology
            , R.drawable.healthcare};

    String[] NAMES = {"Basic Materials", "Industrial Goods"
            , "Financial", "Conglomerates", "Services", "Utilities"
            , "Consumer Goods", "Technology", "Healthcare"};

    String[] DESCRIPTIONS = {"Basic Materials Descriptions", "Industrial Goods Descriptions"
            , "Financial Descriptions", "Conglomerates Descriptions"
            , "Services Descriptions", "Utilities Descriptions"
            , "Consumer Goods Descriptions", "Technology Descriptions"
            , "Healthcare Descriptions"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_page);

        ListView listView= (ListView) findViewById(R.id.listView);

        CustomAdaptor customAdaptor = new CustomAdaptor();

        listView.setAdapter(customAdaptor);
    }

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout, null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView_category);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_category_name);
            TextView textView_description = (TextView)view.findViewById(R.id.textView_category_description);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTIONS[i]);

            return view;
        }
    }





}