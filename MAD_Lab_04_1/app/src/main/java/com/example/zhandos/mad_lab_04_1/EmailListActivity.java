package com.example.zhandos.mad_lab_04_1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EmailListActivity extends AppCompatActivity {

    ArrayList<Email> list;
    ListView lvEmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);

        initList();
        EmailsAdapter adapter = new EmailsAdapter(getApplicationContext(), list);

        lvEmails = (ListView) findViewById(R.id.lvEmails);
        lvEmails.setAdapter(adapter);
        lvEmails.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Email email = list.get(i);
                Intent intent = new Intent(getApplicationContext(), EmailDetailsActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }

    private void initList(){

        list = new ArrayList<Email>();

        list.add(new Email(1, "Alikhan", "azamat@mail.ru", "01/01/2017", "Hello there!",
                "Birthday", "Hello, Zhandos, I'm glad to invite you to my Birthday event"));
        list.add(new Email(2, "Azamat", "", "03/07/2017", "IELTS results",
                "IELTS", "Hello, Alan, I'm glad to inform you about IELTS results"));
        list.add(new Email(3, "Mirzhana", "okapova@gmail.com, seiilbekova@gmail.com", "01/01/2017", "Schedule changes",
                "Schedule", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"));
        list.add(new Email(4, "Akerke", "", "02/02/2016", "Mobile Application Development",
                "MAD", "t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. "));
        list.add(new Email(5, "Amina", "tulebaeva.b@yahoo.com", "06/05/2011", "Nazarbayev came to Almaty",
                "Almaty Today", "Fusce ac pulvinar velit. Cras iaculis elit ac vulputate semper. Quisque consectetur libero sit amet gravida semper. Lorem ipsum dolor."));
        list.add(new Email(6, "Zhandos", "", "31/12/2013", "Software Project Management project",
                "SPM", "Cras finibus mauris id lorem elementum, eu tincidunt turpis aliquam. Maecenas efficitur nibh velit, vitae vestibulum odio tempor ac. Suspendisse."));
        list.add(new Email(7, "Artur", "", "13/12/2016", "Kuanysh's Birthday organization",
                "Birthday organization", "Nam tincidunt ex eu ex posuere, in tincidunt dui ultricies. Praesent euismod, urna et tincidunt sodales, leo sem finibus tellus."));
        list.add(new Email(8, "Kuanysh", "", "21/06/2014", "Internship results",
                "Summer internship", "Suspendisse nisl tortor, suscipit a lectus in, volutpat lobortis massa. Phasellus vel purus nunc. Curabitur pulvinar dolor at nulla convallis."));
        list.add(new Email(9, "Amanzhol", "", "23/02/2010", "Google invitation",
                "Google", "Nullam vehicula volutpat orci a semper. Aliquam volutpat enim non enim pharetra efficitur. Pellentesque urna sapien, sagittis nec gravida et."));
        list.add(new Email(10, "Alisher", "", "02/03/2011", "ACM group acceptance",
                "ACM", "Quisque tincidunt dictum ligula, eget hendrerit risus ornare ut. Praesent nisi ligula, faucibus eget urna nec, aliquam egestas orci. Phasellus."));

    }
}
class EmailsAdapter extends ArrayAdapter<Email> {

    public EmailsAdapter(Context context, ArrayList<Email> emails) {
        super(context, 0, emails);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Email email = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.email_list_item, parent, false);
        }
        TextView tvSender = (TextView) convertView.findViewById(R.id.tvSender);
        TextView tvSubject = (TextView) convertView.findViewById(R.id.tvSubject);

        tvSender.setText("from: " + email.getSender());
        tvSubject.setText(email.getSubject());
        return convertView;
    }
}
