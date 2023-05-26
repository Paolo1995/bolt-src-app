package eu.bolt.chat.network.data;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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

/* compiled from: OutgoingChatEvent.kt */
@Serializable
/* loaded from: classes5.dex */
public abstract class OutgoingEventBase {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private static final Lazy<KSerializer<Object>> f39249a;

    /* compiled from: OutgoingChatEvent.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy a() {
            return OutgoingEventBase.f39249a;
        }

        public final KSerializer<OutgoingEventBase> serializer() {
            return (KSerializer) a().getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> a8;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: eu.bolt.chat.network.data.OutgoingEventBase$Companion$$cachedSerializer$delegate$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final KSerializer<Object> invoke() {
                return new SealedClassSerializer("eu.bolt.chat.network.data.OutgoingEventBase", Reflection.b(OutgoingEventBase.class), new KClass[]{Reflection.b(OutgoingChatMessageEvent.class), Reflection.b(OutgoingMessageSeenEvent.class), Reflection.b(OutgoingQuickReplyMessageEvent.class), Reflection.b(OutgoingQuickReplyRequestEvent.class)}, new KSerializer[]{OutgoingChatMessageEvent$$serializer.f39247a, OutgoingMessageSeenEvent$$serializer.f39253a, OutgoingQuickReplyMessageEvent$$serializer.f39257a, OutgoingQuickReplyRequestEvent$$serializer.f39260a}, new Annotation[0]);
            }
        });
        f39249a = a8;
    }

    private OutgoingEventBase() {
    }

    public /* synthetic */ OutgoingEventBase(int i8, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ OutgoingEventBase(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final void b(OutgoingEventBase self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.f(self, "self");
        Intrinsics.f(output, "output");
        Intrinsics.f(serialDesc, "serialDesc");
    }
}
