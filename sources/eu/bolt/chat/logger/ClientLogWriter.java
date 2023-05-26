package eu.bolt.chat.logger;

import co.touchlab.kermit.LogWriter;
import co.touchlab.kermit.Severity;
import eu.bolt.chat.logger.ClientChatLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientLogWriter.kt */
/* loaded from: classes5.dex */
public final class ClientLogWriter extends LogWriter {

    /* renamed from: a  reason: collision with root package name */
    private final ClientChatLogger f39127a;

    /* compiled from: ClientLogWriter.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39128a;

        static {
            int[] iArr = new int[Severity.values().length];
            try {
                iArr[Severity.Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Severity.Debug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Severity.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Severity.Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Severity.Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Severity.Assert.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f39128a = iArr;
        }
    }

    public ClientLogWriter(ClientChatLogger logger) {
        Intrinsics.f(logger, "logger");
        this.f39127a = logger;
    }

    private final ClientChatLogger.Severity c(Severity severity) {
        switch (WhenMappings.f39128a[severity.ordinal()]) {
            case 1:
                return ClientChatLogger.Severity.VERBOSE;
            case 2:
                return ClientChatLogger.Severity.DEBUG;
            case 3:
                return ClientChatLogger.Severity.INFO;
            case 4:
                return ClientChatLogger.Severity.WARN;
            case 5:
                return ClientChatLogger.Severity.ERROR;
            case 6:
                return ClientChatLogger.Severity.ASSERT;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // co.touchlab.kermit.LogWriter
    public boolean a(Severity severity) {
        Intrinsics.f(severity, "severity");
        return this.f39127a.a(c(severity));
    }

    @Override // co.touchlab.kermit.LogWriter
    public void b(Severity severity, String message, String tag, Throwable th) {
        Intrinsics.f(severity, "severity");
        Intrinsics.f(message, "message");
        Intrinsics.f(tag, "tag");
        this.f39127a.b(c(severity), message, tag, th);
    }
}
