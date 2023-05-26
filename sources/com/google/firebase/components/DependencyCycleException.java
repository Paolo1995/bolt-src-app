package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class DependencyCycleException extends DependencyException {

    /* renamed from: f  reason: collision with root package name */
    private final List<Component<?>> f15490f;

    public DependencyCycleException(List<Component<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f15490f = list;
    }
}
