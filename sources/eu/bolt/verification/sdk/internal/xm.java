package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.wm;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.camera.VerificationCameraBuilder.VerificationCameraScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class xm implements Factory<AppCompatActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f45672a;

    public xm(Provider<Activity> provider) {
        this.f45672a = provider;
    }

    public static AppCompatActivity b(Activity activity) {
        return (AppCompatActivity) Preconditions.checkNotNullFromProvides(wm.c.a(activity));
    }

    public static xm c(Provider<Activity> provider) {
        return new xm(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public AppCompatActivity get() {
        return b(this.f45672a.get());
    }
}
