package com.example.day09application;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomListViewEx extends AppCompatActivity {
    ListView list;// 메인화면에 보여지는 리스트 뷰 선언
    // 1. 문자열과, 이미지 데이터 생성 (배열에 저장하기)
    String[] titles = {
            "The Wizard of Oz (1939)",
            "Citizen Kane (1941)",
            "All About Eve (1950)",
            "The Third Man (1949)",
            "A Hard Day's Night (1964)",
            "Modern Times (1936)",
            "Metropolis (1927)",
            "Metropolis (1927)",
            "Metropolis (1927)",
            "Metropolis (1927)"
    } ;
    Integer[] images = {
            R.drawable.movie1,
            R.drawable.movie2,
            R.drawable.movie3,
            R.drawable.movie4,
            R.drawable.movie5,
            R.drawable.movie6,
            R.drawable.movie7,
            R.drawable.movie7,
            R.drawable.movie7,
            R.drawable.movie7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list=(ListView)findViewById(R.id.list);

        // 3. 커스텀 어댑터 클래스 생성하고, 리스트뷰에 커스텀 어댑터 클래스 연결하기.
        CustomList adapter = new
                CustomList(CustomListViewEx.this);
        list.setAdapter(adapter);

        // 4. 리스트 뷰 항목 클릭 리스너 구현하기.
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CustomListViewEx.this);
                builder.setTitle("알림");
                builder.setMessage(titles[+position]);
                builder.setPositiveButton("확인",null);
                builder.setNeutralButton("취소", null);
                AlertDialog dialog  = builder.create();
                dialog.show();
           }
        });
    }
    // 2. ArrayAdapter 클래스를 상속받은 커스텀 어댑터 클래스를 내부 클래스로 생성하기.
    public class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        // ArrayAdapter 부모 클래스의 생성자를 재정의한다.
        public CustomList(Activity context ) {
            super(context, R.layout.listitem, titles);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
           // 컨텍스트 객체가 xml 레이아웃 파일을 인플레이션 하기 위해 레이아웃인플레이션 객체를 반환받기
            LayoutInflater inflater = context.getLayoutInflater();
            // 인플레이션진행하기(XML레이아웃 파일을 파라미터로 전달하면 컨테이너 뷰 객체가 반환된다.
            View rowView= inflater.inflate(R.layout.listitem, null, true);
            // 반환된 자식뷰에 있는 개별 위젯들을 꺼낸다.
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView title = (TextView) rowView.findViewById(R.id.title);
            TextView rating = (TextView) rowView.findViewById(R.id.rating);
            TextView genre = (TextView) rowView.findViewById(R.id.genre);
            TextView year = (TextView) rowView.findViewById(R.id.releaseYear);
            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            rating.setText("9.0"+position);
            genre.setText("DRAMA");
            year.setText(1930+position+"");
            return rowView;
        }
    }
}
