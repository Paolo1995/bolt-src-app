package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface LottieFetchResult extends Closeable {
    String P();

    @NonNull
    InputStream T() throws IOException;

    String i();

    boolean isSuccessful();
}
