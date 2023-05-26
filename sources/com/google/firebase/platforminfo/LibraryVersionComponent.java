package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

/* loaded from: classes3.dex */
public class LibraryVersionComponent {

    /* loaded from: classes3.dex */
    public interface VersionExtractor<T> {
        String a(T t7);
    }

    private LibraryVersionComponent() {
    }

    public static Component<?> b(String str, String str2) {
        return Component.i(LibraryVersion.a(str, str2), LibraryVersion.class);
    }

    public static Component<?> c(final String str, final VersionExtractor<Context> versionExtractor) {
        return Component.j(LibraryVersion.class).b(Dependency.j(Context.class)).f(new ComponentFactory() { // from class: com.google.firebase.platforminfo.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                LibraryVersion d8;
                d8 = LibraryVersionComponent.d(str, versionExtractor, componentContainer);
                return d8;
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LibraryVersion d(String str, VersionExtractor versionExtractor, ComponentContainer componentContainer) {
        return LibraryVersion.a(str, versionExtractor.a((Context) componentContainer.get(Context.class)));
    }
}
