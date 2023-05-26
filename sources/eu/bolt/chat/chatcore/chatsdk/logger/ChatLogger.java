package eu.bolt.chat.chatcore.chatsdk.logger;

import eu.bolt.chat.logger.ClientChatLogger;
import eu.bolt.chat.tools.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatLogger.kt */
/* loaded from: classes5.dex */
public final class ChatLogger implements ClientChatLogger {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f38061a;

    /* compiled from: ChatLogger.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38062a;

        static {
            int[] iArr = new int[ClientChatLogger.Severity.values().length];
            try {
                iArr[ClientChatLogger.Severity.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClientChatLogger.Severity.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClientChatLogger.Severity.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ClientChatLogger.Severity.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ClientChatLogger.Severity.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ClientChatLogger.Severity.ASSERT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f38062a = iArr;
        }
    }

    public ChatLogger(Logger logger) {
        Intrinsics.f(logger, "logger");
        this.f38061a = logger;
    }

    private final String c(String str, String str2) {
        return '[' + str + "]: " + str2;
    }

    @Override // eu.bolt.chat.logger.ClientChatLogger
    public boolean a(ClientChatLogger.Severity severity) {
        Intrinsics.f(severity, "severity");
        return true;
    }

    @Override // eu.bolt.chat.logger.ClientChatLogger
    public void b(ClientChatLogger.Severity severity, String message, String tag, Throwable th) {
        Intrinsics.f(severity, "severity");
        Intrinsics.f(message, "message");
        Intrinsics.f(tag, "tag");
        switch (WhenMappings.f38062a[severity.ordinal()]) {
            case 1:
                this.f38061a.g(c(tag, message));
                return;
            case 2:
                this.f38061a.f(c(tag, message));
                return;
            case 3:
                this.f38061a.b(c(tag, message));
                return;
            case 4:
                this.f38061a.d(c(tag, message));
                return;
            case 5:
            case 6:
                Logger logger = this.f38061a;
                if (th == null) {
                    th = new Exception("Unknown Error");
                }
                logger.a(th, c(tag, message));
                return;
            default:
                return;
        }
    }
}
