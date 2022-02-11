package com.nm.nmitchellc196.Control;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nm.nmitchellc196.Entity.Course;
import com.nm.nmitchellc196.Entity.Term;
import com.nm.nmitchellc196.R;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    private final LayoutInflater mInflater;
    private final Context context;
    private List<Term> mTerm;

    class TermViewHolder extends RecyclerView.ViewHolder {
        private final TextView termItemView;

        private TermViewHolder(View itemView) {
            super(itemView);

            termItemView = itemView.findViewById(R.id.termTextView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Term current = mTerm.get(position);
                    Intent intent = new Intent(context, TermDetail.class);
                    intent.putExtra("id", current.getTermID());
                    intent.putExtra("termName", current.getTermName());
                    intent.putExtra("startDate", current.getStartDate());
                    intent.putExtra("endDate", current.getEndDate());
                    intent.putExtra("case", "view");
                    context.startActivity(intent);
                }

            });
        }
    }



    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public TermViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
       return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTerm != null) {
            final Term current = mTerm.get(position);
            holder.termItemView.setText(current.getTermName());
        } else {
            holder.termItemView.setText("No Results");
        }
    }

    @Override
    public int getItemCount() {
        if(mTerm != null) {
            return mTerm.size();
        } else {
            return 0;
        }
    }

    public void setTerms(List<Term> words) {
        mTerm = words;
        notifyDataSetChanged();
    }
}
