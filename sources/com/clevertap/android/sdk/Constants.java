package com.clevertap.android.sdk;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
public interface Constants {

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f10925a = new SimpleDateFormat("MM/dd/yyyy", Locale.US);

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f10926b = {"Notification Clicked", "Notification Viewed", "Geocluster Entered", "Geocluster Exited"};

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<String> f10927c = new HashSet<>(Arrays.asList("Identity", "Email"));

    /* renamed from: d  reason: collision with root package name */
    public static final HashSet<String> f10928d = new HashSet<>(Arrays.asList("Identity", "Email", "Phone"));

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f10929e = new String[0];
}
