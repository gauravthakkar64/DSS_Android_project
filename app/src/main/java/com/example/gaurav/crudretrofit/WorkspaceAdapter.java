package com.example.gaurav.crudretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaurav.crudretrofit.model.Workspace;

import java.util.List;

public class WorkspaceAdapter  extends RecyclerView.Adapter<WorkspaceAdapter.WorkspaceViewHolder>{

    private Context mContext ;
    private List<Workspace> workspaceList;

    public WorkspaceAdapter(Context mContext, List<Workspace> workspaceList) {
        this.mContext = mContext;
        this.workspaceList = workspaceList;
    }

    @NonNull
    @Override
    public WorkspaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.list_layout,parent,false);
        return new WorkspaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkspaceViewHolder holder, int position) {


        Workspace workspace=workspaceList.get(position);
        holder.tvTitle.setText(workspace.getName());
        holder.tvDesc.setText(workspace.getDescription());
        holder.tvPrice.setText(String.valueOf(workspace.getPrice()));

        holder.imageView.setImageResource(workspaceList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return workspaceList.size();
    }

    class WorkspaceViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvTitle,tvDesc,tvPrice;
        public WorkspaceViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img_recycle_View);
            tvTitle=itemView.findViewById(R.id.tv_title_recycle_view);
            tvDesc=itemView.findViewById(R.id.tv_short_desc_recycleview);
            tvPrice=itemView.findViewById(R.id.tv_price_recycleview);
        }
    }
}
