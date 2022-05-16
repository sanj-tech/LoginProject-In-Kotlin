package com.example.roomdbtest

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.roomdbtest.db.PersonalInfo
import com.example.roomdbtest.db.PersonalInfoRepository
import java.text.SimpleDateFormat
import java.util.*

class PersonalDetailActivity : AppCompatActivity() {
    lateinit var pickDate: EditText
    lateinit var anversary: EditText
    lateinit var mySpinner: Spinner
    lateinit var saveButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_detail)
        initView()
        spinnerView()
        clickListener()
    }

    private fun clickListener() {
        saveButton = findViewById(R.id.btSave)

        saveButton.setOnClickListener(setOnClickListener@{
            var edtownerName = findViewById<EditText>(R.id.et_ownerName)
            var edtretailName = findViewById<EditText>(R.id.et_retail_name)
            var edtmobileNumber = findViewById<EditText>(R.id.et_mobile)
            var edtmobileNumber2 = findViewById<EditText>(R.id.et_mobile_number2)
            var edtemail = findViewById<EditText>(R.id.et_email_id)
            var edtpickDate = findViewById<EditText>(R.id.et_pick_date)
            var edtaddress = findViewById<EditText>(R.id.et_address_oulet)
            // var edtspinner=findViewById<Spinner>(R.id.spinner)
            var edtcity = findViewById<EditText>(R.id.et_city)
            var edtpincode = findViewById<EditText>(R.id.et_pincode)
            var edtanversary_date = findViewById<EditText>(R.id.et_anversary)

            var owner = edtownerName.text.toString()
            var retail = edtretailName.text.toString()
            var mobile1 = edtmobileNumber.text.toString()
            var mobile2 = edtmobileNumber2.text.toString()
            var email = edtemail.text.toString()
            var date = edtpickDate.text.toString()
            var address = edtaddress.text.toString()
            //var spinner=edtspinner.get(0)
            var city = edtcity.text.toString()
            var pincode = edtpincode.text.toString()
            var anversary = edtanversary_date.text.toString()
//Validation of Personal Detail Form
            if (owner.isBlank() && retail.isBlank()
                && date.isBlank() && address.isBlank() && city.isBlank() && pincode.isBlank()
                && anversary.isBlank()
            ) {
                Toast.makeText(this, "Please enter desired field", Toast.LENGTH_LONG).show()
                edtownerName.error = "Owner Name Required"
                edtretailName.error = "Retail name Required"
                edtpickDate.error = "Select Date"
                edtaddress.error = "Address name Required"
                edtpincode.error = "Pincode name Required"
                edtanversary_date.error = "Anversary date Required"
                return@setOnClickListener
            } else
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtemail.error = "Invalid Email Address"
                    return@setOnClickListener
                } else
                    if (mobile1.length < 11) {
                        edtmobileNumber.error = "Minimum 11 digits required"
                        return@setOnClickListener
                    } else
                        if (mobile2.length < 11) {
                            edtmobileNumber2.error = "Minimum 11 digits required"
                            return@setOnClickListener
                        } else {
                            var personalDetail = PersonalInfo(
                                owner, retail,
                                mobile1, mobile2, email, date, address, city, pincode, anversary
                            )

                            PersonalInfoRepository(this).saveData(personalDetail)
                            Toast.makeText(
                                this,
                                "detail is $owner,$retail,$mobile1,$mobile2,$email,$,$date,$address,$city,$pincode,$anversary",
                                Toast.LENGTH_LONG
                            ).show()

                        }
        })
    }

    private fun spinnerView() {
        mySpinner = findViewById(R.id.spinner)
        var state = mutableListOf("Maharashtra", "MadhyaPradesh", "Maharashtra", "Maharashtra")

        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, state)

        mySpinner.adapter = spinnerAdapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedState = state[p2]

                Toast.makeText(
                    applicationContext,
                    "Selected Value is $selectedState",
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


    }

    private fun initView() {
        pickDate = findViewById(R.id.et_pick_date)
        anversary = findViewById(R.id.et_anversary)

        val mycalander = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener({ view, year, month, dayOfMonth ->
            mycalander.set(Calendar.YEAR, year)
            mycalander.set(Calendar.MONTH, month)
            mycalander.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(mycalander)

        })
        pickDate.setOnClickListener({
            DatePickerDialog(
                this,
                datePicker,
                mycalander.get(Calendar.YEAR),
                mycalander.get(Calendar.MONTH),
                mycalander.get(Calendar.DAY_OF_MONTH)
            ).show()
        })
        anversary.setOnClickListener({
            DatePickerDialog(
                this,
                datePicker,
                mycalander.get(Calendar.YEAR),
                mycalander.get(Calendar.MONTH),
                mycalander.get(Calendar.DAY_OF_MONTH)
            ).show()
        })


    }


    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        pickDate.setText(sdf.format(myCalendar.time))
        anversary.setText(sdf.format(myCalendar.time))

    }


}