package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CTInAppNativeHeaderFragment extends CTInAppBasePartialNativeFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        View inflate = layoutInflater.inflate(R$layout.inapp_header, viewGroup, false);
        this.f11305n = inflate;
        RelativeLayout relativeLayout = (RelativeLayout) ((FrameLayout) inflate.findViewById(R$id.header_frame_layout)).findViewById(R$id.header_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(this.f11287j.c()));
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R$id.header_linear_layout_2);
        LinearLayout linearLayout2 = (LinearLayout) relativeLayout.findViewById(R$id.header_linear_layout_3);
        Button button = (Button) linearLayout2.findViewById(R$id.header_button_1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout2.findViewById(R$id.header_button_2);
        arrayList.add(button2);
        ImageView imageView = (ImageView) ((LinearLayout) relativeLayout.findViewById(R$id.header_linear_layout_1)).findViewById(R$id.header_icon);
        if (!this.f11287j.u().isEmpty()) {
            CTInAppNotification cTInAppNotification = this.f11287j;
            Bitmap p8 = cTInAppNotification.p(cTInAppNotification.u().get(0));
            if (p8 != null) {
                imageView.setImageBitmap(p8);
            } else {
                imageView.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) linearLayout.findViewById(R$id.header_title);
        textView.setText(this.f11287j.B());
        textView.setTextColor(Color.parseColor(this.f11287j.C()));
        TextView textView2 = (TextView) linearLayout.findViewById(R$id.header_message);
        textView2.setText(this.f11287j.v());
        textView2.setTextColor(Color.parseColor(this.f11287j.x()));
        ArrayList<CTInAppNotificationButton> f8 = this.f11287j.f();
        if (f8 != null && !f8.isEmpty()) {
            for (int i8 = 0; i8 < f8.size(); i8++) {
                if (i8 < 2) {
                    O((Button) arrayList.get(i8), f8.get(i8), i8);
                }
            }
        }
        if (this.f11287j.e() == 1) {
            N(button, button2);
        }
        this.f11305n.setOnTouchListener(new View.OnTouchListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeHeaderFragment.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                CTInAppNativeHeaderFragment.this.f11304m.onTouchEvent(motionEvent);
                return true;
            }
        });
        return this.f11305n;
    }
}
