package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseAttachState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class UseCaseAttachState {

    /* renamed from: a  reason: collision with root package name */
    private final String f3710a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, UseCaseAttachInfo> f3711b = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface AttachStateFilter {
        boolean a(UseCaseAttachInfo useCaseAttachInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class UseCaseAttachInfo {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final SessionConfig f3712a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final UseCaseConfig<?> f3713b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3714c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3715d = false;

        UseCaseAttachInfo(@NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
            this.f3712a = sessionConfig;
            this.f3713b = useCaseConfig;
        }

        boolean a() {
            return this.f3715d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b() {
            return this.f3714c;
        }

        @NonNull
        SessionConfig c() {
            return this.f3712a;
        }

        @NonNull
        UseCaseConfig<?> d() {
            return this.f3713b;
        }

        void e(boolean z7) {
            this.f3715d = z7;
        }

        void f(boolean z7) {
            this.f3714c = z7;
        }
    }

    public UseCaseAttachState(@NonNull String str) {
        this.f3710a = str;
    }

    private UseCaseAttachInfo i(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        UseCaseAttachInfo useCaseAttachInfo = this.f3711b.get(str);
        if (useCaseAttachInfo == null) {
            UseCaseAttachInfo useCaseAttachInfo2 = new UseCaseAttachInfo(sessionConfig, useCaseConfig);
            this.f3711b.put(str, useCaseAttachInfo2);
            return useCaseAttachInfo2;
        }
        return useCaseAttachInfo;
    }

    private Collection<SessionConfig> j(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.f3711b.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.a(entry.getValue())) {
                arrayList.add(entry.getValue().c());
            }
        }
        return arrayList;
    }

    private Collection<UseCaseConfig<?>> k(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.f3711b.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.a(entry.getValue())) {
                arrayList.add(entry.getValue().d());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean m(UseCaseAttachInfo useCaseAttachInfo) {
        if (useCaseAttachInfo.a() && useCaseAttachInfo.b()) {
            return true;
        }
        return false;
    }

    @NonNull
    public SessionConfig.ValidatingBuilder d() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.f3711b.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.a() && value.b()) {
                validatingBuilder.a(value.c());
                arrayList.add(entry.getKey());
            }
        }
        Logger.a("UseCaseAttachState", "Active and attached use case: " + arrayList + " for camera: " + this.f3710a);
        return validatingBuilder;
    }

    @NonNull
    public Collection<SessionConfig> e() {
        return Collections.unmodifiableCollection(j(new AttachStateFilter() { // from class: androidx.camera.core.impl.w
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public final boolean a(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
                boolean m8;
                m8 = UseCaseAttachState.m(useCaseAttachInfo);
                return m8;
            }
        }));
    }

    @NonNull
    public SessionConfig.ValidatingBuilder f() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, UseCaseAttachInfo> entry : this.f3711b.entrySet()) {
            UseCaseAttachInfo value = entry.getValue();
            if (value.b()) {
                validatingBuilder.a(value.c());
                arrayList.add(entry.getKey());
            }
        }
        Logger.a("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + this.f3710a);
        return validatingBuilder;
    }

    @NonNull
    public Collection<SessionConfig> g() {
        return Collections.unmodifiableCollection(j(new AttachStateFilter() { // from class: androidx.camera.core.impl.u
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public final boolean a(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
                boolean b8;
                b8 = useCaseAttachInfo.b();
                return b8;
            }
        }));
    }

    @NonNull
    public Collection<UseCaseConfig<?>> h() {
        return Collections.unmodifiableCollection(k(new AttachStateFilter() { // from class: androidx.camera.core.impl.v
            @Override // androidx.camera.core.impl.UseCaseAttachState.AttachStateFilter
            public final boolean a(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
                boolean b8;
                b8 = useCaseAttachInfo.b();
                return b8;
            }
        }));
    }

    public boolean l(@NonNull String str) {
        if (!this.f3711b.containsKey(str)) {
            return false;
        }
        return this.f3711b.get(str).b();
    }

    public void p(@NonNull String str) {
        this.f3711b.remove(str);
    }

    public void q(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        i(str, sessionConfig, useCaseConfig).e(true);
    }

    public void r(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        i(str, sessionConfig, useCaseConfig).f(true);
    }

    public void s(@NonNull String str) {
        if (!this.f3711b.containsKey(str)) {
            return;
        }
        UseCaseAttachInfo useCaseAttachInfo = this.f3711b.get(str);
        useCaseAttachInfo.f(false);
        if (!useCaseAttachInfo.a()) {
            this.f3711b.remove(str);
        }
    }

    public void t(@NonNull String str) {
        if (!this.f3711b.containsKey(str)) {
            return;
        }
        UseCaseAttachInfo useCaseAttachInfo = this.f3711b.get(str);
        useCaseAttachInfo.e(false);
        if (!useCaseAttachInfo.b()) {
            this.f3711b.remove(str);
        }
    }

    public void u(@NonNull String str, @NonNull SessionConfig sessionConfig, @NonNull UseCaseConfig<?> useCaseConfig) {
        if (!this.f3711b.containsKey(str)) {
            return;
        }
        UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(sessionConfig, useCaseConfig);
        UseCaseAttachInfo useCaseAttachInfo2 = this.f3711b.get(str);
        useCaseAttachInfo.f(useCaseAttachInfo2.b());
        useCaseAttachInfo.e(useCaseAttachInfo2.a());
        this.f3711b.put(str, useCaseAttachInfo);
    }
}
