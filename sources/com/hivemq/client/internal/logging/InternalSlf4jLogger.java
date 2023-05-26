package com.hivemq.client.internal.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes3.dex */
class InternalSlf4jLogger implements InternalLogger {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f17762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalSlf4jLogger(Class<?> cls) {
        this.f17762a = LoggerFactory.i(cls);
    }

    @Override // com.hivemq.client.internal.logging.InternalLogger
    public void error(String str) {
        this.f17762a.error(str);
    }

    @Override // com.hivemq.client.internal.logging.InternalLogger
    public void warn(String str) {
        this.f17762a.warn(str);
    }

    @Override // com.hivemq.client.internal.logging.InternalLogger
    public void error(String str, Throwable th) {
        this.f17762a.error(str, th);
    }

    @Override // com.hivemq.client.internal.logging.InternalLogger
    public void warn(String str, Object obj) {
        this.f17762a.warn(str, obj);
    }

    @Override // com.hivemq.client.internal.logging.InternalLogger
    public void error(String str, Object obj) {
        this.f17762a.error(str, obj);
    }

    @Override // com.hivemq.client.internal.logging.InternalLogger
    public void warn(String str, Object obj, Object obj2) {
        this.f17762a.warn(str, obj, obj2);
    }

    @Override // com.hivemq.client.internal.logging.InternalLogger
    public void error(String str, Object obj, Object obj2) {
        this.f17762a.error(str, obj, obj2);
    }
}
