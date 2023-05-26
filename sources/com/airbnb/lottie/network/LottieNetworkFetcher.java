package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes.dex */
public interface LottieNetworkFetcher {
    @NonNull
    LottieFetchResult a(@NonNull String str) throws IOException;
}
