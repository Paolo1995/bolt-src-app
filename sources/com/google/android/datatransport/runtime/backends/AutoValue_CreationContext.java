package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.runtime.time.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_CreationContext extends CreationContext {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12130a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f12131b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f12132c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12133d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.f12130a = context;
            if (clock != null) {
                this.f12131b = clock;
                if (clock2 != null) {
                    this.f12132c = clock2;
                    if (str != null) {
                        this.f12133d = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Context b() {
        return this.f12130a;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    @NonNull
    public String c() {
        return this.f12133d;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock d() {
        return this.f12132c;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public Clock e() {
        return this.f12131b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        CreationContext creationContext = (CreationContext) obj;
        if (this.f12130a.equals(creationContext.b()) && this.f12131b.equals(creationContext.e()) && this.f12132c.equals(creationContext.d()) && this.f12133d.equals(creationContext.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f12130a.hashCode() ^ 1000003) * 1000003) ^ this.f12131b.hashCode()) * 1000003) ^ this.f12132c.hashCode()) * 1000003) ^ this.f12133d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f12130a + ", wallClock=" + this.f12131b + ", monotonicClock=" + this.f12132c + ", backendName=" + this.f12133d + "}";
    }
}
