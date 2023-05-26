package ee.mtakso.driver.network.client.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactConfiguration.kt */
/* loaded from: classes3.dex */
public abstract class ContactConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f21780a = new Companion(null);

    /* compiled from: ContactConfiguration.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: ContactConfiguration.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f21781a;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.VOIP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.CHAT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f21781a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ChatConfiguration a(Map<String, String> map) {
            return new ChatConfiguration(Intrinsics.a(MapsKt.g(map, "connect_eagerly"), "true"), null, 2, null);
        }

        private final ContactConfiguration b(Map<String, String> map) {
            int i8;
            Type a8 = Type.Companion.a((String) MapsKt.g(map, "type"));
            if (a8 == null) {
                i8 = -1;
            } else {
                i8 = WhenMappings.f21781a[a8.ordinal()];
            }
            if (i8 != 1) {
                if (i8 != 2) {
                    return null;
                }
                return a(map);
            }
            return new VoipConfiguration(map);
        }

        public final List<ContactConfiguration> c(List<? extends Map<String, String>> rawConfigurations) {
            Intrinsics.f(rawConfigurations, "rawConfigurations");
            ArrayList arrayList = new ArrayList();
            for (Map<String, String> map : rawConfigurations) {
                ContactConfiguration b8 = b(map);
                if (b8 != null) {
                    arrayList.add(b8);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: ContactConfiguration.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        VOIP("voip"),
        CHAT("chat");
        
        public static final Companion Companion = new Companion(null);
        private final String id;

        /* compiled from: ContactConfiguration.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Type a(String id) {
                Type[] values;
                Intrinsics.f(id, "id");
                for (Type type : Type.values()) {
                    if (Intrinsics.a(id, type.getId$app_DA_58_0_liveGoogleRelease())) {
                        return type;
                    }
                }
                return null;
            }
        }

        Type(String str) {
            this.id = str;
        }

        public final String getId$app_DA_58_0_liveGoogleRelease() {
            return this.id;
        }
    }

    private ContactConfiguration() {
    }

    public /* synthetic */ ContactConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Type a();
}
