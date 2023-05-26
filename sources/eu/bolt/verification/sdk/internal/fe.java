package eu.bolt.verification.sdk.internal;

import androidx.annotation.NonNull;
import okhttp3.MultipartBody;

/* loaded from: classes5.dex */
public final class fe {
    @NonNull
    public MultipartBody.Part a(@NonNull String str, @NonNull String str2) {
        return MultipartBody.Part.createFormData(str, str2);
    }
}
