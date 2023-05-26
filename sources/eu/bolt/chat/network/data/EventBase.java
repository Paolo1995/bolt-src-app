package eu.bolt.chat.network.data;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: IncomingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public abstract class EventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private static final Lazy<KSerializer<Object>> f39201a = LazyKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: eu.bolt.chat.network.data.EventBase$Companion$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("eu.bolt.chat.network.data.EventBase", Reflection.b(EventBase.class), new KClass[]{Reflection.b(EndChatEvent.class), Reflection.b(ServiceMessageEvent.class), Reflection.b(UnknownMessageEvent.class), Reflection.b(UserMessageEvent.class), Reflection.b(QuickReplySuggestionsEvent.class), Reflection.b(SeenMessagesEvent.class), Reflection.b(StartChatEvent.class)}, new KSerializer[]{EndChatEvent$$serializer.f39199a, ServiceMessageEvent$$serializer.f39297a, UnknownMessageEvent$$serializer.f39321a, UserMessageEvent$$serializer.f39330a, QuickReplySuggestionsEvent$$serializer.f39276a, SeenMessagesEvent$$serializer.f39282a, StartChatEvent$$serializer.f39306a}, new Annotation[0]);
        }
    });

    /* compiled from: IncomingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy a() {
            return EventBase.f39201a;
        }

        public final KSerializer<EventBase> serializer() {
            return (KSerializer) a().getValue();
        }
    }

    private EventBase() {
    }

    public /* synthetic */ EventBase(int i8, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ EventBase(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void d(EventBase self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
    }

    public abstract long b();

    public abstract ChatMessageSender c();
}
