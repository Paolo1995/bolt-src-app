package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;

/* loaded from: classes5.dex */
public abstract class AbstractInternalLogger implements InternalLogger, Serializable {
    private final String name;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractInternalLogger(String str) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
    }

    public String name() {
        return this.name;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + name() + ')';
    }
}
