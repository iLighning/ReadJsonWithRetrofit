package ilightning.readjsonwithretrofit.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import ilightning.readjsonwithretrofit.R;
import ilightning.readjsonwithretrofit.model.Flower;

///**
// * Created by Hoàng on 6/21/2016.
// */

public class AdapterFlower extends RecyclerView.Adapter<AdapterFlower.ViewHolder> {

    private List<Flower> flowers;

    public AdapterFlower(List<Flower> flowerList) {
        this.flowers = flowerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flower, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flower flower = flowers.get(position);
        holder.tvName.setText(flower.getName());
        holder.tvIntroduction.setText(flower.getInstructions());
        Picasso.with(holder.imgPhoto.getContext()).load("http://services.hanselandpetal.com/photos/" + flower.getPhoto()).into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return flowers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName;
        TextView tvIntroduction;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            tvName = (TextView) itemView.findViewById(R.id.txt_name);
            tvIntroduction = (TextView) itemView.findViewById(R.id.txt_introduction);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_flower);
        }
    }
}
