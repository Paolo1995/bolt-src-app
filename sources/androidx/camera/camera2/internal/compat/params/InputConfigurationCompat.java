package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: classes.dex */
public final class InputConfigurationCompat {

    /* renamed from: a  reason: collision with root package name */
    private final InputConfigurationCompatImpl f2832a;

    /* loaded from: classes.dex */
    private static class InputConfigurationCompatApi23Impl implements InputConfigurationCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final InputConfiguration f2833a;

        InputConfigurationCompatApi23Impl(@NonNull Object obj) {
            this.f2833a = (InputConfiguration) obj;
        }

        @Override // androidx.camera.camera2.internal.compat.params.InputConfigurationCompat.InputConfigurationCompatImpl
        public Object a() {
            return this.f2833a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof InputConfigurationCompatImpl)) {
                return false;
            }
            return Objects.equals(this.f2833a, ((InputConfigurationCompatImpl) obj).a());
        }

        public int hashCode() {
            return this.f2833a.hashCode();
        }

        @NonNull
        public String toString() {
            return this.f2833a.toString();
        }
    }

    /* loaded from: classes.dex */
    private static final class InputConfigurationCompatApi31Impl extends InputConfigurationCompatApi23Impl {
        InputConfigurationCompatApi31Impl(@NonNull Object obj) {
            super(obj);
        }
    }

    /* loaded from: classes.dex */
    private interface InputConfigurationCompatImpl {
        Object a();
    }

    private InputConfigurationCompat(@NonNull InputConfigurationCompatImpl inputConfigurationCompatImpl) {
        this.f2832a = inputConfigurationCompatImpl;
    }

    public static InputConfigurationCompat b(Object obj) {
        int i8;
        if (obj == null || (i8 = Build.VERSION.SDK_INT) < 23) {
            return null;
        }
        if (i8 >= 31) {
            return new InputConfigurationCompat(new InputConfigurationCompatApi31Impl(obj));
        }
        return new InputConfigurationCompat(new InputConfigurationCompatApi23Impl(obj));
    }

    public Object a() {
        return this.f2832a.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InputConfigurationCompat)) {
            return false;
        }
        return this.f2832a.equals(((InputConfigurationCompat) obj).f2832a);
    }

    public int hashCode() {
        return this.f2832a.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f2832a.toString();
    }
}
