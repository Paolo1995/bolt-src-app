package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CTInAppNativeCoverFragment extends CTInAppBaseFullNativeFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        View inflate = layoutInflater.inflate(R$layout.inapp_cover, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_cover_frame_layout);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.cover_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(this.f11287j.c()));
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R$id.cover_linear_layout);
        Button button = (Button) linearLayout.findViewById(R$id.cover_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(R$id.cover_button2);
        arrayList.add(button2);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R$id.backgroundImage);
        if (this.f11287j.q(this.f11286i) != null) {
            CTInAppNotification cTInAppNotification = this.f11287j;
            if (cTInAppNotification.p(cTInAppNotification.q(this.f11286i)) != null) {
                CTInAppNotification cTInAppNotification2 = this.f11287j;
                imageView.setImageBitmap(cTInAppNotification2.p(cTInAppNotification2.q(this.f11286i)));
                imageView.setTag(0);
                imageView.setOnClickListener(new CTInAppBaseFragment.CTInAppNativeButtonClickListener());
            }
        }
        TextView textView = (TextView) relativeLayout.findViewById(R$id.cover_title);
        textView.setText(this.f11287j.B());
        textView.setTextColor(Color.parseColor(this.f11287j.C()));
        TextView textView2 = (TextView) relativeLayout.findViewById(R$id.cover_message);
        textView2.setText(this.f11287j.v());
        textView2.setTextColor(Color.parseColor(this.f11287j.x()));
        ArrayList<CTInAppNotificationButton> f8 = this.f11287j.f();
        if (f8.size() == 1) {
            int i8 = this.f11286i;
            if (i8 == 2) {
                button.setVisibility(8);
            } else if (i8 == 1) {
                button.setVisibility(4);
            }
            Y(button2, f8.get(0), 0);
        } else if (!f8.isEmpty()) {
            for (int i9 = 0; i9 < f8.size(); i9++) {
                if (i9 < 2) {
                    Y((Button) arrayList.get(i9), f8.get(i9), i9);
                }
            }
        }
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.CTInAppNativeCoverFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CTInAppNativeCoverFragment.this.F(null);
                CTInAppNativeCoverFragment.this.getActivity().finish();
            }
        });
        if (!this.f11287j.M()) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return inflate;
    }
}
