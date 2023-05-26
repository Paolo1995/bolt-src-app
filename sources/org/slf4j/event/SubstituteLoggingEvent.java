package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

/* loaded from: classes5.dex */
public class SubstituteLoggingEvent implements LoggingEvent {

    /* renamed from: a  reason: collision with root package name */
    Level f52830a;

    /* renamed from: b  reason: collision with root package name */
    Marker f52831b;

    /* renamed from: c  reason: collision with root package name */
    String f52832c;

    /* renamed from: d  reason: collision with root package name */
    SubstituteLogger f52833d;

    /* renamed from: e  reason: collision with root package name */
    String f52834e;

    /* renamed from: f  reason: collision with root package name */
    String f52835f;

    /* renamed from: g  reason: collision with root package name */
    Object[] f52836g;

    /* renamed from: h  reason: collision with root package name */
    long f52837h;

    /* renamed from: i  reason: collision with root package name */
    Throwable f52838i;

    public SubstituteLogger a() {
        return this.f52833d;
    }

    public void b(Object[] objArr) {
        this.f52836g = objArr;
    }

    public void c(Level level) {
        this.f52830a = level;
    }

    public void d(SubstituteLogger substituteLogger) {
        this.f52833d = substituteLogger;
    }

    public void e(String str) {
        this.f52832c = str;
    }

    public void f(Marker marker) {
        this.f52831b = marker;
    }

    public void g(String str) {
        this.f52835f = str;
    }

    public void h(String str) {
        this.f52834e = str;
    }

    public void i(Throwable th) {
        this.f52838i = th;
    }

    public void j(long j8) {
        this.f52837h = j8;
    }
}
