package io.netty.util.internal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
class JdkLogger extends AbstractInternalLogger {
    static final String SELF = JdkLogger.class.getName();
    static final String SUPER = AbstractInternalLogger.class.getName();
    final transient Logger logger;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkLogger(Logger logger) {
        super(logger.getName());
        this.logger = logger;
    }

    private static void fillCallerData(String str, LogRecord logRecord) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i8 = 0;
        while (true) {
            if (i8 < stackTrace.length) {
                String className = stackTrace[i8].getClassName();
                if (className.equals(str) || className.equals(SUPER)) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        while (true) {
            i8++;
            if (i8 < stackTrace.length) {
                String className2 = stackTrace[i8].getClassName();
                if (!className2.equals(str) && !className2.equals(SUPER)) {
                    break;
                }
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 != -1) {
            StackTraceElement stackTraceElement = stackTrace[i8];
            logRecord.setSourceClassName(stackTraceElement.getClassName());
            logRecord.setSourceMethodName(stackTraceElement.getMethodName());
        }
    }

    private void log(String str, Level level, String str2, Throwable th) {
        LogRecord logRecord = new LogRecord(level, str2);
        logRecord.setLoggerName(name());
        logRecord.setThrown(th);
        fillCallerData(str, logRecord);
        this.logger.log(logRecord);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str) {
        if (this.logger.isLoggable(Level.INFO)) {
            log(SELF, Level.INFO, str, null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isLoggable(Level.FINE);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isLoggable(Level.SEVERE);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isLoggable(Level.INFO);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isLoggable(Level.FINEST);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isLoggable(Level.WARNING);
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, null);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void info(String str, Object obj, Object obj2) {
        if (this.logger.isLoggable(Level.INFO)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, Level.INFO, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object obj, Object obj2) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void trace(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.FINEST;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Object... objArr) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void debug(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void error(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.SEVERE;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    @Override // io.netty.util.internal.logging.InternalLogger
    public void warn(String str, Throwable th) {
        Logger logger = this.logger;
        Level level = Level.WARNING;
        if (logger.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }
}
