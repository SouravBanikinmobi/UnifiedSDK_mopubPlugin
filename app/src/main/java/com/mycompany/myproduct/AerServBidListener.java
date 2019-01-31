package com.mycompany.myproduct;

import android.support.annotation.NonNull;

public interface AerServBidListener {
    void onBidRecieved(@NonNull Object mopubObject);
    void onBidFailed(@NonNull Object mopubObject, @NonNull Error error);
}
