package eu.bolt.chat.network.data;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ActiveChatListNet.kt */
@Serializable
/* loaded from: classes5.dex */
public final class ActiveChatListNet {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final List<ActiveChatNet> f39130a;

    /* compiled from: ActiveChatListNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ActiveChatListNet> serializer() {
            return ActiveChatListNet$$serializer.f39131a;
        }
    }

    public ActiveChatListNet() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ ActiveChatListNet(int i8, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 0) != 0) {
            PluginExceptionsKt.a(i8, 0, ActiveChatListNet$$serializer.f39131a.a());
        }
        if ((i8 & 1) == 0) {
            this.f39130a = null;
        } else {
            this.f39130a = list;
        }
    }

    public static final void b(ActiveChatListNet self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z7 = true;
        if (!output.z(serialDesc, 0) && self.f39130a == null) {
            z7 = false;
        }
        if (z7) {
            output.i(serialDesc, 0, new ArrayListSerializer(ActiveChatNet$$serializer.f39139a), self.f39130a);
        }
    }

    public final List<ActiveChatNet> a() {
        return this.f39130a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActiveChatListNet) && Intrinsics.a(this.f39130a, ((ActiveChatListNet) obj).f39130a);
    }

    public int hashCode() {
        List<ActiveChatNet> list = this.f39130a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "ActiveChatListNet(chats=" + this.f39130a + ')';
    }

    public ActiveChatListNet(List<ActiveChatNet> list) {
        this.f39130a = list;
    }

    public /* synthetic */ ActiveChatListNet(List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : list);
    }
}
