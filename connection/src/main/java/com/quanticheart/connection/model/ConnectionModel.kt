package com.quanticheart.connection.model

data class ConnectionModel(
    val baseUrl: String,
    val retrofitInterface: Class<*>,
    val header: HashMap<String, String>? = null,
    val connectionTimeOutMin: Int = 2
)