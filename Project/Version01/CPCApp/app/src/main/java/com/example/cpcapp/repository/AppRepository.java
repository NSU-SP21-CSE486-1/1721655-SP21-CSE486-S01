package com.example.cpcapp.repository;



import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.example.cpcapp.datasource.StudentInfoAPI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class AppRepository {

    private static AppRepository instance;
    private final FirebaseDatabase firebaseRef;
    private final FirebaseAuth firebaseAuth;
    private final DatabaseReference dbRef;
    private boolean check2;

    private List<StudentInfoAPI> mAllStudent;
    private MutableLiveData<List<StudentInfoAPI>> mStudents;
    private String tag = AppRepository.class.getSimpleName();

    public AppRepository(){
        mAllStudent = new ArrayList<>();
        mStudents = new MutableLiveData<>();
        firebaseRef = FirebaseDatabase.getInstance();
        dbRef = firebaseRef.getReference("students");
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public static AppRepository getInstance(){
        if(instance == null){
            instance = new AppRepository();
        }
        return instance;
    }

   public DatabaseReference getDbRef(){
        return dbRef;
   }



    public boolean registerStudent(String email, String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    check2 = true;
                }else{
                    check2 = false;
                }
            }
        });

        return check2;

    }


}

