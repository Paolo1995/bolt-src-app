package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;

/* loaded from: classes5.dex */
abstract class NamedLoggerBase implements Logger, Serializable {

    /* renamed from: f  reason: collision with root package name */
    protected String f52844f;

    @Override // org.slf4j.Logger
    public String getName() {
        return this.f52844f;
    }
}
