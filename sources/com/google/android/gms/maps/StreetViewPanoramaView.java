package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public class StreetViewPanoramaView extends FrameLayout {
    private final zzas zza;

    public StreetViewPanoramaView(@NonNull Context context) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"));
        this.zza = new zzas(this, context, null);
    }

    public void getStreetViewPanoramaAsync(@NonNull OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        Preconditions.checkNotNull(onStreetViewPanoramaReadyCallback, "callback must not be null");
        Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zza.zza(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.zza.onCreate(bundle);
            if (this.zza.getDelegate() == null) {
                DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onDestroy() {
        this.zza.onDestroy();
    }

    public final void onLowMemory() {
        this.zza.onLowMemory();
    }

    public final void onPause() {
        this.zza.onPause();
    }

    public void onResume() {
        this.zza.onResume();
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        this.zza.onSaveInstanceState(bundle);
    }

    public void onStart() {
        this.zza.onStart();
    }

    public void onStop() {
        this.zza.onStop();
    }

    public StreetViewPanoramaView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"), attributeSet);
        this.zza = new zzas(this, context, null);
    }

    public StreetViewPanoramaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i8) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"), attributeSet, i8);
        this.zza = new zzas(this, context, null);
    }

    public StreetViewPanoramaView(@NonNull Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"));
        this.zza = new zzas(this, context, streetViewPanoramaOptions);
    }
}
