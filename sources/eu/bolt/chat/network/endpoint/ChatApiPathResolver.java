package eu.bolt.chat.network.endpoint;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatApiPathResolver.kt */
/* loaded from: classes5.dex */
public final class ChatApiPathResolver {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f39341d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f39342e;

    /* renamed from: a  reason: collision with root package name */
    private final String f39343a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f39344b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f39345c;

    /* compiled from: ChatApiPathResolver.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set<String> f8;
        f8 = SetsKt__SetsKt.f("node.bolt.eu", "node.prelive.bolt.eu");
        f39342e = f8;
    }

    public ChatApiPathResolver(String serverHost) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(serverHost, "serverHost");
        this.f39343a = serverHost;
        b8 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: eu.bolt.chat.network.endpoint.ChatApiPathResolver$chatHistoryPath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final String invoke() {
                String f8;
                f8 = ChatApiPathResolver.this.f();
                return f8;
            }
        });
        this.f39344b = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: eu.bolt.chat.network.endpoint.ChatApiPathResolver$activeChatsPath$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final String invoke() {
                String e8;
                e8 = ChatApiPathResolver.this.e();
                return e8;
            }
        });
        this.f39345c = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        if (f39342e.contains(this.f39343a)) {
            return "chat/driver/getActiveChats";
        }
        return "comms/chat/getActive";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        if (f39342e.contains(this.f39343a)) {
            return "chat/driver/getChatHistory";
        }
        return "comms/chat/getHistory";
    }

    public final String c() {
        return (String) this.f39345c.getValue();
    }

    public final String d() {
        return (String) this.f39344b.getValue();
    }
}
