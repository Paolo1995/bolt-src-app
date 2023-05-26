package eu.bolt.chat.chatcore.chatsdk;

import eu.bolt.chat.ChatKit;
import eu.bolt.chat.chatcore.chatsdk.ChatSdkStatus;
import eu.bolt.chat.chatcore.chatsdk.logger.ChatLogger;
import eu.bolt.chat.chatcore.user.ChatConnectionSettingsProvider;
import eu.bolt.chat.data.connection.ChatConnectionSettings;
import eu.bolt.chat.network.CredentialsProvider;
import eu.bolt.chat.tools.logger.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatSdkInitializer.kt */
/* loaded from: classes5.dex */
public final class ChatSdkInitializerImpl implements ChatSdkInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final ChatConnectionSettingsProvider f38047a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialsProvider f38048b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f38049c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f38050d;

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f38051e;

    /* renamed from: f  reason: collision with root package name */
    private final MutableStateFlow<ChatSdkStatus> f38052f;

    public ChatSdkInitializerImpl(ChatConnectionSettingsProvider connectionSettingsProvider, CredentialsProvider credentialsProvider, Logger logger) {
        Intrinsics.f(connectionSettingsProvider, "connectionSettingsProvider");
        Intrinsics.f(credentialsProvider, "credentialsProvider");
        Intrinsics.f(logger, "logger");
        this.f38047a = connectionSettingsProvider;
        this.f38048b = credentialsProvider;
        this.f38049c = logger;
        this.f38050d = new AtomicBoolean(false);
        this.f38051e = new ReentrantLock();
        this.f38052f = StateFlowKt.a(ChatSdkStatus.Uninitialized.f38060a);
    }

    @Override // eu.bolt.chat.chatcore.chatsdk.ChatSdkInitializer
    public void a() {
        ChatConnectionSettings c8;
        ReentrantLock reentrantLock = this.f38051e;
        reentrantLock.lock();
        try {
            if (this.f38050d.compareAndSet(false, true)) {
                c8 = ChatSdkInitializerKt.c(this.f38047a, this.f38048b);
                ChatLogger chatLogger = new ChatLogger(this.f38049c);
                ChatKit chatKit = ChatKit.f37850a;
                chatKit.e(c8, chatLogger);
                this.f38052f.setValue(new ChatSdkStatus.Initialized(chatKit.b(), chatKit.c()));
                this.f38049c.b("Chat SDK is initialized");
            }
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // eu.bolt.chat.chatcore.chatsdk.ChatSdkInitializer
    public StateFlow<ChatSdkStatus> b() {
        return FlowKt.c(this.f38052f);
    }
}
