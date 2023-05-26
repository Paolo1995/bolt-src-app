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

/* compiled from: ChatStatusNet.kt */
@Serializable
/* loaded from: classes5.dex */
public enum ChatStatusNet {
    CREATED,
    FINISHED,
    ABORTED;
    
    public static final Companion Companion = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private static final Lazy<KSerializer<Object>> f39176f;

    /* compiled from: ChatStatusNet.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy a() {
            return ChatStatusNet.f39176f;
        }

        public final KSerializer<ChatStatusNet> serializer() {
            return (KSerializer) a().getValue();
        }
    }

    static {
        Lazy<KSerializer<Object>> a8;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<KSerializer<Object>>() { // from class: eu.bolt.chat.network.data.ChatStatusNet$Companion$$cachedSerializer$delegate$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final KSerializer<Object> invoke() {
                return EnumsKt.a("eu.bolt.chat.network.data.ChatStatusNet", ChatStatusNet.values(), new String[]{"created", "finished", "aborted"}, new Annotation[][]{null, null, null});
            }
        });
        f39176f = a8;
    }
}
