package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_SessionConfig_OutputConfig extends SessionConfig.OutputConfig {

    /* renamed from: a  reason: collision with root package name */
    private final DeferrableSurface f3536a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DeferrableSurface> f3537b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3538c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3539d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends SessionConfig.OutputConfig.Builder {

        /* renamed from: a  reason: collision with root package name */
        private DeferrableSurface f3540a;

        /* renamed from: b  reason: collision with root package name */
        private List<DeferrableSurface> f3541b;

        /* renamed from: c  reason: collision with root package name */
        private String f3542c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f3543d;

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig a() {
            String str = "";
            if (this.f3540a == null) {
                str = " surface";
            }
            if (this.f3541b == null) {
                str = str + " sharedSurfaces";
            }
            if (this.f3543d == null) {
                str = str + " surfaceGroupId";
            }
            if (str.isEmpty()) {
                return new AutoValue_SessionConfig_OutputConfig(this.f3540a, this.f3541b, this.f3542c, this.f3543d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder b(String str) {
            this.f3542c = str;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder c(List<DeferrableSurface> list) {
            if (list != null) {
                this.f3541b = list;
                return this;
            }
            throw new NullPointerException("Null sharedSurfaces");
        }

        @Override // androidx.camera.core.impl.SessionConfig.OutputConfig.Builder
        public SessionConfig.OutputConfig.Builder d(int i8) {
            this.f3543d = Integer.valueOf(i8);
            return this;
        }

        public SessionConfig.OutputConfig.Builder e(DeferrableSurface deferrableSurface) {
            if (deferrableSurface != null) {
                this.f3540a = deferrableSurface;
                return this;
            }
            throw new NullPointerException("Null surface");
        }
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public String b() {
        return this.f3538c;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    @NonNull
    public List<DeferrableSurface> c() {
        return this.f3537b;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    @NonNull
    public DeferrableSurface d() {
        return this.f3536a;
    }

    @Override // androidx.camera.core.impl.SessionConfig.OutputConfig
    public int e() {
        return this.f3539d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SessionConfig.OutputConfig)) {
            return false;
        }
        SessionConfig.OutputConfig outputConfig = (SessionConfig.OutputConfig) obj;
        if (this.f3536a.equals(outputConfig.d()) && this.f3537b.equals(outputConfig.c()) && ((str = this.f3538c) != null ? str.equals(outputConfig.b()) : outputConfig.b() == null) && this.f3539d == outputConfig.e()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((this.f3536a.hashCode() ^ 1000003) * 1000003) ^ this.f3537b.hashCode()) * 1000003;
        String str = this.f3538c;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode2 ^ hashCode) * 1000003) ^ this.f3539d;
    }

    public String toString() {
        return "OutputConfig{surface=" + this.f3536a + ", sharedSurfaces=" + this.f3537b + ", physicalCameraId=" + this.f3538c + ", surfaceGroupId=" + this.f3539d + "}";
    }

    private AutoValue_SessionConfig_OutputConfig(DeferrableSurface deferrableSurface, List<DeferrableSurface> list, String str, int i8) {
        this.f3536a = deferrableSurface;
        this.f3537b = list;
        this.f3538c = str;
        this.f3539d = i8;
    }
}
