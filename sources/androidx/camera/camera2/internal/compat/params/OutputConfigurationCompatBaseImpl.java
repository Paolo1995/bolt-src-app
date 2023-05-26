package androidx.camera.camera2.internal.compat.params;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class OutputConfigurationCompatBaseImpl implements OutputConfigurationCompat.OutputConfigurationCompatImpl {

    /* renamed from: a  reason: collision with root package name */
    final Object f2840a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class OutputConfigurationParamsApi21 {

        /* renamed from: a  reason: collision with root package name */
        final List<Surface> f2841a;

        /* renamed from: b  reason: collision with root package name */
        final Size f2842b;

        /* renamed from: c  reason: collision with root package name */
        final int f2843c;

        /* renamed from: d  reason: collision with root package name */
        final int f2844d;

        /* renamed from: e  reason: collision with root package name */
        String f2845e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2846f = false;

        OutputConfigurationParamsApi21(@NonNull Surface surface) {
            Preconditions.h(surface, "Surface must not be null");
            this.f2841a = Collections.singletonList(surface);
            this.f2842b = c(surface);
            this.f2843c = a(surface);
            this.f2844d = b(surface);
        }

        @SuppressLint({"BlockedPrivateApi", "BanUncheckedReflection"})
        private static int a(@NonNull Surface surface) {
            try {
                Method declaredMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("detectSurfaceType", Surface.class);
                if (Build.VERSION.SDK_INT < 22) {
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) declaredMethod.invoke(null, surface)).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
                Logger.d("OutputConfigCompat", "Unable to retrieve surface format.", e8);
                return 0;
            }
        }

        @SuppressLint({"SoonBlockedPrivateApi", "BlockedPrivateApi", "BanUncheckedReflection"})
        private static int b(@NonNull Surface surface) {
            try {
                return ((Integer) Surface.class.getDeclaredMethod("getGenerationId", new Class[0]).invoke(surface, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
                Logger.d("OutputConfigCompat", "Unable to retrieve surface generation id.", e8);
                return -1;
            }
        }

        @SuppressLint({"BlockedPrivateApi", "BanUncheckedReflection"})
        private static Size c(@NonNull Surface surface) {
            try {
                Method declaredMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("getSurfaceSize", Surface.class);
                declaredMethod.setAccessible(true);
                return (Size) declaredMethod.invoke(null, surface);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
                Logger.d("OutputConfigCompat", "Unable to retrieve surface size.", e8);
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi21)) {
                return false;
            }
            OutputConfigurationParamsApi21 outputConfigurationParamsApi21 = (OutputConfigurationParamsApi21) obj;
            if (!this.f2842b.equals(outputConfigurationParamsApi21.f2842b) || this.f2843c != outputConfigurationParamsApi21.f2843c || this.f2844d != outputConfigurationParamsApi21.f2844d || this.f2846f != outputConfigurationParamsApi21.f2846f || !Objects.equals(this.f2845e, outputConfigurationParamsApi21.f2845e)) {
                return false;
            }
            int min = Math.min(this.f2841a.size(), outputConfigurationParamsApi21.f2841a.size());
            for (int i8 = 0; i8 < min; i8++) {
                if (this.f2841a.get(i8) != outputConfigurationParamsApi21.f2841a.get(i8)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f2841a.hashCode() ^ 31;
            int i8 = this.f2844d ^ ((hashCode2 << 5) - hashCode2);
            int hashCode3 = this.f2842b.hashCode() ^ ((i8 << 5) - i8);
            int i9 = this.f2843c ^ ((hashCode3 << 5) - hashCode3);
            int i10 = (this.f2846f ? 1 : 0) ^ ((i9 << 5) - i9);
            int i11 = (i10 << 5) - i10;
            String str = this.f2845e;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode ^ i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputConfigurationCompatBaseImpl(@NonNull Surface surface) {
        this.f2840a = new OutputConfigurationParamsApi21(surface);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void a(long j8) {
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void b(@NonNull Surface surface) {
        Preconditions.h(surface, "Surface must not be null");
        if (getSurface() != surface) {
            if (!g()) {
                throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
            }
            throw new IllegalArgumentException("Exceeds maximum number of surfaces");
        }
        throw new IllegalStateException("Surface is already added!");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void c(String str) {
        ((OutputConfigurationParamsApi21) this.f2840a).f2845e = str;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String d() {
        return ((OutputConfigurationParamsApi21) this.f2840a).f2845e;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void e() {
        ((OutputConfigurationParamsApi21) this.f2840a).f2846f = true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OutputConfigurationCompatBaseImpl)) {
            return false;
        }
        return Objects.equals(this.f2840a, ((OutputConfigurationCompatBaseImpl) obj).f2840a);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object f() {
        return null;
    }

    boolean g() {
        return ((OutputConfigurationParamsApi21) this.f2840a).f2846f;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Surface getSurface() {
        List<Surface> list = ((OutputConfigurationParamsApi21) this.f2840a).f2841a;
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public int hashCode() {
        return this.f2840a.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputConfigurationCompatBaseImpl(@NonNull Object obj) {
        this.f2840a = obj;
    }
}
