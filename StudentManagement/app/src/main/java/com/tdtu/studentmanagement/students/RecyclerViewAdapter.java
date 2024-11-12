package com.tdtu.studentmanagement.students;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tdtu.studentmanagement.EditStudentInformationActivity;
import com.tdtu.studentmanagement.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<Student> studentList;
    private String role;
    private DatabaseReference databaseReference;

    public RecyclerViewAdapter(Context context, List<Student> studentList, String role) {
        this.context = context;
        this.studentList = studentList;
        this.role = role;
        this.databaseReference = FirebaseDatabase.getInstance("https://midterm-project-b5158-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Students");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);

        if ("employee".equals(role)) {
            holder.btnDeleteStudent.setVisibility(View.GONE);
        } else {
            holder.btnDeleteStudent.setVisibility(View.VISIBLE);
        }

        holder.btnDeleteStudent.setOnClickListener(v -> deleteStudent(student, position));

        holder.btnEditStudent.setOnClickListener(view -> {
            Intent intent = new Intent(context, EditStudentInformationActivity.class);

            // Truyền thông tin sinh viên qua Intent
            intent.putExtra("studentId", student.getStudentId());
            intent.putExtra("name", student.getName());
            intent.putExtra("age", student.getAge());
            intent.putExtra("phoneNumber", student.getPhoneNumber());
            intent.putExtra("email", student.getEmail());
            intent.putExtra("address", student.getAddress());

            context.startActivity(intent);
        });
    }

    private void deleteStudent(Student student, int position) {
        // Xóa sinh viên khỏi Firebase Database
        databaseReference.child(student.getStudentId()).removeValue()
                .addOnSuccessListener(aVoid -> {
                    // Xóa sinh viên khỏi danh sách và cập nhật RecyclerView
                    studentList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, studentList.size());
                    Toast.makeText(context, "Student deleted successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> Toast.makeText(context, "Failed to delete student", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    // Cập nhật dữ liệu trong adapter
    public void updateStudentList(List<Student> newList) {
        this.studentList = newList;
        notifyDataSetChanged();
    }
}
