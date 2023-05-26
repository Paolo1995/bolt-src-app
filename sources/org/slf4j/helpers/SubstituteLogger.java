package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

/* loaded from: classes5.dex */
public class SubstituteLogger implements Logger {

    /* renamed from: f  reason: collision with root package name */
    private final String f52845f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Logger f52846g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f52847h;

    /* renamed from: i  reason: collision with root package name */
    private Method f52848i;

    /* renamed from: j  reason: collision with root package name */
    private EventRecodingLogger f52849j;

    /* renamed from: k  reason: collision with root package name */
    private Queue<SubstituteLoggingEvent> f52850k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f52851l;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z7) {
        this.f52845f = str;
        this.f52850k = queue;
        this.f52851l = z7;
    }

    private Logger c() {
        if (this.f52849j == null) {
            this.f52849j = new EventRecodingLogger(this, this.f52850k);
        }
        return this.f52849j;
    }

    Logger b() {
        if (this.f52846g != null) {
            return this.f52846g;
        }
        if (this.f52851l) {
            return NOPLogger.f52843g;
        }
        return c();
    }

    public boolean d() {
        Boolean bool = this.f52847h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f52848i = this.f52846g.getClass().getMethod("log", LoggingEvent.class);
            this.f52847h = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f52847h = Boolean.FALSE;
        }
        return this.f52847h.booleanValue();
    }

    @Override // org.slf4j.Logger
    public void debug(String str) {
        b().debug(str);
    }

    public boolean e() {
        return this.f52846g instanceof NOPLogger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f52845f.equals(((SubstituteLogger) obj).f52845f)) {
            return true;
        }
        return false;
    }

    @Override // org.slf4j.Logger
    public void error(String str) {
        b().error(str);
    }

    public boolean f() {
        if (this.f52846g == null) {
            return true;
        }
        return false;
    }

    public void g(LoggingEvent loggingEvent) {
        if (d()) {
            try {
                this.f52848i.invoke(this.f52846g, loggingEvent);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // org.slf4j.Logger
    public String getName() {
        return this.f52845f;
    }

    public void h(Logger logger) {
        this.f52846g = logger;
    }

    public int hashCode() {
        return this.f52845f.hashCode();
    }

    @Override // org.slf4j.Logger
    public void info(String str) {
        b().info(str);
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled() {
        return b().isDebugEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled() {
        return b().isErrorEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled() {
        return b().isInfoEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled() {
        return b().isTraceEnabled();
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled() {
        return b().isWarnEnabled();
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj) {
        b().trace(str, obj);
    }

    @Override // org.slf4j.Logger
    public void warn(String str) {
        b().warn(str);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj) {
        b().debug(str, obj);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj) {
        b().error(str, obj);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object obj, Object obj2) {
        b().info(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj, Object obj2) {
        b().trace(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj) {
        b().warn(str, obj);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        b().debug(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj, Object obj2) {
        b().error(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Throwable th) {
        b().trace(str, th);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj, Object obj2) {
        b().warn(str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object... objArr) {
        b().debug(str, objArr);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object... objArr) {
        b().error(str, objArr);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object... objArr) {
        b().warn(str, objArr);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Throwable th) {
        b().debug(str, th);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Throwable th) {
        b().error(str, th);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Throwable th) {
        b().warn(str, th);
    }
}
