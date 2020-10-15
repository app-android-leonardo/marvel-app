package br.com.marveltest.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import br.com.marveltest.DetailComicsActivity;
import br.com.marveltest.R;
import br.com.marveltest.base.AndroidComponent;
import br.com.marveltest.model.Item;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> itemList;
    private LayoutInflater mInflater;
    private boolean isDetail;

    public ItemAdapter(Context context, List<Item> itemList, boolean isDetail) {
        this.mInflater = LayoutInflater.from(context);
        this.itemList = itemList;
        this.isDetail = isDetail;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Item item = itemList.get(position);
        Picasso.get().load(item.getUrlImage()).into(holder.image);
        holder.name.setText(item.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDetail){
                    Intent intent = new Intent(mInflater.getContext(), DetailComicsActivity.class);
                    intent.putExtra("url_detail", item.getUrlDetail());
                    intent.putExtra("id_character", item.getId());
                    Activity activity = (Activity) mInflater.getContext();
                    activity.startActivity(intent);
                } else {
                    String description = item.getDescription();
                    if (description != null){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            new AndroidComponent((Activity) mInflater.getContext()).alert(mInflater.getContext().getString(R.string.descricao),
                                    Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT).toString(), false);
                        } else {
                            new AndroidComponent((Activity) mInflater.getContext()).alert(mInflater.getContext().getString(R.string.descricao),
                                    Html.fromHtml(description).toString(), false);
                        }
                    } else {
                        new AndroidComponent((Activity) mInflater.getContext()).alert(mInflater.getContext().getString(R.string.atencao), mInflater.getContext().getString(R.string.not_description), false);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_textview);
            image = itemView.findViewById(R.id.image_imageview);
        }
    }
}