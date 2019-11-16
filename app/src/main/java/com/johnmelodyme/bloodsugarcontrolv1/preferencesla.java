package com.johnmelodyme.bloodsugarcontrolv1;
//https://www.youtube.com/watch?v=5Tm--PHhbJo
////////////////////////////////////////////
/*
 *このページは、読み込みに伴うスプラッシュです。
 * これは John Melody Melissa によってコーディングされています。
 * このライセンスは、商標、サービスマーク、
 * または貢献者のロゴ（準拠するために必要な場合を除く）
 * セクション3.4の通知要件）。
 **/
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class preferencesla extends AppCompatActivity {

    ListView listView_列表顯示;
    String setting[];

    {
        setting = new String[]{"Email To Developer", "Contact Us", "Version", "Logout", "FAQ"};
    }

    String descriptiob[];

    {
        descriptiob = new String[]{"", "", "V1.0.1", "", ""};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencesla);

        listView_列表顯示 = findViewById(R.id.Setting_list_設置);
    }

    class DontKnowWhateverSettingPunyaListViewAdapter extends ArrayAdapter<String> {
        Context context;
        String  rSetting[];
        String rDescription[];

        DontKnowWhateverSettingPunyaListViewAdapter (Context c, String Setting[], String discripxion[]){
            super(c, R.layout.row, R.id.LIVETEXT, Setting);
            // super(c. R.layout.row, R.id.descriptixion, discripxion);
            this.context = c;
            this.rSetting = Setting;
            this.rDescription = discripxion;
        }

        @SuppressLint("ViewHolder")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater)getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row;
            row = layoutInflater.inflate(R.layout.row, parent,false);


            return super.getView(position, convertView, parent);
        }
    }
}
