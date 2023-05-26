package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class xi implements Serializable {

    /* loaded from: classes5.dex */
    public static final class a extends xi {

        /* renamed from: f  reason: collision with root package name */
        private final String f45655f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String storyId) {
            super(null);
            Intrinsics.f(storyId, "storyId");
            this.f45655f = storyId;
        }

        public final String a() {
            return this.f45655f;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends xi {

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f45656f;

        /* renamed from: g  reason: collision with root package name */
        private final int f45657g;

        public final int a() {
            return this.f45657g;
        }

        public final List<String> b() {
            return this.f45656f;
        }
    }

    private xi() {
    }

    public /* synthetic */ xi(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
