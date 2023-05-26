package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ha implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final ll f43350f;

    /* renamed from: g  reason: collision with root package name */
    private final ll f43351g;

    /* renamed from: h  reason: collision with root package name */
    private final List<a> f43352h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f43353i;

    /* renamed from: j  reason: collision with root package name */
    private final b f43354j;

    /* renamed from: k  reason: collision with root package name */
    private final b f43355k;

    /* loaded from: classes5.dex */
    public static final class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final ll f43356f;

        /* renamed from: g  reason: collision with root package name */
        private final b f43357g;

        /* renamed from: h  reason: collision with root package name */
        private final AbstractC0058a f43358h;

        /* renamed from: eu.bolt.verification.sdk.internal.ha$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static abstract class AbstractC0058a implements Serializable {

            /* renamed from: eu.bolt.verification.sdk.internal.ha$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0059a extends AbstractC0058a {

                /* renamed from: f  reason: collision with root package name */
                private final Serializable f43359f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0059a(Serializable payload) {
                    super(null);
                    Intrinsics.f(payload, "payload");
                    this.f43359f = payload;
                }

                public final Serializable a() {
                    return this.f43359f;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof C0059a) && Intrinsics.a(this.f43359f, ((C0059a) obj).f43359f);
                }

                public int hashCode() {
                    return this.f43359f.hashCode();
                }

                public String toString() {
                    Serializable serializable = this.f43359f;
                    return "Custom(payload=" + serializable + ")";
                }
            }

            /* renamed from: eu.bolt.verification.sdk.internal.ha$a$a$b */
            /* loaded from: classes5.dex */
            public static final class b extends AbstractC0058a {

                /* renamed from: f  reason: collision with root package name */
                private final String f43360f;

                public final String a() {
                    return this.f43360f;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof b) && Intrinsics.a(this.f43360f, ((b) obj).f43360f);
                }

                public int hashCode() {
                    return this.f43360f.hashCode();
                }

                public String toString() {
                    String str = this.f43360f;
                    return "OpenStory(storyId=" + str + ")";
                }
            }

            /* renamed from: eu.bolt.verification.sdk.internal.ha$a$a$c */
            /* loaded from: classes5.dex */
            public static final class c extends AbstractC0058a {

                /* renamed from: f  reason: collision with root package name */
                private final String f43361f;

                public final String a() {
                    return this.f43361f;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof c) && Intrinsics.a(this.f43361f, ((c) obj).f43361f);
                }

                public int hashCode() {
                    return this.f43361f.hashCode();
                }

                public String toString() {
                    String str = this.f43361f;
                    return "OpenUrl(url=" + str + ")";
                }
            }

            private AbstractC0058a() {
            }

            public /* synthetic */ AbstractC0058a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* loaded from: classes5.dex */
        public enum b {
            PRIMARY,
            SECONDARY,
            DANGER,
            TEXT,
            AUTO
        }

        public a(ll text, b uiType, AbstractC0058a action) {
            Intrinsics.f(text, "text");
            Intrinsics.f(uiType, "uiType");
            Intrinsics.f(action, "action");
            this.f43356f = text;
            this.f43357g = uiType;
            this.f43358h = action;
        }

        public final AbstractC0058a a() {
            return this.f43358h;
        }

        public final ll b() {
            return this.f43356f;
        }

        public final b c() {
            return this.f43357g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f43356f, aVar.f43356f) && this.f43357g == aVar.f43357g && Intrinsics.a(this.f43358h, aVar.f43358h);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f43356f.hashCode() * 31) + this.f43357g.hashCode()) * 31) + this.f43358h.hashCode();
        }

        public String toString() {
            ll llVar = this.f43356f;
            b bVar = this.f43357g;
            AbstractC0058a abstractC0058a = this.f43358h;
            return "Button(text=" + llVar + ", uiType=" + bVar + ", action=" + abstractC0058a + ")";
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        START(2),
        CENTRE(4),
        END(3);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f43372f;

        b(int i8) {
            this.f43372f = i8;
        }

        public final int c() {
            return this.f43372f;
        }
    }

    public ha(ll llVar, ll message, List<a> buttons, boolean z7, b titleAlignment, b messageAlignment) {
        Intrinsics.f(message, "message");
        Intrinsics.f(buttons, "buttons");
        Intrinsics.f(titleAlignment, "titleAlignment");
        Intrinsics.f(messageAlignment, "messageAlignment");
        this.f43350f = llVar;
        this.f43351g = message;
        this.f43352h = buttons;
        this.f43353i = z7;
        this.f43354j = titleAlignment;
        this.f43355k = messageAlignment;
    }

    public /* synthetic */ ha(ll llVar, ll llVar2, List list, boolean z7, b bVar, b bVar2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(llVar, llVar2, (i8 & 4) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i8 & 8) != 0 ? false : z7, (i8 & 16) != 0 ? b.CENTRE : bVar, (i8 & 32) != 0 ? b.CENTRE : bVar2);
    }

    public final List<a> a() {
        return this.f43352h;
    }

    public final ll b() {
        return this.f43351g;
    }

    public final b c() {
        return this.f43355k;
    }

    public final boolean d() {
        return this.f43353i;
    }

    public final ll e() {
        return this.f43350f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ha) {
            ha haVar = (ha) obj;
            return Intrinsics.a(this.f43350f, haVar.f43350f) && Intrinsics.a(this.f43351g, haVar.f43351g) && Intrinsics.a(this.f43352h, haVar.f43352h) && this.f43353i == haVar.f43353i && this.f43354j == haVar.f43354j && this.f43355k == haVar.f43355k;
        }
        return false;
    }

    public final b f() {
        return this.f43354j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ll llVar = this.f43350f;
        int hashCode = (((((llVar == null ? 0 : llVar.hashCode()) * 31) + this.f43351g.hashCode()) * 31) + this.f43352h.hashCode()) * 31;
        boolean z7 = this.f43353i;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return ((((hashCode + i8) * 31) + this.f43354j.hashCode()) * 31) + this.f43355k.hashCode();
    }

    public String toString() {
        ll llVar = this.f43350f;
        ll llVar2 = this.f43351g;
        List<a> list = this.f43352h;
        boolean z7 = this.f43353i;
        b bVar = this.f43354j;
        b bVar2 = this.f43355k;
        return "InformationUiModel(title=" + llVar + ", message=" + llVar2 + ", buttons=" + list + ", showCloseButton=" + z7 + ", titleAlignment=" + bVar + ", messageAlignment=" + bVar2 + ")";
    }
}
