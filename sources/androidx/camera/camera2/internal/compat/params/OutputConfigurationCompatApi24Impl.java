package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class OutputConfigurationParamsApi24 {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final OutputConfiguration f2835a;

        /* renamed from: b  reason: collision with root package name */
        String f2836b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2837c;

        OutputConfigurationParamsApi24(@NonNull OutputConfiguration outputConfiguration) {
            this.f2835a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi24)) {
                return false;
            }
            OutputConfigurationParamsApi24 outputConfigurationParamsApi24 = (OutputConfigurationParamsApi24) obj;
            if (!Objects.equals(this.f2835a, outputConfigurationParamsApi24.f2835a) || this.f2837c != outputConfigurationParamsApi24.f2837c || !Objects.equals(this.f2836b, outputConfigurationParamsApi24.f2836b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f2835a.hashCode() ^ 31;
            int i8 = (this.f2837c ? 1 : 0) ^ ((hashCode2 << 5) - hashCode2);
            int i9 = (i8 << 5) - i8;
            String str = this.f2836b;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode ^ i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputConfigurationCompatApi24Impl(int i8, @NonNull Surface surface) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(i8, surface)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputConfigurationCompatApi24Impl h(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi24Impl(new OutputConfigurationParamsApi24(outputConfiguration));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void c(String str) {
        ((OutputConfigurationParamsApi24) this.f2840a).f2836b = str;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String d() {
        return ((OutputConfigurationParamsApi24) this.f2840a).f2836b;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void e() {
        ((OutputConfigurationParamsApi24) this.f2840a).f2837c = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @NonNull
    public Object f() {
        Preconditions.a(this.f2840a instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) this.f2840a).f2835a;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    boolean g() {
        return ((OutputConfigurationParamsApi24) this.f2840a).f2837c;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Surface getSurface() {
        return ((OutputConfiguration) f()).getSurface();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputConfigurationCompatApi24Impl(@NonNull Object obj) {
        super(obj);
    }
}
