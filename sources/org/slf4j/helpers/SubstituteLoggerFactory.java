package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.event.SubstituteLoggingEvent;

/* loaded from: classes5.dex */
public class SubstituteLoggerFactory implements ILoggerFactory {

    /* renamed from: a  reason: collision with root package name */
    boolean f52852a = false;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, SubstituteLogger> f52853b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final LinkedBlockingQueue<SubstituteLoggingEvent> f52854c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.ILoggerFactory
    public synchronized Logger a(String str) {
        SubstituteLogger substituteLogger;
        substituteLogger = this.f52853b.get(str);
        if (substituteLogger == null) {
            substituteLogger = new SubstituteLogger(str, this.f52854c, this.f52852a);
            this.f52853b.put(str, substituteLogger);
        }
        return substituteLogger;
    }

    public void b() {
        this.f52853b.clear();
        this.f52854c.clear();
    }

    public LinkedBlockingQueue<SubstituteLoggingEvent> c() {
        return this.f52854c;
    }

    public List<SubstituteLogger> d() {
        return new ArrayList(this.f52853b.values());
    }

    public void e() {
        this.f52852a = true;
    }
}
