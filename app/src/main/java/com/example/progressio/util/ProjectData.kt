package com.example.progressio.util

import java.util.Date

data class ProjectData(
    var projectID: String,
    var name: String,
    var description: String,
    var priority: String,
    var dueDate: Date
)
