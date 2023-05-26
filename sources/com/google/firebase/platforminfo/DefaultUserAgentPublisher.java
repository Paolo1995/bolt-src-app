package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultUserAgentPublisher implements UserAgentPublisher {

    /* renamed from: a  reason: collision with root package name */
    private final String f17005a;

    /* renamed from: b  reason: collision with root package name */
    private final GlobalLibraryVersionRegistrar f17006b;

    DefaultUserAgentPublisher(Set<LibraryVersion> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.f17005a = e(set);
        this.f17006b = globalLibraryVersionRegistrar;
    }

    public static Component<UserAgentPublisher> c() {
        return Component.c(UserAgentPublisher.class).b(Dependency.l(LibraryVersion.class)).f(new ComponentFactory() { // from class: com.google.firebase.platforminfo.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                UserAgentPublisher d8;
                d8 = DefaultUserAgentPublisher.d(componentContainer);
                return d8;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UserAgentPublisher d(ComponentContainer componentContainer) {
        return new DefaultUserAgentPublisher(componentContainer.b(LibraryVersion.class), GlobalLibraryVersionRegistrar.a());
    }

    private static String e(Set<LibraryVersion> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<LibraryVersion> it = set.iterator();
        while (it.hasNext()) {
            LibraryVersion next = it.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public String a() {
        if (this.f17006b.b().isEmpty()) {
            return this.f17005a;
        }
        return this.f17005a + ' ' + e(this.f17006b.b());
    }
}
