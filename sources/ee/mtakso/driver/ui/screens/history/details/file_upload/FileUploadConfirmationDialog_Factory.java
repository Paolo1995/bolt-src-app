package ee.mtakso.driver.ui.screens.history.details.file_upload;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class FileUploadConfirmationDialog_Factory implements Factory<FileUploadConfirmationDialog> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29547a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AudioRecordingMapper> f29548b;

    public FileUploadConfirmationDialog_Factory(Provider<BaseUiDependencies> provider, Provider<AudioRecordingMapper> provider2) {
        this.f29547a = provider;
        this.f29548b = provider2;
    }

    public static FileUploadConfirmationDialog_Factory a(Provider<BaseUiDependencies> provider, Provider<AudioRecordingMapper> provider2) {
        return new FileUploadConfirmationDialog_Factory(provider, provider2);
    }

    public static FileUploadConfirmationDialog c(BaseUiDependencies baseUiDependencies, AudioRecordingMapper audioRecordingMapper) {
        return new FileUploadConfirmationDialog(baseUiDependencies, audioRecordingMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FileUploadConfirmationDialog get() {
        return c(this.f29547a.get(), this.f29548b.get());
    }
}
