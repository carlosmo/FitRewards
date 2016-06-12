package com.example.carlosmo.fitrewards;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Carlos Mo on 20/11/2015.
 */
public class CustomRewardsAdapter extends ArrayAdapter<Reward> {
    Context context;
    List<Reward> rewardsList;
    int layoutResID;

    public CustomRewardsAdapter(Context context, int layoutResourceID, List<Reward> rewardsList) {
        super(context, layoutResourceID, rewardsList);
        this.context = context;
        this.rewardsList = rewardsList;
        this.layoutResID = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        RewardItemHolder rewardItemHolder;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            view = inflater.inflate(layoutResID, parent, false);

            rewardItemHolder = new RewardItemHolder();
            rewardItemHolder.imgURL = (ImageView) view.findViewById(R.id.imgURL);
            rewardItemHolder.redemptionTarget = (TextView) view.findViewById(R.id.redemptionTarget);
            rewardItemHolder.company = (TextView) view.findViewById(R.id.company);
            rewardItemHolder.description = (TextView) view.findViewById(R.id.description);


            view.setTag(rewardItemHolder);
        } else {
            rewardItemHolder = (RewardItemHolder) view.getTag();
        }

        // Set reward company
        rewardItemHolder.company.setText(rewardsList.get(position).getCompany());
        // Set reward description
        rewardItemHolder.description.setText(rewardsList.get(position).getDescription());
        // Set reward redemption target
        rewardItemHolder.redemptionTarget.setText(rewardsList.get(position).getRedemptionTarget());
        // Set reward image
        new DownloadImageTask(rewardItemHolder.imgURL).execute(rewardsList.get(position).getImgURL());


        return view;
    }

    // Container for the dictionary row
    private static class RewardItemHolder {
        ImageView imgURL;
        TextView company, description, redemptionTarget;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}

