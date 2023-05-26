package eu.bolt.verification.sdk.internal;

import eu.bolt.client.design.button.a;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public abstract class m6 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final a.b f44155f;

    /* loaded from: classes5.dex */
    public static final class a extends m6 {

        /* renamed from: g  reason: collision with root package name */
        public static final a f44156g = new a();

        private a() {
            super(a.b.Primary, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends m6 {

        /* renamed from: g  reason: collision with root package name */
        public static final b f44157g = new b();

        private b() {
            super(a.b.Secondary, null);
        }
    }

    private m6(a.b bVar) {
        this.f44155f = bVar;
    }

    public /* synthetic */ m6(a.b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar);
    }

    public final a.b a() {
        return this.f44155f;
    }
}
