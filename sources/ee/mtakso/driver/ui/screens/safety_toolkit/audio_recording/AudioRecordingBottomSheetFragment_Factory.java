package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseMvvmBottomSheetDialogFragment_MembersInjector;
import ee.mtakso.driver.ui.base.mvvm.ViewModelFactory;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AudioRecordingBottomSheetFragment_Factory implements Factory<AudioRecordingBottomSheetFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HtmlEngine> f32550a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenAnalytics> f32551b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ViewModelFactory> f32552c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PermissionManager> f32553d;

    public AudioRecordingBottomSheetFragment_Factory(Provider<HtmlEngine> provider, Provider<ScreenAnalytics> provider2, Provider<ViewModelFactory> provider3, Provider<PermissionManager> provider4) {
        this.f32550a = provider;
        this.f32551b = provider2;
        this.f32552c = provider3;
        this.f32553d = provider4;
    }

    public static AudioRecordingBottomSheetFragment_Factory a(Provider<HtmlEngine> provider, Provider<ScreenAnalytics> provider2, Provider<ViewModelFactory> provider3, Provider<PermissionManager> provider4) {
        return new AudioRecordingBottomSheetFragment_Factory(provider, provider2, provider3, provider4);
    }

    public static AudioRecordingBottomSheetFragment c(HtmlEngine htmlEngine) {
        return new AudioRecordingBottomSheetFragment(htmlEngine);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AudioRecordingBottomSheetFragment get() {
        AudioRecordingBottomSheetFragment c8 = c(this.f32550a.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.b(c8, this.f32551b.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.c(c8, this.f32552c.get());
        BaseMvvmBottomSheetDialogFragment_MembersInjector.a(c8, this.f32553d.get());
        return c8;
    }
}
