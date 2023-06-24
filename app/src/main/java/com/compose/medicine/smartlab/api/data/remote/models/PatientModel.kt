package com.compose.medicine.smartlab.api.data.remote.models

class PatientModel(
    val first_name: String,
    val last_name: String,
    val middle_name: String,
    val date_of_birth: String,
    val pol: String,
    val image: String = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Moench_2339.jpg/1200px-Moench_2339.jpg"
)