package org.slf4j.helpers;

/* loaded from: classes5.dex */
public class NOPLogger extends MarkerIgnoringBase {

    /* renamed from: g  reason: collision with root package name */
    public static final NOPLogger f52843g = new NOPLogger();

    protected NOPLogger() {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void debug(String str, Object... objArr) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void error(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.MarkerIgnoringBase, org.slf4j.helpers.NamedLoggerBase, org.slf4j.Logger
    public String getName() {
        return "NOP";
    }

    @Override // org.slf4j.Logger
    public final void info(String str) {
    }

    @Override // org.slf4j.Logger
    public final void info(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void trace(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Throwable th) {
    }

    @Override // org.slf4j.Logger
    public final void warn(String str, Object... objArr) {
    }
}
