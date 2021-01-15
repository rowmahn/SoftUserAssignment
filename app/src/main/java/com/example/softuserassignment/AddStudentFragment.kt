package com.example.softuserassignment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import com.example.softuserassignment.model.Student

class AddStudentFragment : AppCompatActivity() {

    private lateinit var etFname: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var rg: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOthers: RadioButton
    private lateinit var btnSave: Button

    private var gender=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student_fragment)


        fun clearText() {
            etFname.text.clear()
            etAddress.text.clear()
            etAge.text.clear()
            rg.clearCheck()
        }

        fun validate(): Boolean {

            var flag = true
            if (TextUtils.isEmpty(etFname.text)) {
                etFname.error = "Please enter Name"
                etFname.requestFocus()
                return false
            }
            if (TextUtils.isEmpty(etAge.text)) {
                etAge.error = "Please enter Age"
                etAge.requestFocus()
                return false
            }
            if (rg.checkedRadioButtonId == -1){
                Toast.makeText(this@AddStudentFragment as Context?, "Please select a Gender", Toast.LENGTH_SHORT).show()
                return false
            }
            if (TextUtils.isEmpty(etAddress.text)) {
                etAddress.error = "Please enter Address"
                etAddress.requestFocus()
                return false
            }

            return flag

        }

         fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View? {
            val view = layoutInflater.inflate(R.layout.activity_add_student_fragment, container, false)
            etFname = view?.findViewById(R.id.etFname) as EditText
            etAge = view?.findViewById(R.id.etAge) as EditText
            etAddress = view?.findViewById(R.id.etAddress) as EditText
            rg = view?.findViewById(R.id.rg) as RadioGroup
            rbMale = view?.findViewById(R.id.rbMale) as RadioButton
            rbFemale = view?.findViewById(R.id.rbFemale) as RadioButton
            rbOthers = view?.findViewById(R.id.rbOthers) as RadioButton
            btnSave = view?.findViewById(R.id.btnLogin) as Button
            btnSave.setOnClickListener{
                if(validate()) {
                    var name: String
                    var age: String
                    var address: String

                    name = etFname.text.toString()
                    age = etAge.text.toString()
                    address = etAddress.text.toString()
                    when {
                        rbMale.isChecked -> {
                            gender = "Male"
                        }
                        rbFemale.isChecked -> {
                            gender = "Female"
                        }
                        rbOthers.isChecked -> {
                            gender = "Others"
                        }
                    }
                    StudentListNavActivity.StudentList.add(Student(name, age, gender, address))
                    Toast.makeText(this@AddStudentFragment as Context?, "Student Added", Toast.LENGTH_SHORT).show()
                    clearText()

                }
            }
            return view
        }

    }
}