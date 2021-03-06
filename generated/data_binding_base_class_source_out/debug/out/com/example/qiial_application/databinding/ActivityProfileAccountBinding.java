// Generated by view binder compiler. Do not edit!
package com.example.qiial_application.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.qiial_application.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileAccountBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView emailAddress;

  @NonNull
  public final TextView emailAddressTitle;

  @NonNull
  public final TextView greeting;

  @NonNull
  public final TextView greetingTitle;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout layoutContent1;

  @NonNull
  public final ConstraintLayout layoutHeader;

  @NonNull
  public final Button logout;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView nameTitle;

  @NonNull
  public final BottomNavigationView navbar;

  @NonNull
  public final TextView surname;

  @NonNull
  public final TextView surnameTitle;

  @NonNull
  public final TextView textBrand;

  @NonNull
  public final TextView username;

  @NonNull
  public final TextView usernameTitle;

  private ActivityProfileAccountBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView emailAddress, @NonNull TextView emailAddressTitle,
      @NonNull TextView greeting, @NonNull TextView greetingTitle, @NonNull ImageView imageView,
      @NonNull LinearLayout layoutContent1, @NonNull ConstraintLayout layoutHeader,
      @NonNull Button logout, @NonNull TextView name, @NonNull TextView nameTitle,
      @NonNull BottomNavigationView navbar, @NonNull TextView surname,
      @NonNull TextView surnameTitle, @NonNull TextView textBrand, @NonNull TextView username,
      @NonNull TextView usernameTitle) {
    this.rootView = rootView;
    this.emailAddress = emailAddress;
    this.emailAddressTitle = emailAddressTitle;
    this.greeting = greeting;
    this.greetingTitle = greetingTitle;
    this.imageView = imageView;
    this.layoutContent1 = layoutContent1;
    this.layoutHeader = layoutHeader;
    this.logout = logout;
    this.name = name;
    this.nameTitle = nameTitle;
    this.navbar = navbar;
    this.surname = surname;
    this.surnameTitle = surnameTitle;
    this.textBrand = textBrand;
    this.username = username;
    this.usernameTitle = usernameTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile_account, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileAccountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.emailAddress;
      TextView emailAddress = ViewBindings.findChildViewById(rootView, id);
      if (emailAddress == null) {
        break missingId;
      }

      id = R.id.emailAddressTitle;
      TextView emailAddressTitle = ViewBindings.findChildViewById(rootView, id);
      if (emailAddressTitle == null) {
        break missingId;
      }

      id = R.id.greeting;
      TextView greeting = ViewBindings.findChildViewById(rootView, id);
      if (greeting == null) {
        break missingId;
      }

      id = R.id.greetingTitle;
      TextView greetingTitle = ViewBindings.findChildViewById(rootView, id);
      if (greetingTitle == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.layoutContent1;
      LinearLayout layoutContent1 = ViewBindings.findChildViewById(rootView, id);
      if (layoutContent1 == null) {
        break missingId;
      }

      id = R.id.layoutHeader;
      ConstraintLayout layoutHeader = ViewBindings.findChildViewById(rootView, id);
      if (layoutHeader == null) {
        break missingId;
      }

      id = R.id.logout;
      Button logout = ViewBindings.findChildViewById(rootView, id);
      if (logout == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.nameTitle;
      TextView nameTitle = ViewBindings.findChildViewById(rootView, id);
      if (nameTitle == null) {
        break missingId;
      }

      id = R.id.navbar;
      BottomNavigationView navbar = ViewBindings.findChildViewById(rootView, id);
      if (navbar == null) {
        break missingId;
      }

      id = R.id.surname;
      TextView surname = ViewBindings.findChildViewById(rootView, id);
      if (surname == null) {
        break missingId;
      }

      id = R.id.surnameTitle;
      TextView surnameTitle = ViewBindings.findChildViewById(rootView, id);
      if (surnameTitle == null) {
        break missingId;
      }

      id = R.id.textBrand;
      TextView textBrand = ViewBindings.findChildViewById(rootView, id);
      if (textBrand == null) {
        break missingId;
      }

      id = R.id.username;
      TextView username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      id = R.id.usernameTitle;
      TextView usernameTitle = ViewBindings.findChildViewById(rootView, id);
      if (usernameTitle == null) {
        break missingId;
      }

      return new ActivityProfileAccountBinding((ConstraintLayout) rootView, emailAddress,
          emailAddressTitle, greeting, greetingTitle, imageView, layoutContent1, layoutHeader,
          logout, name, nameTitle, navbar, surname, surnameTitle, textBrand, username,
          usernameTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
