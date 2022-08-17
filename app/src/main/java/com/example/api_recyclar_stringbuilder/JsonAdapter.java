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
    List<JsonModel>jsonModelList=new ArrayList<>();
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
        holder.userid.setText(""+jsonModelList.get(position).getUserid());
        holder.id.setText(""+jsonModelList.get(position).getId());
        holder.title.setText(""+jsonModelList.get(position).getTitle());
        holder.body.setText(""+jsonModelList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return jsonModelList.size();
    }

    public class JsonHolder extends RecyclerView.ViewHolder {
        TextView userid,id,title,body;
        public JsonHolder(@NonNull View itemView) {
            super(itemView);
            userid=itemView.findViewById(R.id.UserID);
            id=itemView.findViewById(R.id.ID);
            title=itemView.findViewById(R.id.Title);
            body=itemView.findViewById(R.id.Body);
        }
    }
}
