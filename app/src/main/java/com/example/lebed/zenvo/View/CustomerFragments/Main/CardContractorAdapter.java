package com.example.lebed.zenvo.View.CustomerFragments.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lebed.zenvo.R;

import java.util.List;

public class CardContractorAdapter extends RecyclerView.Adapter<CardContractorAdapter.CardContractorViewHolder> {

    private List<CardContractor> contractorList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class CardContractorViewHolder extends RecyclerView.ViewHolder {
        public TextView firstLastName, rating, reviewsNumber, location;
        public ImageView avatar;

        public CardContractorViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            firstLastName = itemView.findViewById(R.id.customer_contractor_card_name);
            rating = itemView.findViewById(R.id.customer_contractor_card_rating);
            reviewsNumber = itemView.findViewById(R.id.customer_contractor_card_reviews_number);
            location = itemView.findViewById(R.id.customer_contractor_card_location);
            avatar = itemView.findViewById(R.id.customer_contractor_card_image_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (listener!=null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION){
                                listener.onItemClick(position);
                            }
                        }
                }
            });

        }
    }


    public CardContractorAdapter(List<CardContractor> contractorList) {
        this.contractorList = contractorList;

    }

    @NonNull
    @Override
    public CardContractorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_card_contractor_profile, viewGroup, false);
        CardContractorViewHolder cardContractorViewHolder = new CardContractorViewHolder(view, listener);
        return cardContractorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardContractorViewHolder cardContractorViewHolder, int i) {

        CardContractor cardContractor = contractorList.get(i);
        cardContractorViewHolder.avatar.setImageDrawable(cardContractor.getAvatar());
        cardContractorViewHolder.firstLastName.setText(cardContractor.getName());
        cardContractorViewHolder.location.setText(cardContractor.getLocation());
        cardContractorViewHolder.rating.setText(cardContractor.getRating());
        cardContractorViewHolder.reviewsNumber.setText(cardContractor.getReviewsNumber());
    }

    @Override
    public int getItemCount() {
        return contractorList.size();
    }


}
