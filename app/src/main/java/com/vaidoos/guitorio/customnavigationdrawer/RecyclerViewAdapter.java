package com.vaidoos.guitorio.customnavigationdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Guitorio on 2/21/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolderCardItem> {

    private Context context;

    private List<CardDetail> cardDetailList;

    private int previousPosition = 0;

    public RecyclerViewAdapter(Context context, List<CardDetail> cardDetails) {
        this.context = context;
        this.cardDetailList = cardDetails;
    }

    @Override
    public MyViewHolderCardItem onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.card_items, parent, false);

        return new MyViewHolderCardItem(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolderCardItem holder, int position) {

        CardDetail cardDetail = cardDetailList.get(position);

        holder.tvRemainingBalanceDigit.setText(cardDetail.getTvRemainingBalanceDigit());
        holder.cardNumerFirstFourDig.setText(cardDetail.getCardNumerFirstFourDig());
        holder.cardNumerLastFourDig.setText(cardDetail.getCardNumerLastFourDig());
        holder.validationDate.setText(cardDetail.getValidationDate());


        if (position > previousPosition) { // We are scrolling DOWN

            AnimationUtil.animate(holder, true);

        } else { // We are scrolling UP

            AnimationUtil.animate(holder, false);


        }

        previousPosition = position;


        /*final int currentPosition = position;
        final Information infoData = data.get(position);*/


    }

    @Override
    public int getItemCount() {
        return cardDetailList.size();
    }

    public class MyViewHolderCardItem extends RecyclerView.ViewHolder {

        private TextView tvRemainingBalanceDigit, cardNumerFirstFourDig, cardNumerLastFourDig, validationDate;

        public MyViewHolderCardItem(View itemView) {
            super(itemView);

            tvRemainingBalanceDigit = itemView.findViewById(R.id.tvRemainingBalanceDigit);
            cardNumerFirstFourDig = itemView.findViewById(R.id.cardNumerFirstFourDig);
            cardNumerLastFourDig = itemView.findViewById(R.id.cardNumerLastFourDig);
            validationDate = itemView.findViewById(R.id.validationDate);

        }
    }
}
