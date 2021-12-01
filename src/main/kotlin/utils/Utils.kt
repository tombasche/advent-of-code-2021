package utils

import java.io.File

fun readFile(fileName: String) = File(fileName).useLines { it.toList() }
