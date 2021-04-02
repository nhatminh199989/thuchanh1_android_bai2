package com.example.test2_de2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Student> {
    private ArrayAdapter adapter;
    private Activity activity;
    private List<Student> mList;
    public ListViewAdapter(@NonNull Context context,List<Student> list){
        super(context,R.layout.item,list);
        this.mList = list;
        this.activity = (Activity) context;
        this.adapter = this;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.item,parent,false);
        Student s = mList.get(position);
        ImageView img = v.findViewById(R.id.student_img);
        TextView t1 = v.findViewById(R.id.student_id);
        TextView t2 = v.findViewById(R.id.student_name);
        TextView t3 = v.findViewById(R.id.student_gender);
        TextView t4 = v.findViewById(R.id.student_dob);
        Button delBtn = v.findViewById(R.id.btn_del);
        img.setImageResource(s.getImage());
        t1.setText(s.getId());
        t2.setText(s.getName());
        t3.setText(s.getGender());
        t4.setText(s.getDob()+"");
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        return v;
    }

    public Student getItem(int pos){
        return mList.get(pos);
    }

}
