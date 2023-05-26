package eu.bolt.chat.network.data;

import i0.a;
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

/* compiled from: IncomingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class QuickReplySuggestionsEvent extends EventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final String f39272b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39273c;

    /* renamed from: d  reason: collision with root package name */
    private final List<QuickReplySuggestionNet> f39274d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatMessageSender f39275e;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<QuickReplySuggestionsEvent> serializer() {
            return QuickReplySuggestionsEvent$$serializer.f39276a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickReplySuggestionsEvent(int i8, String str, long j8, List list, ChatMessageSender chatMessageSender, SerializationConstructorMarker serializationConstructorMarker) {
        super(i8, serializationConstructorMarker);
        if (7 != (i8 & 7)) {
            PluginExceptionsKt.a(i8, 7, QuickReplySuggestionsEvent$$serializer.f39276a.a());
        }
        this.f39272b = str;
        this.f39273c = j8;
        this.f39274d = list;
        if ((i8 & 8) == 0) {
            this.f39275e = null;
        } else {
            this.f39275e = chatMessageSender;
        }
    }

    public static final void g(QuickReplySuggestionsEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        EventBase.d(self, output, serialDesc);
        boolean z7 = false;
        output.y(serialDesc, 0, self.e());
        output.E(serialDesc, 1, self.b());
        output.B(serialDesc, 2, new ArrayListSerializer(QuickReplySuggestionNet$$serializer.f39270a), self.f39274d);
        if (output.z(serialDesc, 3) || self.c() != null) {
            z7 = true;
        }
        if (z7) {
            output.i(serialDesc, 3, ChatMessageSender$$serializer.f39165a, self.c());
        }
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public long b() {
        return this.f39273c;
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public ChatMessageSender c() {
        return this.f39275e;
    }

    public String e() {
        return this.f39272b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuickReplySuggestionsEvent) {
            QuickReplySuggestionsEvent quickReplySuggestionsEvent = (QuickReplySuggestionsEvent) obj;
            return Intrinsics.a(e(), quickReplySuggestionsEvent.e()) && b() == quickReplySuggestionsEvent.b() && Intrinsics.a(this.f39274d, quickReplySuggestionsEvent.f39274d) && Intrinsics.a(c(), quickReplySuggestionsEvent.c());
        }
        return false;
    }

    public final List<QuickReplySuggestionNet> f() {
        return this.f39274d;
    }

    public int hashCode() {
        return (((((e().hashCode() * 31) + a.a(b())) * 31) + this.f39274d.hashCode()) * 31) + (c() == null ? 0 : c().hashCode());
    }

    public String toString() {
        return "QuickReplySuggestionsEvent(id=" + e() + ", date=" + b() + ", suggestions=" + this.f39274d + ", sender=" + c() + ')';
    }
}
