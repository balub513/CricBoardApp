package com.example.balakrishnaballi.cricboardapp.mvvm.view_;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.balakrishnaballi.cricboardapp.R;
import com.example.balakrishnaballi.cricboardapp.constants.Consts;
import com.example.balakrishnaballi.cricboardapp.mvvm.model_.PlayerBio;
import com.example.balakrishnaballi.cricboardapp.mvvm.viewmodel_.PlayBioViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerBioActivity extends AppCompatActivity {

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_country)
    TextView tvCountry;

    @BindView(R.id.tv_odis)
    TextView tvODIS;

    @BindView(R.id.tv_odi_runs)
    TextView tvODIRuns;

    @BindView(R.id.tv_tests)
    TextView tvTests;

    @BindView(R.id.tv_test_runs)
    TextView tvTestRuns;

    @BindView(R.id.tv_odi_wickets)
    TextView tvODIWickets;

    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    @BindView(R.id.tv_test_wickets)
    TextView tvTestWickets;
    private int playerID;
    private ProgressDialog progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_bio);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            playerID = bundle.getInt(Consts.Network.PLAYER_ID);
        }

        PlayBioViewModel playBioViewModel = ViewModelProviders.of(this).get(PlayBioViewModel.class);

        startLoading();
        playBioViewModel.requestBio(playerID);

        playBioViewModel.getPlayerBioLiveData().observe(this, new PlayerBioObserver());
    }

    class PlayerBioObserver implements Observer<PlayerBio> {

        @Override
        public void onChanged(@Nullable PlayerBio bio) {
            tvName.setText(bio.getFullName());
            tvCountry.setText(bio.getCountry());
            if (bio.getData() != null && bio.getData().getBatting() != null) {
                tvODIS.setText(bio.getData().getBatting().getODIs().getMat() + "");
                tvTests.setText(bio.getData().getBatting().getTests().getMat() + "");
                tvODIRuns.setText(bio.getData().getBatting().getODIs().getRuns() + "");
                tvTestRuns.setText(bio.getData().getBatting().getTests().getRuns() + "");
            }
            if (bio.getData() != null && bio.getData().getBowling() != null) {
                tvODIWickets.setText(bio.getData().getBowling().getODIs().getWkts());
                tvTestWickets.setText(bio.getData().getBowling().getTests().getWkts());
            }


            loadIcon(ivProfile, bio.getImageURL() + "");

            dismissLoading();
        }
    }

    private void loadIcon(final ImageView ivProfile, String imageURL) {
        @SuppressLint("StaticFieldLeak") AsyncTask<String, Void, Bitmap> asyncTask =
                new AsyncTask<String, Void, Bitmap>() {

                    @Override
                    protected Bitmap doInBackground(String... imageUrls) {
                        try {
                            URL url = new URL(imageUrls[0]);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setDoInput(true);
                            connection.connect();
                            InputStream input = connection.getInputStream();
                            Bitmap myBitmap = BitmapFactory.decodeStream(input);
                            return myBitmap;
                        } catch (IOException e) {
                            // Log exception
                            return null;
                        }
                    }

                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        super.onPostExecute(bitmap);
                        ivProfile.setImageBitmap(bitmap);

                    }
                };
        asyncTask.execute(imageURL);
    }


    public void startLoading() {
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("loading..");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
    }

    public void dismissLoading() {
        progressBar.dismiss();
    }
}
