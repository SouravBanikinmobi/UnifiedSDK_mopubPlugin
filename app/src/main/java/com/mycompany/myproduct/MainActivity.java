package com.mycompany.myproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubRewardedVideos;
import com.mopub.mobileads.MoPubView;

public class MainActivity extends AppCompatActivity implements MoPubInterstitial.InterstitialAdListener,MoPubView.BannerAdListener {

    private static final String TAG = "Interstitial";
    MoPubInterstitial mInterstitial;
    private MoPubView moPubView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SdkConfiguration sdkConfiguration= new  SdkConfiguration.Builder("62aca475f552400cb6dda9e00d9d994d").build();

        MoPub.initializeSdk(this, sdkConfiguration, initSdkListener());

    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {

            @Override
            public void onInitializationFinished() {
                Log.d(TAG, "MopubInitializationFinished:");

            }
        };
    }


    public void loadBanner(View v){

        moPubView = (MoPubView) findViewById(R.id.adview);
        moPubView.setAdUnitId("e30ac25d41854a7693894cdb9c8ae35a"); // Enter your Ad Unit ID from www.mopub.com
        moPubView.loadAd();

    }


    public void loadinterstitial(View v){

        mInterstitial = new MoPubInterstitial(this, "8c671e91bb144048955e783a2e178650");
        mInterstitial.setInterstitialAdListener(this);
        mInterstitial.load();

    }

    public void loadrewarded(View v){



    }

    @Override
    public void onInterstitialLoaded(MoPubInterstitial interstitial) {
        // The interstitial has been cached and is ready to be shown.
        mInterstitial.show();
    }

    @Override
    public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {
        // The interstitial has failed to load. Inspect errorCode for additional information.
        Log.d(TAG, "onInterstitialFailed:"+errorCode);
    }

    @Override
    public void onInterstitialShown(MoPubInterstitial interstitial) {
        // The interstitial has been shown. Pause / save state accordingly.

    }

    @Override
    public void onInterstitialClicked(MoPubInterstitial interstitial) {}

    @Override
    public void onInterstitialDismissed(MoPubInterstitial interstitial) {
        // The interstitial has being dismissed. Resume / load state accordingly.
    }

    @Override
    protected void onPause() {
        super.onPause();
        MoPub.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        MoPub.onStop(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MoPub.onResume(this);
    }

    @Override
    protected void onDestroy() {
        mInterstitial.destroy();
        super.onDestroy();
    }

    public void onBannerLoaded(MoPubView banner){


    }

    // Sent when the banner has failed to retrieve an ad. You can use the MoPubErrorCode value to diagnose the cause of failure.
    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode){


    }

    // Sent when the user has tapped on the banner.
    public void onBannerClicked(MoPubView banner){


    }

    // Sent when the banner has just taken over the screen.
    public void onBannerExpanded(MoPubView banner){


    }

    // Sent when an expanded banner has collapsed back to its original size.
    public void onBannerCollapsed(MoPubView banner){


    }
}
