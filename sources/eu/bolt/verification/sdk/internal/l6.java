package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class l6 implements Serializable {

    /* loaded from: classes5.dex */
    public static final class a extends l6 {

        /* renamed from: f  reason: collision with root package name */
        public static final a f44013f = new a();

        private a() {
            super(null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends l6 {

        /* renamed from: f  reason: collision with root package name */
        public static final b f44014f = new b();

        private b() {
            super(null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends l6 {

        /* renamed from: f  reason: collision with root package name */
        private final Serializable f44015f;

        public final Serializable a() {
            return this.f44015f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.a(this.f44015f, ((c) obj).f44015f);
        }

        public int hashCode() {
            return this.f44015f.hashCode();
        }

        public String toString() {
            Serializable serializable = this.f44015f;
            return "CustomActionWithPayload(payload=" + serializable + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends l6 {

        /* renamed from: f  reason: collision with root package name */
        private final String f44016f;

        public final String a() {
            return this.f44016f;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends l6 {

        /* renamed from: f  reason: collision with root package name */
        private final String f44017f;

        public final String a() {
            return this.f44017f;
        }
    }

    private l6() {
    }

    public /* synthetic */ l6(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
