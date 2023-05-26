package eu.bolt.verification.sdk.internal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.view.PreviewView;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class j1 implements Factory<i1> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AppCompatActivity> f43620a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PreviewView> f43621b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<xg> f43622c;

    public j1(Provider<AppCompatActivity> provider, Provider<PreviewView> provider2, Provider<xg> provider3) {
        this.f43620a = provider;
        this.f43621b = provider2;
        this.f43622c = provider3;
    }

    public static i1 b(AppCompatActivity appCompatActivity, PreviewView previewView, xg xgVar) {
        return new i1(appCompatActivity, previewView, xgVar);
    }

    public static j1 c(Provider<AppCompatActivity> provider, Provider<PreviewView> provider2, Provider<xg> provider3) {
        return new j1(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public i1 get() {
        return b(this.f43620a.get(), this.f43621b.get(), this.f43622c.get());
    }
}
