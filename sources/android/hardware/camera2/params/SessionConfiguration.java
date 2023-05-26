package android.hardware.camera2.params;

import android.annotation.NonNull;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Parcelable;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class SessionConfiguration implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ SessionConfiguration(int i8, @NonNull List<OutputConfiguration> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
    }

    public native /* synthetic */ Executor getExecutor();

    public native /* synthetic */ InputConfiguration getInputConfiguration();

    public native /* synthetic */ List<OutputConfiguration> getOutputConfigurations();

    public native /* synthetic */ int getSessionType();

    public native /* synthetic */ CameraCaptureSession.StateCallback getStateCallback();

    public native /* synthetic */ int hashCode();

    public native /* synthetic */ void setInputConfiguration(@NonNull InputConfiguration inputConfiguration);

    public native /* synthetic */ void setSessionParameters(CaptureRequest captureRequest);
}
