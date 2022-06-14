package org.techtown.databinding_ex3;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class User {

    //값 변경이 관찰되는 멤버변수 ObservableXXX : primitive type XXX && List Or Map  && Reference type is ObservableField<>
    public ObservableField<String> name= new ObservableField<>();
    public ObservableInt age= new ObservableInt();
    public ObservableBoolean fav= new ObservableBoolean();


    //constructor
    public User(String name, int age, boolean fav) {
        this.name.set(name);
        this.age.set(age);
        this.fav.set(fav);
    }

    //change name click callback method : onclick속성에 반응하는 액티비티의 콜백메소드 작업을 데이터가 있는 이 클래스에서 코
    public void changeName(View view){
        name.set("ROBIN"); //Observable객체들의 값 변경은 반드시 set()을 해야 자동 값 갱신이 이루어짐 [ ObservableXXX 객체들은 어차피 = 대입연산자 사용 못함]
    }

    //increase age by click .. callback method
    public void increaseAge(View view){
        age.set( age.get() + 1 ); // ++연산이 불가하가이 get()으로 가져온 값에 1을 더한 값을 set()
    }

    //toggle fav by button click... callback method
    public void toggleFav(View v){
        fav.set(!fav.get());
    }

    //onCheckedChanged 일때 User객체의 fav값도 같이 변경하기 - 체크상태 변경 리스너의 콜백메소드를 그대로 만들
    public void changeFav(CompoundButton view, boolean isChecked){
        //fav의 값에 의해 체크박스의 체크상태는 자동반영되지만.. 반대로
        //체크박스의 체크상태를 변경했을때 fav멤버값이 자동으로 변경되지 않기에...직접 set
        fav.set(isChecked);
        //값이 제대로 변경되었는지 확인
        Toast.makeText(view.getContext(), "fav : " + fav.get(), Toast.LENGTH_SHORT).show();
    }


    //callback메소드가 아닌 일반 메소능 - 람다식을 이용하여 onClick에 반
    public void changeName(){
        this.name.set("HONG");
    }



    //EditText의 글씨 변경값을 저장하는 관찰되고 있는 멤버값
    public ObservableField<String> msg= new ObservableField<>();

    //EditText의 TextChanged event callback method... [ TextWatcher 클래스의 콜백메소드 - 파라미터 참고 ]
    public void onTextChanged(CharSequence s, int start, int before, int count){
        //변경될때 마다의 글씨
        msg.set(s.toString());
    }



    //EditText의 값 변경시마다의 글씨를 일반 멤버변수에 저장
    String titleStr="";

    public void changedTitle(CharSequence s){
        titleStr= s.toString();
    }

    //버튼 클릭시에 저장되어 있는 title변수의 값을 ObservableField<>의 변수값으로 설정
    public ObservableField<String> title= new ObservableField<>(""); //""값으로 초기화

    //버튼 클릭 콜백메소드
    public void clickBtn(View v){
        title.set(titleStr);
    }

    // 이렇게 데이터를 가지고 있고 데이터의 값을 변경하는 코드가 있는 클래스가 MVVM에서 MiewModel 의 역할을 하게됨.

}
