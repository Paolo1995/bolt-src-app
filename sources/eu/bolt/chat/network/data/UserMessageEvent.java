package eu.bolt.chat.network.data;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IncomingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public final class UserMessageEvent extends MessageEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private final MessageStatusNet f39323b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39324c;

    /* renamed from: d  reason: collision with root package name */
    private final long f39325d;

    /* renamed from: e  reason: collision with root package name */
    private final String f39326e;

    /* renamed from: f  reason: collision with root package name */
    private final String f39327f;

    /* renamed from: g  reason: collision with root package name */
    private final TranslationInfoNet f39328g;

    /* renamed from: h  reason: collision with root package name */
    private final ChatMessageSender f39329h;

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<UserMessageEvent> serializer() {
            return UserMessageEvent$$serializer.f39330a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserMessageEvent(int i8, MessageStatusNet messageStatusNet, String str, long j8, String str2, String str3, TranslationInfoNet translationInfoNet, ChatMessageSender chatMessageSender, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if (6 != (i8 & 6)) {
            PluginExceptionsKt.a(i8, 6, UserMessageEvent$$serializer.f39330a.a());
        }
        this.f39323b = (i8 & 1) == 0 ? MessageStatusNet.DELIVERED_TO_BACKEND : messageStatusNet;
        this.f39324c = str;
        this.f39325d = j8;
        if ((i8 & 8) == 0) {
            this.f39326e = null;
        } else {
            this.f39326e = str2;
        }
        if ((i8 & 16) == 0) {
            this.f39327f = null;
        } else {
            this.f39327f = str3;
        }
        if ((i8 & 32) == 0) {
            this.f39328g = null;
        } else {
            this.f39328g = translationInfoNet;
        }
        if ((i8 & 64) == 0) {
            this.f39329h = null;
        } else {
            this.f39329h = chatMessageSender;
        }
    }

    public static final void j(UserMessageEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
        boolean z11 = false;
        if (output.z(serialDesc, 0) || self.g() != MessageStatusNet.DELIVERED_TO_BACKEND) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            output.B(serialDesc, 0, MessageStatusNet.Companion.serializer(), self.g());
        }
        output.y(serialDesc, 1, self.f());
        output.E(serialDesc, 2, self.b());
        if (output.z(serialDesc, 3) || self.f39326e != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            output.i(serialDesc, 3, StringSerializer.f52262a, self.f39326e);
        }
        if (output.z(serialDesc, 4) || self.f39327f != null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            output.i(serialDesc, 4, StringSerializer.f52262a, self.f39327f);
        }
        if (output.z(serialDesc, 5) || self.f39328g != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            output.i(serialDesc, 5, TranslationInfoNet$$serializer.f39310a, self.f39328g);
        }
        if (output.z(serialDesc, 6) || self.c() != null) {
            z11 = true;
        }
        if (z11) {
            output.i(serialDesc, 6, ChatMessageSender$$serializer.f39165a, self.c());
        }
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public long b() {
        return this.f39325d;
    }

    @Override // eu.bolt.chat.network.data.EventBase
    public ChatMessageSender c() {
        return this.f39329h;
    }

    public final String e() {
        return this.f39327f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserMessageEvent) {
            UserMessageEvent userMessageEvent = (UserMessageEvent) obj;
            return g() == userMessageEvent.g() && Intrinsics.a(f(), userMessageEvent.f()) && b() == userMessageEvent.b() && Intrinsics.a(this.f39326e, userMessageEvent.f39326e) && Intrinsics.a(this.f39327f, userMessageEvent.f39327f) && Intrinsics.a(this.f39328g, userMessageEvent.f39328g) && Intrinsics.a(c(), userMessageEvent.c());
        }
        return false;
    }

    public String f() {
        return this.f39324c;
    }

    public MessageStatusNet g() {
        return this.f39323b;
    }

    public final String h() {
        return this.f39326e;
    }

    public int hashCode() {
        int hashCode = ((((g().hashCode() * 31) + f().hashCode()) * 31) + a.a(b())) * 31;
        String str = this.f39326e;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f39327f;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        TranslationInfoNet translationInfoNet = this.f39328g;
        return ((hashCode3 + (translationInfoNet == null ? 0 : translationInfoNet.hashCode())) * 31) + (c() != null ? c().hashCode() : 0);
    }

    public final TranslationInfoNet i() {
        return this.f39328g;
    }

    public String toString() {
        return "UserMessageEvent(status=" + g() + ", id=" + f() + ", date=" + b() + ", text=" + this.f39326e + ", detectedLanguage=" + this.f39327f + ", translation=" + this.f39328g + ", sender=" + c() + ')';
    }
}
