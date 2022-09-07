package com.example.listviewtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Orage", "Pear", "Watermelon", "Banana"};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        initFruit();
        FruitAdapter adapter1 = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        for (int i=0; i < 4; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.aaa);
            fruitList.add(apple);

            Fruit orage = new Fruit("Orage", R.drawable.aaa);
            fruitList.add(orage);

            Fruit pear = new Fruit("Pear", R.drawable.aaa);
            fruitList.add(pear);

            Fruit watermelon = new Fruit("Watermelon", R.drawable.aaa);
            fruitList.add(watermelon);

            Fruit banana = new Fruit("Banana", R.drawable.aaa);
            fruitList.add(banana);

        }
    }

    public class Fruit {
        private String name;
        private int imageId;

        public Fruit(String name, int imageId) {
            this.name = name;
            this.imageId = imageId;
        }

        public String getName() {
            return name;
        }

        public int getImageId() {
            return imageId;
        }
    }

    public class FruitAdapter extends ArrayAdapter<Fruit> {
        private int reSourceId;

        public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objests) {
            super(context, textViewResourceId, objests);
            reSourceId = textViewResourceId;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Fruit fruit = getItem(position);
            View view;
            ViewHoler viewHolder;
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(reSourceId,parent,false);
                viewHolder = new ViewHoler();
                viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
                viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
                view.setTag(viewHolder);
            }
            else {
                view = convertView;
                viewHolder = (ViewHoler) view.getTag();
            }
            viewHolder.fruitImage.setImageResource(fruit.getImageId());
            viewHolder.fruitName.setText(fruit.getName());
            return view;
        }

        class ViewHoler {
            ImageView fruitImage;
            TextView fruitName;
        }
    }

}