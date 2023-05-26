package eu.bolt.chat.client;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.di.ChatKitComponent;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;

/* compiled from: DefaultChatClientManager.kt */
/* loaded from: classes5.dex */
public final class DefaultChatClientManager implements InternalChatClientManager, ChatKitComponent {

    /* renamed from: a  reason: collision with root package name */
    private final ChatClientDisposer f38835a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f38836b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f38837c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f38838d;

    /* renamed from: e  reason: collision with root package name */
    private InternalChatClient f38839e;

    public DefaultChatClientManager(ChatClientDisposer chatClientDisposer, Logger logger) {
        Intrinsics.f(chatClientDisposer, "chatClientDisposer");
        Intrinsics.f(logger, "logger");
        this.f38835a = chatClientDisposer;
        this.f38836b = logger;
        this.f38837c = new Object();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0041 A[Catch: all -> 0x0088, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000a, B:8:0x001c, B:9:0x0025, B:12:0x002c, B:14:0x0030, B:22:0x0041, B:24:0x0053, B:25:0x005c, B:27:0x0060, B:28:0x006b, B:30:0x0081, B:29:0x0070), top: B:36:0x0005 }] */
    @Override // eu.bolt.chat.client.ChatClientManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public eu.bolt.chat.client.ChatClient b() {
        /*
            r7 = this;
            java.lang.Class<eu.bolt.chat.client.InternalChatClient> r0 = eu.bolt.chat.client.InternalChatClient.class
            java.lang.Object r1 = r7.f38837c
            monitor-enter(r1)
            boolean r2 = r7.f38838d     // Catch: java.lang.Throwable -> L88
            r3 = 0
            if (r2 == 0) goto L2c
            co.touchlab.kermit.Logger r0 = r7.f38836b     // Catch: java.lang.Throwable -> L88
            co.touchlab.kermit.LoggerConfig r2 = r0.c()     // Catch: java.lang.Throwable -> L88
            co.touchlab.kermit.Severity r2 = r2.a()     // Catch: java.lang.Throwable -> L88
            co.touchlab.kermit.Severity r4 = co.touchlab.kermit.Severity.Warn     // Catch: java.lang.Throwable -> L88
            int r2 = r2.compareTo(r4)     // Catch: java.lang.Throwable -> L88
            if (r2 > 0) goto L25
            java.lang.String r2 = r0.d()     // Catch: java.lang.Throwable -> L88
            java.lang.String r5 = "Attempt to access a chat client after disposing the chat client manager"
            r0.f(r4, r2, r3, r5)     // Catch: java.lang.Throwable -> L88
        L25:
            eu.bolt.chat.client.StubChatClient r0 = new eu.bolt.chat.client.StubChatClient     // Catch: java.lang.Throwable -> L88
            r0.<init>()     // Catch: java.lang.Throwable -> L88
            monitor-exit(r1)
            return r0
        L2c:
            eu.bolt.chat.client.InternalChatClient r2 = r7.f38839e     // Catch: java.lang.Throwable -> L88
            if (r2 == 0) goto L3e
            eu.bolt.chat.data.ClientStatus r4 = r2.getStatus()     // Catch: java.lang.Throwable -> L88
            eu.bolt.chat.data.ClientStatus r5 = eu.bolt.chat.data.ClientStatus.DISCONNECTED     // Catch: java.lang.Throwable -> L88
            if (r4 != r5) goto L3a
            r4 = 1
            goto L3b
        L3a:
            r4 = 0
        L3b:
            if (r4 != 0) goto L3e
            goto L3f
        L3e:
            r2 = r3
        L3f:
            if (r2 != 0) goto L86
            co.touchlab.kermit.Logger r2 = r7.f38836b     // Catch: java.lang.Throwable -> L88
            co.touchlab.kermit.LoggerConfig r4 = r2.c()     // Catch: java.lang.Throwable -> L88
            co.touchlab.kermit.Severity r4 = r4.a()     // Catch: java.lang.Throwable -> L88
            co.touchlab.kermit.Severity r5 = co.touchlab.kermit.Severity.Debug     // Catch: java.lang.Throwable -> L88
            int r4 = r4.compareTo(r5)     // Catch: java.lang.Throwable -> L88
            if (r4 > 0) goto L5c
            java.lang.String r4 = r2.d()     // Catch: java.lang.Throwable -> L88
            java.lang.String r6 = "Creating a new chat client"
            r2.f(r5, r4, r3, r6)     // Catch: java.lang.Throwable -> L88
        L5c:
            boolean r2 = r7 instanceof org.koin.core.component.KoinScopeComponent     // Catch: java.lang.Throwable -> L88
            if (r2 == 0) goto L70
            r2 = r7
            org.koin.core.component.KoinScopeComponent r2 = (org.koin.core.component.KoinScopeComponent) r2     // Catch: java.lang.Throwable -> L88
            org.koin.core.scope.Scope r2 = r2.a()     // Catch: java.lang.Throwable -> L88
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.b(r0)     // Catch: java.lang.Throwable -> L88
        L6b:
            java.lang.Object r0 = r2.f(r0, r3, r3)     // Catch: java.lang.Throwable -> L88
            goto L81
        L70:
            org.koin.core.Koin r2 = r7.e()     // Catch: java.lang.Throwable -> L88
            org.koin.core.registry.ScopeRegistry r2 = r2.e()     // Catch: java.lang.Throwable -> L88
            org.koin.core.scope.Scope r2 = r2.d()     // Catch: java.lang.Throwable -> L88
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.b(r0)     // Catch: java.lang.Throwable -> L88
            goto L6b
        L81:
            r2 = r0
            eu.bolt.chat.client.InternalChatClient r2 = (eu.bolt.chat.client.InternalChatClient) r2     // Catch: java.lang.Throwable -> L88
            r7.f38839e = r2     // Catch: java.lang.Throwable -> L88
        L86:
            monitor-exit(r1)
            return r2
        L88:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.client.DefaultChatClientManager.b():eu.bolt.chat.client.ChatClient");
    }

    @Override // eu.bolt.chat.client.ChatClientManager
    public void c(ChatClient client) {
        Intrinsics.f(client, "client");
        synchronized (this.f38837c) {
            if (this.f38838d) {
                Logger logger = this.f38836b;
                Severity a8 = logger.c().a();
                Severity severity = Severity.Warn;
                if (a8.compareTo(severity) <= 0) {
                    String d8 = logger.d();
                    logger.f(severity, d8, null, "Attempt to destroy " + client + " after disposing the chat client manager");
                }
                return;
            }
            if (this.f38839e == client) {
                this.f38839e = null;
                ((InternalChatClient) client).destroy();
            } else {
                Logger logger2 = this.f38836b;
                Severity a9 = logger2.c().a();
                Severity severity2 = Severity.Error;
                if (a9.compareTo(severity2) <= 0) {
                    logger2.f(severity2, logger2.d(), null, "Destroying a chat client that is not the currently active one");
                }
            }
            Unit unit = Unit.f50853a;
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin e() {
        return ChatKitComponent.DefaultImpls.a(this);
    }
}
