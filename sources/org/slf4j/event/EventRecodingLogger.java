package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.helpers.SubstituteLogger;

/* loaded from: classes5.dex */
public class EventRecodingLogger implements Logger {

    /* renamed from: f  reason: collision with root package name */
    String f52819f;

    /* renamed from: g  reason: collision with root package name */
    SubstituteLogger f52820g;

    /* renamed from: h  reason: collision with root package name */
    Queue<SubstituteLoggingEvent> f52821h;

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.f52820g = substituteLogger;
        this.f52819f = substituteLogger.getName();
        this.f52821h = queue;
    }

    private void b(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        substituteLoggingEvent.j(System.currentTimeMillis());
        substituteLoggingEvent.c(level);
        substituteLoggingEvent.d(this.f52820g);
        substituteLoggingEvent.e(this.f52819f);
        substituteLoggingEvent.f(marker);
        substituteLoggingEvent.g(str);
        substituteLoggingEvent.h(Thread.currentThread().getName());
        substituteLoggingEvent.b(objArr);
        substituteLoggingEvent.i(th);
        this.f52821h.add(substituteLoggingEvent);
    }

    private void c(Level level, Marker marker, String str, Object obj, Object obj2) {
        if (obj2 instanceof Throwable) {
            b(level, marker, str, new Object[]{obj}, (Throwable) obj2);
        } else {
            b(level, marker, str, new Object[]{obj, obj2}, null);
        }
    }

    private void d(Level level, Marker marker, String str, Object[] objArr) {
        Throwable k8 = MessageFormatter.k(objArr);
        if (k8 != null) {
            b(level, marker, str, MessageFormatter.s(objArr), k8);
        } else {
            b(level, marker, str, objArr, null);
        }
    }

    private void e(Level level, Marker marker, String str, Throwable th) {
        b(level, marker, str, null, th);
    }

    private void f(Level level, Marker marker, String str, Object obj) {
        b(level, marker, str, new Object[]{obj}, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str) {
        e(Level.DEBUG, null, str, null);
    }

    @Override // org.slf4j.Logger
    public void error(String str) {
        e(Level.ERROR, null, str, null);
    }

    @Override // org.slf4j.Logger
    public String getName() {
        return this.f52819f;
    }

    @Override // org.slf4j.Logger
    public void info(String str) {
        e(Level.INFO, null, str, null);
    }

    @Override // org.slf4j.Logger
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj) {
        f(Level.TRACE, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public void warn(String str) {
        e(Level.WARN, null, str, null);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj) {
        f(Level.DEBUG, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj) {
        f(Level.ERROR, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public void info(String str, Object obj, Object obj2) {
        c(Level.INFO, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Object obj, Object obj2) {
        c(Level.TRACE, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj) {
        f(Level.WARN, null, str, obj);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object obj, Object obj2) {
        c(Level.DEBUG, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object obj, Object obj2) {
        c(Level.ERROR, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void trace(String str, Throwable th) {
        e(Level.TRACE, null, str, th);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object obj, Object obj2) {
        c(Level.WARN, null, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Object... objArr) {
        d(Level.DEBUG, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Object... objArr) {
        d(Level.ERROR, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Object... objArr) {
        d(Level.WARN, null, str, objArr);
    }

    @Override // org.slf4j.Logger
    public void debug(String str, Throwable th) {
        e(Level.DEBUG, null, str, th);
    }

    @Override // org.slf4j.Logger
    public void error(String str, Throwable th) {
        e(Level.ERROR, null, str, th);
    }

    @Override // org.slf4j.Logger
    public void warn(String str, Throwable th) {
        e(Level.WARN, null, str, th);
    }
}
