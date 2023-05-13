package com.example.recyclerviewnew;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private Context context;

    private  ContactAdapterListener listener;

    private List<EPLTeamModel> contactList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, league;

        public ImageView badge, stadium;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tvname);

            badge = view.findViewById(R.id.ivBadge);
            stadium = view.findViewById(R.id.ivStadium);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onContactSelected(contactList.get(getAdapterPosition()));
                }
            });

        }
    }

    public ContactAdapter(Context context, List<EPLTeamModel> contactList, ContactAdapterListener listener) {
        this.context = context;
        this.contactList = contactList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.MyViewHolder holder, int position) {
        final EPLTeamModel contactModel = this.contactList.get(position);
        holder.name.setText(contactModel.getJudul());
        Glide.with(holder.itemView.getContext()).load(contactModel.getBadges()).into(holder.badge);


    }

    @Override
    public int getItemCount() {
        return this.contactList.size();
    }

    public interface ContactAdapterListener{
        void onContactSelected(EPLTeamModel contact);
    }
}