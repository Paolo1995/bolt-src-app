package eu.bolt.chat.logger;

/* compiled from: ClientChatLogger.kt */
/* loaded from: classes5.dex */
public interface ClientChatLogger {

    /* compiled from: ClientChatLogger.kt */
    /* loaded from: classes5.dex */
    public enum Severity {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        ASSERT
    }

    boolean a(Severity severity);

    void b(Severity severity, String str, String str2, Throwable th);
}
