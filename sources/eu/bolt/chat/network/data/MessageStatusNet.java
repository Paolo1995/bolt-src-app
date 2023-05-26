package eu.bolt.chat.network.data;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* compiled from: MessageStatusNet.kt */
@Serializable
/* loaded from: classes5.dex */
public enum MessageStatusNet {
    DELIVERED_TO_BACKEND,
    DELIVERED_TO_RECIPIENT,
    SEEN;
    
    public static final Companion Companion = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private static final Lazy<KSerializer<Object>> f39211f;

    /* compiled from: MessageStatusNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy a() {
            return MessageStatusNet.f39211f;
        }

        public final KSerializer<MessageStatusNet> serializer() {
            return (KSerializer) a().getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> a8;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: eu.bolt.chat.network.data.MessageStatusNet$Companion$$cachedSerializer$delegate$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final KSerializer<Object> invoke() {
                return EnumsKt.a("eu.bolt.chat.network.data.MessageStatusNet", MessageStatusNet.values(), new String[]{"delivered_to_backend", "delivered_to_recipient", "seen_by_recipient"}, new Annotation[][]{null, null, null});
            }
        });
        f39211f = a8;
    }
}
