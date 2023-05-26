package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class SessionConfigurationCompat {

    /* renamed from: a  reason: collision with root package name */
    private final SessionConfigurationCompatImpl f2847a;

    /* loaded from: classes.dex */
    private static final class SessionConfigurationCompatBaseImpl implements SessionConfigurationCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final List<OutputConfigurationCompat> f2850a;

        /* renamed from: b  reason: collision with root package name */
        private final CameraCaptureSession.StateCallback f2851b;

        /* renamed from: c  reason: collision with root package name */
        private final Executor f2852c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2853d;

        /* renamed from: e  reason: collision with root package name */
        private InputConfigurationCompat f2854e = null;

        /* renamed from: f  reason: collision with root package name */
        private CaptureRequest f2855f = null;

        SessionConfigurationCompatBaseImpl(int i8, @NonNull List<OutputConfigurationCompat> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.f2853d = i8;
            this.f2850a = Collections.unmodifiableList(new ArrayList(list));
            this.f2851b = stateCallback;
            this.f2852c = executor;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public InputConfigurationCompat a() {
            return this.f2854e;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public CameraCaptureSession.StateCallback b() {
            return this.f2851b;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void c(@NonNull InputConfigurationCompat inputConfigurationCompat) {
            if (this.f2853d != 1) {
                this.f2854e = inputConfigurationCompat;
                return;
            }
            throw new UnsupportedOperationException("Method not supported for high speed session types");
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public List<OutputConfigurationCompat> d() {
            return this.f2850a;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Object e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SessionConfigurationCompatBaseImpl) {
                SessionConfigurationCompatBaseImpl sessionConfigurationCompatBaseImpl = (SessionConfigurationCompatBaseImpl) obj;
                if (Objects.equals(this.f2854e, sessionConfigurationCompatBaseImpl.f2854e) && this.f2853d == sessionConfigurationCompatBaseImpl.f2853d && this.f2850a.size() == sessionConfigurationCompatBaseImpl.f2850a.size()) {
                    for (int i8 = 0; i8 < this.f2850a.size(); i8++) {
                        if (!this.f2850a.get(i8).equals(sessionConfigurationCompatBaseImpl.f2850a.get(i8))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int f() {
            return this.f2853d;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void g(@NonNull CaptureRequest captureRequest) {
            this.f2855f = captureRequest;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public Executor getExecutor() {
            return this.f2852c;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f2850a.hashCode() ^ 31;
            int i8 = (hashCode2 << 5) - hashCode2;
            InputConfigurationCompat inputConfigurationCompat = this.f2854e;
            if (inputConfigurationCompat == null) {
                hashCode = 0;
            } else {
                hashCode = inputConfigurationCompat.hashCode();
            }
            int i9 = hashCode ^ i8;
            return this.f2853d ^ ((i9 << 5) - i9);
        }
    }

    /* loaded from: classes.dex */
    private interface SessionConfigurationCompatImpl {
        InputConfigurationCompat a();

        @NonNull
        CameraCaptureSession.StateCallback b();

        void c(@NonNull InputConfigurationCompat inputConfigurationCompat);

        @NonNull
        List<OutputConfigurationCompat> d();

        Object e();

        int f();

        void g(@NonNull CaptureRequest captureRequest);

        @NonNull
        Executor getExecutor();
    }

    public SessionConfigurationCompat(int i8, @NonNull List<OutputConfigurationCompat> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
        if (Build.VERSION.SDK_INT < 28) {
            this.f2847a = new SessionConfigurationCompatBaseImpl(i8, list, executor, stateCallback);
        } else {
            this.f2847a = new SessionConfigurationCompatApi28Impl(i8, list, executor, stateCallback);
        }
    }

    @NonNull
    public static List<OutputConfiguration> h(@NonNull List<OutputConfigurationCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (OutputConfigurationCompat outputConfigurationCompat : list) {
            arrayList.add((OutputConfiguration) outputConfigurationCompat.g());
        }
        return arrayList;
    }

    static List<OutputConfigurationCompat> i(@NonNull List<OutputConfiguration> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (OutputConfiguration outputConfiguration : list) {
            arrayList.add(OutputConfigurationCompat.h(outputConfiguration));
        }
        return arrayList;
    }

    @NonNull
    public Executor a() {
        return this.f2847a.getExecutor();
    }

    public InputConfigurationCompat b() {
        return this.f2847a.a();
    }

    @NonNull
    public List<OutputConfigurationCompat> c() {
        return this.f2847a.d();
    }

    public int d() {
        return this.f2847a.f();
    }

    @NonNull
    public CameraCaptureSession.StateCallback e() {
        return this.f2847a.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionConfigurationCompat)) {
            return false;
        }
        return this.f2847a.equals(((SessionConfigurationCompat) obj).f2847a);
    }

    public void f(@NonNull InputConfigurationCompat inputConfigurationCompat) {
        this.f2847a.c(inputConfigurationCompat);
    }

    public void g(@NonNull CaptureRequest captureRequest) {
        this.f2847a.g(captureRequest);
    }

    public int hashCode() {
        return this.f2847a.hashCode();
    }

    public Object j() {
        return this.f2847a.e();
    }

    /* loaded from: classes.dex */
    private static final class SessionConfigurationCompatApi28Impl implements SessionConfigurationCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final SessionConfiguration f2848a;

        /* renamed from: b  reason: collision with root package name */
        private final List<OutputConfigurationCompat> f2849b;

        SessionConfigurationCompatApi28Impl(@NonNull Object obj) {
            SessionConfiguration sessionConfiguration = (SessionConfiguration) obj;
            this.f2848a = sessionConfiguration;
            this.f2849b = Collections.unmodifiableList(SessionConfigurationCompat.i(sessionConfiguration.getOutputConfigurations()));
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public InputConfigurationCompat a() {
            return InputConfigurationCompat.b(this.f2848a.getInputConfiguration());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public CameraCaptureSession.StateCallback b() {
            return this.f2848a.getStateCallback();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void c(@NonNull InputConfigurationCompat inputConfigurationCompat) {
            this.f2848a.setInputConfiguration((InputConfiguration) inputConfigurationCompat.a());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public List<OutputConfigurationCompat> d() {
            return this.f2849b;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public Object e() {
            return this.f2848a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SessionConfigurationCompatApi28Impl)) {
                return false;
            }
            return Objects.equals(this.f2848a, ((SessionConfigurationCompatApi28Impl) obj).f2848a);
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public int f() {
            return this.f2848a.getSessionType();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public void g(@NonNull CaptureRequest captureRequest) {
            this.f2848a.setSessionParameters(captureRequest);
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        @NonNull
        public Executor getExecutor() {
            return this.f2848a.getExecutor();
        }

        public int hashCode() {
            return this.f2848a.hashCode();
        }

        SessionConfigurationCompatApi28Impl(int i8, @NonNull List<OutputConfigurationCompat> list, @NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this(new SessionConfiguration(i8, SessionConfigurationCompat.h(list), executor, stateCallback));
        }
    }
}
