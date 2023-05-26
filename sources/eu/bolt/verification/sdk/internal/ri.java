package eu.bolt.verification.sdk.internal;

import eu.bolt.client.design.button.DesignButton;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public abstract class ri implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final DesignButton.b f44835f;

    /* loaded from: classes5.dex */
    public static final class a extends ri {

        /* renamed from: g  reason: collision with root package name */
        public static final a f44836g = new a();

        private a() {
            super(DesignButton.b.Danger, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ri {

        /* renamed from: g  reason: collision with root package name */
        public static final b f44837g = new b();

        private b() {
            super(DesignButton.b.Primary, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends ri {

        /* renamed from: g  reason: collision with root package name */
        public static final c f44838g = new c();

        private c() {
            super(DesignButton.b.Secondary, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends ri {

        /* renamed from: g  reason: collision with root package name */
        public static final d f44839g = new d();

        private d() {
            super(DesignButton.b.Text, null);
        }
    }

    private ri(DesignButton.b bVar) {
        this.f44835f = bVar;
    }

    public /* synthetic */ ri(DesignButton.b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar);
    }

    public final DesignButton.b a() {
        return this.f44835f;
    }
}
