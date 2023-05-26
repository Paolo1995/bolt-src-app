package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class OutputConfigurationCompatApi26Impl extends OutputConfigurationCompatApi24Impl {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class OutputConfigurationParamsApi26 {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final OutputConfiguration f2838a;

        /* renamed from: b  reason: collision with root package name */
        String f2839b;

        OutputConfigurationParamsApi26(@NonNull OutputConfiguration outputConfiguration) {
            this.f2838a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi26)) {
                return false;
            }
            OutputConfigurationParamsApi26 outputConfigurationParamsApi26 = (OutputConfigurationParamsApi26) obj;
            if (!Objects.equals(this.f2838a, outputConfigurationParamsApi26.f2838a) || !Objects.equals(this.f2839b, outputConfigurationParamsApi26.f2839b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f2838a.hashCode() ^ 31;
            int i8 = (hashCode2 << 5) - hashCode2;
            String str = this.f2839b;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode ^ i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputConfigurationCompatApi26Impl(int i8, @NonNull Surface surface) {
        this(new OutputConfigurationParamsApi26(new OutputConfiguration(i8, surface)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputConfigurationCompatApi26Impl i(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi26Impl(new OutputConfigurationParamsApi26(outputConfiguration));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void b(@NonNull Surface surface) {
        ((OutputConfiguration) f()).addSurface(surface);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void c(String str) {
        ((OutputConfigurationParamsApi26) this.f2840a).f2839b = str;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String d() {
        return ((OutputConfigurationParamsApi26) this.f2840a).f2839b;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void e() {
        ((OutputConfiguration) f()).enableSurfaceSharing();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @NonNull
    public Object f() {
        Preconditions.a(this.f2840a instanceof OutputConfigurationParamsApi26);
        return ((OutputConfigurationParamsApi26) this.f2840a).f2838a;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    final boolean g() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputConfigurationCompatApi26Impl(@NonNull Object obj) {
        super(obj);
    }
}
