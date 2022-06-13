package org.techtown.databinding_ex3;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class User {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean fav = new ObservableBoolean();

    public User(String name, int age, boolean fav) {
        this.name.set(name);
        this.age.set(age);
        this.fav.set(fav);

    }

    public void changeName(View view) {
        name.set("jung");
    }

    public void increaseAge(View view) {
        age.set(age.get() + 1);
    }

    public void toggleFav(View view) {
        fav.set(!fav.get());
    }

    public void changeFav(CompoundButton view, boolean isChecked) {
        fav.set(isChecked);

        Toast.makeText(view.getContext(), "fac : " + fav.get(), Toast.LENGTH_SHORT).show();

    }

    public void changeName() {
        this.name.set("HONG");
    }
}
