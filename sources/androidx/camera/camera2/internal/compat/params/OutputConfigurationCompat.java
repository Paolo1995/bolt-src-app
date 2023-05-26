package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class OutputConfigurationCompat {

    /* renamed from: a  reason: collision with root package name */
    private final OutputConfigurationCompatImpl f2834a;

    /* loaded from: classes.dex */
    interface OutputConfigurationCompatImpl {
        void a(long j8);

        void b(@NonNull Surface surface);

        void c(String str);

        String d();

        void e();

        Object f();

        Surface getSurface();
    }

    public OutputConfigurationCompat(int i8, @NonNull Surface surface) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 33) {
            this.f2834a = new OutputConfigurationCompatApi33Impl(i8, surface);
        } else if (i9 >= 28) {
            this.f2834a = new OutputConfigurationCompatApi28Impl(i8, surface);
        } else if (i9 >= 26) {
            this.f2834a = new OutputConfigurationCompatApi26Impl(i8, surface);
        } else if (i9 >= 24) {
            this.f2834a = new OutputConfigurationCompatApi24Impl(i8, surface);
        } else {
            this.f2834a = new OutputConfigurationCompatBaseImpl(surface);
        }
    }

    public static OutputConfigurationCompat h(Object obj) {
        OutputConfigurationCompatImpl outputConfigurationCompatImpl;
        if (obj == null) {
            return null;
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 33) {
            outputConfigurationCompatImpl = OutputConfigurationCompatApi33Impl.k((OutputConfiguration) obj);
        } else if (i8 >= 28) {
            outputConfigurationCompatImpl = OutputConfigurationCompatApi28Impl.j((OutputConfiguration) obj);
        } else if (i8 >= 26) {
            outputConfigurationCompatImpl = OutputConfigurationCompatApi26Impl.i((OutputConfiguration) obj);
        } else if (i8 >= 24) {
            outputConfigurationCompatImpl = OutputConfigurationCompatApi24Impl.h((OutputConfiguration) obj);
        } else {
            outputConfigurationCompatImpl = null;
        }
        if (outputConfigurationCompatImpl == null) {
            return null;
        }
        return new OutputConfigurationCompat(outputConfigurationCompatImpl);
    }

    public void a(@NonNull Surface surface) {
        this.f2834a.b(surface);
    }

    public void b() {
        this.f2834a.e();
    }

    public String c() {
        return this.f2834a.d();
    }

    public Surface d() {
        return this.f2834a.getSurface();
    }

    public void e(String str) {
        this.f2834a.c(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OutputConfigurationCompat)) {
            return false;
        }
        return this.f2834a.equals(((OutputConfigurationCompat) obj).f2834a);
    }

    public void f(long j8) {
        this.f2834a.a(j8);
    }

    public Object g() {
        return this.f2834a.f();
    }

    public int hashCode() {
        return this.f2834a.hashCode();
    }

    private OutputConfigurationCompat(@NonNull OutputConfigurationCompatImpl outputConfigurationCompatImpl) {
        this.f2834a = outputConfigurationCompatImpl;
    }
}
