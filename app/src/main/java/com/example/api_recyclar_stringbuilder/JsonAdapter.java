package com.example.api_recyclar_stringbuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapter extends RecyclerView.Adapter<JsonAdapter.JsonHolder> {
    Context  context;
    List<JsonModel> jsonModelList=new ArrayList<>();
    LayoutInflater layoutInflater;

    public JsonAdapter(Context context, List<JsonModel> jsonModelList) {
        this.context = context;
        this.jsonModelList = jsonModelList;
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public JsonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new JsonHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull JsonHolder holder, int position) {
        holder.id.setText(""+jsonModelList.get(position).getId());
        holder.name.setText(""+jsonModelList.get(position).getName());
        holder.mobile.setText(""+jsonModelList.get(position).getMobile());
        holder.dateInfo.setText(""+jsonModelList.get(position).getDateInfo());
        holder.password.setText(""+jsonModelList.get(position).getPassword());
        holder.email.setText(""+jsonModelList.get(position).getEmail());

//        holder.userid.setText(""+jsonModelList.get(position).getUserid());
//        holder.id.setText(""+jsonModelList.get(position).getId());
//        holder.title.setText(""+jsonModelList.get(position).getTitle());
//        holder.body.setText(""+jsonModelList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return jsonModelList.size();
    }

    public class JsonHolder extends RecyclerView.ViewHolder {
        TextView id,name,mobile,dateInfo,password,email;

        public JsonHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.ID);
            name=itemView.findViewById(R.id.Nameid);
            mobile=itemView.findViewById(R.id.Mobileid);
            dateInfo=itemView.findViewById(R.id.DateInfoid);
            password=itemView.findViewById(R.id.Passwordid);
            email=itemView.findViewById(R.id.Emailid);
        }
    }
}
