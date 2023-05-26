package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzik;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.0 */
/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: b  reason: collision with root package name */
    private static volatile FirebaseAnalytics f15415b;

    /* renamed from: a  reason: collision with root package name */
    private final zzee f15416a;

    public FirebaseAnalytics(zzee zzeeVar) {
        Preconditions.checkNotNull(zzeeVar);
        this.f15416a = zzeeVar;
    }

    @NonNull
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f15415b == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f15415b == null) {
                    f15415b = new FirebaseAnalytics(zzee.zzg(context, null, null, null, null));
                }
            }
        }
        return f15415b;
    }

    @Keep
    public static zzik getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzee zzg = zzee.zzg(context, null, null, null, bundle);
        if (zzg == null) {
            return null;
        }
        return new zzc(zzg);
    }

    public void a(@NonNull String str, Bundle bundle) {
        this.f15416a.zzx(str, bundle);
    }

    public void b(String str) {
        this.f15416a.zzM(str);
    }

    public void c(@NonNull String str, String str2) {
        this.f15416a.zzN(null, str, str2, false);
    }

    @NonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(FirebaseInstallations.n().getId(), DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e8) {
            throw new IllegalStateException(e8);
        } catch (ExecutionException e9) {
            throw new IllegalStateException(e9.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(@NonNull Activity activity, String str, String str2) {
        this.f15416a.zzG(activity, str, str2);
    }
}
