package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final WeakReference zag;
    private final zacz zah;
    private ResultTransform zaa = null;
    private zada zab = null;
    private volatile ResultCallbacks zac = null;
    private PendingResult zad = null;
    private final Object zae = new Object();
    private Status zaf = null;
    private boolean zai = false;

    public zada(WeakReference weakReference) {
        Looper mainLooper;
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        if (googleApiClient != null) {
            mainLooper = googleApiClient.getLooper();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        this.zah = new zacz(this, mainLooper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zaj(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zal(status);
        }
    }

    @GuardedBy("mSyncToken")
    private final void zak() {
        if (this.zaa == null && this.zac == null) {
            return;
        }
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
        if (!this.zai && this.zaa != null && googleApiClient != null) {
            googleApiClient.zao(this);
            this.zai = true;
        }
        Status status = this.zaf;
        if (status != null) {
            zal(status);
            return;
        }
        PendingResult pendingResult = this.zad;
        if (pendingResult != null) {
            pendingResult.setResultCallback(this);
        }
    }

    private final void zal(Status status) {
        synchronized (this.zae) {
            ResultTransform resultTransform = this.zaa;
            if (resultTransform != null) {
                ((zada) Preconditions.checkNotNull(this.zab)).zaj((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
            } else if (zam()) {
                ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onFailure(status);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean zam() {
        GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
        if (this.zac != null && googleApiClient != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zan(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e8) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e8);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public final void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z7;
        synchronized (this.zae) {
            boolean z8 = true;
            if (this.zac == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkState(z7, "Cannot call andFinally() twice.");
            if (this.zaa != null) {
                z8 = false;
            }
            Preconditions.checkState(z8, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zac = resultCallbacks;
            zak();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        synchronized (this.zae) {
            if (result.getStatus().isSuccess()) {
                if (this.zaa != null) {
                    zaco.zaa().submit(new zacy(this, result));
                } else if (zam()) {
                    ((ResultCallbacks) Preconditions.checkNotNull(this.zac)).onSuccess(result);
                }
            } else {
                zaj(result.getStatus());
                zan(result);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        boolean z7;
        zada zadaVar;
        synchronized (this.zae) {
            boolean z8 = true;
            if (this.zaa == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkState(z7, "Cannot call then() twice.");
            if (this.zac != null) {
                z8 = false;
            }
            Preconditions.checkState(z8, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zaa = resultTransform;
            zadaVar = new zada(this.zag);
            this.zab = zadaVar;
            zak();
        }
        return zadaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zah() {
        this.zac = null;
    }

    public final void zai(PendingResult pendingResult) {
        synchronized (this.zae) {
            this.zad = pendingResult;
            zak();
        }
    }
}
